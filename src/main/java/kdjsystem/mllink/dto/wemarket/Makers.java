package kdjsystem.mllink.dto.wemarket;

import lombok.*;

import java.util.List;

@Data
public class Makers {
    private String resultCode;
    private List<ResultMakerData> data;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ResultMakerData {
        private int makerNo;
        private String makerName;
        private String makerNameEnglish;

    }
}
