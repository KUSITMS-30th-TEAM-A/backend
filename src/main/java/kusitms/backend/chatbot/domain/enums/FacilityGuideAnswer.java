package kusitms.backend.chatbot.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FacilityGuideAnswer implements GuideAnswer {

    Q1_LG(1, "lg",
            new String[]{
                    "• 1루 내야, 3루 내야 (삼겹살쪽 하나, 명인만두쪽 하나)\n" +
                            "• 가격 1500원 (500원짜리 동전 3개 필요)"
            }, null),

    Q1_KT(1, "kt",
            new String[]{
                    "1. 위치\n" +
                            "• 1루 물품 보관소 : 1루 메인 게이트 하단, WIZ 게이트 앞에 위치\n" +
                            "• 3루 물품 보관소 : 3루 메인 게이트 하단, AWAY 게이트 앞에 위치",

                    "2. 동선\n" +
                            "• 1층 1호기 E/V 쪽으로 이동"
            }, null),

    Q1_NONE(1, null,
            new String[]{
                    "해당 구장에 대한 정보는 준비 중입니다. 빠른 시일 내에 정확한 정보를 준비해 안내드릴게요!"
            }, null),

    Q2_LG(2, "lg",
            new String[]{
                    "1. 1층\n" +
                            "• GATE1-2 ~3루 내야 출입구 사이 : A03 (잠실원샷) - A04(GS25) 사이\n" +
                            "• GATE 1-5 ~ 1루 내야 출입구 사이 : A09 (도미노피자)옆",

                    "2. 외야\n" +
                            "• A26, A16 (GS25) 옆",

                    "3. 2층\n" +
                            "• GATE 2-1 앞 : B03 (피자헛) 옆\n" +
                            "• GATE 2-2 앞 : B14 (원정 구단 상품샵) 옆\n" +
                            "• GATE 2-3 : B18 (프로스펙스 어쎈틱샵) 옆, B35 (피자헛) 옆",

                    "4. 3층\n" +
                            "• D01(GS25)~D02(스태프 핫도그) 사이\n" +
                            "• D04 (KFC)~D05(GS25) 사이 (여자화장실만 있어요!)\n" +
                            "• D06(와팡)~D07(BBQ) 사이\n" +
                            "• D08(GS25)~D09 (프랭크버거)사이 (여자화장실만 있어요!)\n" +
                            "• D10(GS25)~D12(GS25) 사이"
            }, null),

    Q2_KT(2, "kt",
            new String[]{
                    "• 출입구 근처, 구역별로 위치, 엘리베이터 옆"
            }, null),

    Q2_NONE(2, null,
            new String[]{
                    "해당 구장에 대한 정보는 준비 중입니다. 빠른 시일 내에 정확한 정보를 준비해 안내드릴게요!"
            }, null),

    Q3_LG(3, "lg",
            new String[]{
                    "• 1게이트 복도, 중앙복도, 야외 광장에 위치한 쓰레기통\n" +
                            "• 다회용기는 용기회수박스에 따로 넣어야 돼요! 컵이랑 일반 용기는 구분해서 넣어주세요!"
            }, null),

    Q3_KT(3, "kt",
            new String[]{
                    "• 중앙복도에 위치\n" +
                            "• 다회용기는 용기회수박스에 따로 넣어야 돼요! 컵이랑 일반 용기는 구분해서 넣어주세요!"
            }, null),

    Q3_NONE(3, null,
            new String[]{
                    "해당 구장에 대한 정보는 준비 중입니다. 빠른 시일 내에 정확한 정보를 준비해 안내드릴게요!"
            }, null),

    Q4_LG(4, "lg",
            new String[]{
                    "1루 내야와 3루 내야 사이 2층에 위치하고 있어요. 2층은 내야 출입구로 들어서서 한 번 올라가야 해요!"
            }, null),

    Q4_KT(4, "kt",
            new String[]{
                    "1. 위치\n" +
                            "• 수유실은 중앙 빅또리 센터 맞은편에 위치해 있어요!",

                    "2. 동선\n" +
                            "• 입장 후 2층 복도를 통해 중앙 지정석 쪽으로 이동"
            }, null),

    Q4_NONE(4, null,
            new String[]{
                    "해당 구장에 대한 정보는 준비 중입니다. 빠른 시일 내에 정확한 정보를 준비해 안내드릴게요!"
            }, null),

    Q5_LG(5, "lg",
                  new String[]{
        "일반 화장실 위치와 동일해요! (49곳)"
    }, null),

    Q5_KT(5, "kt",
                  new String[]{
        "경기장 매층마다 일반화장실 바로 옆에 위치해 있어요!"
    }, null),

    Q5_NONE(5, null,
                    new String[]{
        "해당 구장에 대한 정보는 준비 중입니다. 빠른 시일 내에 정확한 정보를 준비해 안내드릴게요!"
    }, null),

    Q6_LG(6, "lg",
            new String[]{
                    "2호선 종합운동장역 6번 출구 엘리베이터 > 제1매표소 > 1루 쪽 출구 엘리베이터"
            }, null),

    Q6_KT(6, "kt",
            new String[]{
                    "• 1층 1루 메인 게이트 우측, 3루 메인게이트 좌측, 시즌권 전용게이트 좌측, 위잽전용 스피드게이트 우측\n" +
                            "• 4층 스카이박스 복도"
            }, null),

    Q6_NONE(6, null,
            new String[]{
                    "해당 구장에 대한 정보는 준비 중입니다. 빠른 시일 내에 정확한 정보를 준비해 안내드릴게요!"
            }, null),

    Q7_LG(7, "lg",
            new String[]{
                    "‘홈 > 야구 문화’로 확인하실 수 있어요!"
            }, null),

    Q7_KT(7, "kt",
            new String[]{
                    "‘홈 > 야구 문화’로 확인하실 수 있어요!"
            }, null),

    Q7_NONE(7, null,
            new String[]{
                    "해당 구장에 대한 정보는 준비 중입니다. 빠른 시일 내에 정확한 정보를 준비해 안내드릴게요!"
            }, null)
    ;

    private final int id;
    private final String stadiumName;
    private final String[] answers;
    private final String imgUrl;
}