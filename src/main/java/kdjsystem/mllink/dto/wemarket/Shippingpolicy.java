package kdjsystem.mllink.dto.wemarket;

import lombok.*;

import java.util.List;

@Data
public class Shippingpolicy {
    private String resultCode;
    private List<ResultShipData> data;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ResultShipData {
        private String partnerGroupId;
        private int shipPolicyNo;
        private String shipPolicyName;
        private String shipMng;
        private String shipMethod;
        private String parcelCompanyCode;
        private String bundleKind;
        private String shipType;
        private String shipFee;
        private String shipFeeDisplayYn;
        private String freeCondition;
        private String differenceYn;
        private String differenceCount;
        private String prepaymentYn;
        private String claimShipFee;
        private String shipArea;
        private String jejuShipFee;
        private String islandMountainShipFee;
        private String releaseDay;
        private String releaseTime;
        private String holidayExceptYn;
        private String releaseZipCode;
        private String releaseRoadAddress1;
        private String releaseRoadAddress2;
        private String releaseAddress1;
        private String releaseAddress2;
        private String returnZipCode;
        private String returnRoadAddress1;
        private String returnRoadAddress2;
        private String returnAddress1;
        private String returnAddress2;
        private String safetyNoDisplayYn;
    }
}