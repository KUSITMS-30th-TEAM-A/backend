package kusitms.backend.auth.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kusitms.backend.auth.status.AuthErrorStatus;
import kusitms.backend.global.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws CustomException, ServletException, IOException {
        try {
            String accessToken = getAccessTokenFromCookies(request);
            jwtUtil.validateToken(accessToken);
        }
        catch (CustomException e) {
            handleCustomException(response, e);
            return;
        }
        catch (Exception e) {
            handleException(response, e);  // 기타 예외 처리
            return;
        }
        filterChain.doFilter(request, response);
    }

    // 필터를 적용하지 않을 경로 설정
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        return path.equals("/") || path.equals("/login") || path.startsWith("/public")
                || path.equals("/test-error") || path.equals("/health-check");
    }

    // 쿠키에서 액세스 토큰 추출
    private String getAccessTokenFromCookies(HttpServletRequest request) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("accessToken".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        throw new CustomException(AuthErrorStatus._MISSING_TOKEN);
    }

    // 토큰 예외 처리 메서드
    private void handleCustomException(HttpServletResponse response, CustomException e) throws IOException {
        log.error("JWT 커스텀 예외 발생: {}", e.getMessage());
        response.setStatus(e.getHttpStatus().value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String jsonResponse = String.format("{\"code\": \"%s\", \"message\": \"%s\", \"isSuccess\": \"false\"}", e.getCode(), e.getMessage());
        response.getWriter().write(jsonResponse);
    }

    // 토큰 예외 처리 메서드
    private void handleException(HttpServletResponse response, Exception e) throws IOException {
        log.error("서버 예외 발생: {}", e.getMessage());
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String jsonResponse = String.format("{\"code\": \"%s\", \"message\": \"%s\", \"isSuccess\": \"false\"}", "500", e.getMessage());
        response.getWriter().write(jsonResponse);
    }
}