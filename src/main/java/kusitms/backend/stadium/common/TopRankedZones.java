package kusitms.backend.stadium.common;

import kusitms.backend.stadium.domain.entity.enums.StadiumStatusType;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class TopRankedZones {

    public static <T extends Enum<T> & StadiumStatusType> List<Map<String, Object>> getTopRankedZones(
            T[] zones, String stadiumName, List<String> clientKeywords) {

        return Arrays.stream(zones)
                .map(zone -> {
                    if (KeywordManager.hasForbiddenKeywords(zone.getForbiddenKeywords(), clientKeywords)) {
                        return null;
                    }

                    int page1Count = KeywordManager.getMatchingKeywordCount(zone.getPage1Keywords(), clientKeywords);
                    int page2Count = KeywordManager.getMatchingKeywordCount(zone.getPage2Keywords(), clientKeywords);
                    int page3Count = KeywordManager.getMatchingKeywordCount(zone.getPage3Keywords(), clientKeywords);

                    // 총 겹치는 개수 계산
                    int totalMatchCount = page1Count + page2Count + page3Count;

                    Map<String, Object> result = new HashMap<>();
                    result.put("stadium", stadiumName);
                    result.put("zone", zone.getZone());
                    result.put("explanations", zone.getExplanations());
                    result.put("tip", zone.getTip());
                    result.put("references", zone.getReferences());
                    result.put("totalMatchCount", totalMatchCount);
                    result.put("page1Count", page1Count);
                    result.put("page2Count", page2Count);
                    result.put("page3Count", page3Count);
                    return result;
                })
                .filter(Objects::nonNull)
                .filter(result -> (int) result.get("totalMatchCount") > 0)
                .sorted((a, b) -> {
                    int totalCompare = Integer.compare((int) b.get("totalMatchCount"), (int) a.get("totalMatchCount"));
                    if (totalCompare == 0) {
                        int page2Compare = Integer.compare((int) b.get("page2Count"), (int) a.get("page2Count"));
                        if (page2Compare == 0) {
                            int page3Compare = Integer.compare((int) b.get("page3Count"), (int) a.get("page3Count"));
                            if (page3Compare == 0) {
                                return Integer.compare((int) b.get("page1Count"), (int) a.get("page1Count"));
                            }
                            return page3Compare;
                        }
                        return page2Compare;
                    }
                    return totalCompare;
                })
                .limit(3)
                .map(result -> {
                    log.info("zone: {}, totalMatchCount: {}, page1Count: {}, page2Count: {}, page3Count: {}", result.get("zone"), result.get("totalMatchCount"), result.get("page1Count"), result.get("page2Count"), result.get("page3Count"));
                    result.remove("totalMatchCount");
                    result.remove("page1Count");
                    result.remove("page2Count");
                    result.remove("page3Count");
                    return result;
                })
                .toList();
    }
}