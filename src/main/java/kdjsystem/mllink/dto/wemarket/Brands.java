package kdjsystem.mllink.dto.wemarket;

import lombok.*;

import java.util.List;

@Data
public class Brands {
    private String resultCode;
    private List<ResultBrandData> data;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ResultBrandData {
        private int brandNo;
        private String brandName;
        private String brandNameEnglish;

    }
}