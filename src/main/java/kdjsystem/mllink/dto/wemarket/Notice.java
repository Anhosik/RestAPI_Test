package kdjsystem.mllink.dto.wemarket;

import lombok.*;

import java.util.List;

@Data
public class Notice {
    private String resultCode;
    private List<ResultNoticeData> data;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ResultNoticeData {
        private String groupNoticeNo;
        private String groupNoticeNoName;
        private List<NoticeData> noticeList;

        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder
        public static class NoticeData {
            private String noticeNo;
            private String noticeName;
            private String defaltValue;
        }

    }

}
