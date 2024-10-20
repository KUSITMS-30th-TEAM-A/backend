package kusitms.backend.stadium.dto.response;


import kusitms.backend.result.common.ReferencesGroup;
import kusitms.backend.result.domain.enums.StadiumStatusType;

import java.util.List;

public record GetZoneGuideResponseDto(
        String zoneName,
        String explanation,
        String entrance,
        String stepSpacing,
        String seatSpacing,
        String usageInformation,
        String tip,
        List<ReferencesGroup> referencesGroup
) {
    public static GetZoneGuideResponseDto from(StadiumStatusType zone) {
        return new GetZoneGuideResponseDto(
                zone.getZoneName(),
                zone.getOneLineDescription(),
                zone.getEntrance(),
                zone.getStepSpacing(),
                zone.getSeatSpacing(),
                zone.getUsageInformation(),
                zone.getTip(),
                zone.getReferencesGroup()
        );
    }
}
