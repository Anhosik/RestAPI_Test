package kdjsystem.mllink.dto.wemarket;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class ProductData {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class WeMarketProductReg {
        private String productNo;
        private Basic basic;
        private Sale sale;
        private Detail detail;
        private Option option;
        private List<NoticeListMain> noticeList = new ArrayList<>();
        private Etc etc;
        private BranchList branchList;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class Basic {
        private String productName;
        private String productType;
        private String dcateCode;
        private String shipPolicyNo;
        private ShipInfo shipInfo;
        private String adultLimitYn;
        private String displayYn;
        private String bizYn;
        private String styleYn;
        private String brandNo;
        private String makerNo;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class ShipInfo {
        private String claimShipFee;
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
        private String releaseDay;
        private String releaseTime;
        private String holidayExceptYn;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class Sale {
        private String salePeriod;
        private String saleStartDate;
        private String saleEndDate;
        private String originPrice;
        private String salePrice;
        private String stockCount;
        private String taxYn;
        private String purchaseMinCount;
        private String purchaseLimitYn;
        private String purchaseLimitDuration;
        private String purchaseLimitDay;
        private String purchaseLimitCount;
        private String basketLimitYn;
        private String referencePriceType;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class Detail {
        private String basicImgUrl;
        private List<String> addImgUrlList;
        private String listImgUrl;
        private String descType;
        private List<String> descImgUrlList;
        private String descHtml;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class Option {
        private String selectOptionUseYn;
        private String selectOptionDepth;
        private String selectOptionTitle1;
        private String selectOptionTitle2;
        private String selectOptionTitle3;
        private String selectOptionTitle4;
        private String selectOptionTitle5;
        private List<SelectOptionValueList> selectOptionValueList;
        private String textOptionUseYn;
        private String textOptionDepth;
        private String textOptionTitle1;
        private String textOptionTitle2;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class SelectOptionValueList {
        private String optionValue1;
        private String optionValue2;
        private String optionValue3;
        private String optionValue4;
        private String optionValue5;
        private String optAddPrice;
        private String stockCount;
        private String displayYn;
        private String sellerOptionCode;



    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class NoticeListMain {
        private String groupNoticeNo;
        private List<NoticeListValue> noticeList = new ArrayList<>();



    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class NoticeListValue {
        private String noticeNo;
        private String description;



    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class Etc {
        private String parallelImportYn;
        private String parallelImportUrl;
        private String kcKidIsCertification;
        private List<KcKidCertificationList> kcKidCertificationList;
        private String kcLifeIsCertification;
        private List<KcLifeCertificationList> kcLifeCertificationList;
        private String kcElectricIsCertification;
        private List<KcElectricCertificationList> kcElectricCertificationList;
        private String kcReportIsCertification;
        private List<KcReportCertificationList> kcReportCertificationList;
        private String kcLifeChemistryIsCertification;
        private List<KcLifeChemistryCertificationList> kcLifeChemistryCertificationList;
        private String sellerProdCode;
        private String priceComparisonSiteYn;
        private String keywordPriceComparisonSite;
        private String keywordWemakeprice;
        private String isbn13;
        private String isbn10;
        private String displayOnlyDealYn;
        private String reviewDisp;
        private List<String> labelNoList;

    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class KcKidCertificationList {
        private String certificationType;
        private String certificationNo;


    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class KcLifeCertificationList {
        private String certificationType;
        private String certificationNo;


    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class KcElectricCertificationList {
        private String certificationType;
        private String certificationNo;


    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class KcReportCertificationList {
        private String certificationType;
        private String certificationNo;


    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class KcLifeChemistryCertificationList {
        private String certificationType;
        private String certificationNo;


    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class BranchList {
        private String branchId;
        private String originPrice;
        private String salePrice;
        private String useYn;



    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class MakerSearch {
        private String chgDt;
        private String chgNm;
        private String makerNm;
        private String makerNmEng;
        private String makerNo;
        private String regDt;
        private String regNm;
        private String siteUrl;
        private String useYn;



    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class BrandSearch {
        private String brandDesc;
        private String brandNm;
        private String brandNmEng;
        private String brandNo;
        private String chgDt;
        private String chgNm;
        private String imgUrl;
        private String makerNm;
        private String makerNo;
        private String regDt;
        private String regNm;
        private String useYn;



    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class NoticeType {
        private int gnoticeNo;
        private int noticeNo;
        private String noticeNm;
        private int priority;
        private String commentType;
        private String commentTypeName;
        private String placeholder;
        private String useYn;
        private String prodDesc;



    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class ShipPolicy {
        private int shipPolicyNo;
        private String shipPolicyNm;
        private String defaultYn;
        private String shipMng;
        private String shipMngNm;
        private String warehouseInside;
        private String warehouseOutside;
        private String shipMethod;
        private String shipMethodNm;
        private String releaseDay;
        private String holidayExceptYn;
        private String holidayExceptYnNm;
        private String bundleKind;
        private String bundleKindNm;
        private String shipType;
        private String shipTypeNm;
        private String shipFee;
        private String shipFeeDispYn;
        private String shipFeeDispYnNm;
        private String freeCondition;
        private String diffYn;
        private String prepaymentYn;
        private String claimShipFee;
        private String shipArea;
        private String shipAreaNm;
        private String releaseZipcode;
        private String releaseAddr1;
        private String releaseAddr2;
        private String releaseRoadAddr1;
        private String releaseRoadAddr2;
        private String returnZipcode;
        private String returnAddr1;
        private String returnAddr2;
        private String returnRoadAddr1;
        private String returnRoadAddr2;
        private String useYn;
        private String safetyNoDispYn;
        private String safetyNoDispYnNm;



    }
}
