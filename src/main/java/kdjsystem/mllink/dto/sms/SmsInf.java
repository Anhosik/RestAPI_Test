package kdjsystem.mllink.dto.sms;

import lombok.*;

@Data
@AllArgsConstructor
public class SmsInf {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class ResponseLoginFailException extends  IllegalArgumentException {
        private Integer resultCode;
        private String  resultText;

        @Builder
        public ResponseLoginFailException(Integer resultCode, String resultText) {
            this.resultCode = resultCode;
            this.resultText = resultText;

        }
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    public static class RequestSmsCharge {
        private Integer compno;
        private String userid;
        private Integer serialno;
        private Integer smsprice;
        private Integer lmsprice;
        private String smsaliase;

        public RequestSmsCharge(Integer compno, String userid, Integer serialno, Integer smsprice, Integer lmsprice, String smsaliase) {
            this.compno = compno;
            this.userid = userid;
            this.serialno = serialno;
            this.smsprice = smsprice;
            this.lmsprice = lmsprice;
            this.smsaliase = smsaliase;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    public static class RequestSmsChargeMst {
        private Integer compno;
        private String userid;
        private String smsaliase;
        private String smsno;
        private Integer smschgamt;
        private Integer smsuseamt;
        private Integer smsbalance;
        private Integer contprice;
        private Integer serialno;
        private Integer smsprice;
        private Integer lmsprice;

        public RequestSmsChargeMst(Integer compno, String userid, String smsaliase, String smsno, Integer smschgamt, Integer smsuseamt, Integer smsbalance, Integer contprice, Integer serialno, Integer smsprice, Integer lmsprice) {
            this.compno = compno;
            this.userid = userid;
            this.smsaliase = smsaliase;
            this.smsno = smsno;
            this.smschgamt = smschgamt;
            this.smsuseamt = smsuseamt;
            this.smsbalance = smsbalance;
            this.contprice = contprice;
            this.serialno = serialno;
            this.smsprice = smsprice;
            this.lmsprice = lmsprice;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    public static class RequestSmsChargeDtl {
        private Integer compno;
        private Integer aliaseseq;
        private String tocontact;
        private String contents;
        private String sentdate;
        private String timespent;
        private String smstype;
        private String userid;

        public RequestSmsChargeDtl(Integer compno, Integer aliaseseq, String tocontact, String contents, String sentdate, String timespent, String smstype,String userid) {
            this.compno = compno;
            this.aliaseseq = aliaseseq;
            this.tocontact = tocontact;
            this.contents = contents;
            this.sentdate = sentdate;
            this.timespent = timespent;
            this.smstype = smstype;
            this.userid = userid;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    public static class RequestChargeDtl {
        private Integer compno;
        private Integer select;
        private String orddtFrom;
        private String orddtTo;
        private String content;
        private String userid;

        public RequestChargeDtl(Integer compno, Integer select, String orddtFrom, String orddtTo, String content, String userid) {
            this.compno = compno;
            this.select = select;
            this.orddtFrom = orddtFrom;
            this.orddtTo = orddtTo;
            this.content = content;
            this.userid = userid;
        }
    }

}
