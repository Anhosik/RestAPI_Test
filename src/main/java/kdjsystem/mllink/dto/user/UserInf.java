package kdjsystem.mllink.dto.user;

import lombok.*;

@Data
@AllArgsConstructor
public class UserInf {

    // 21.1.19(화) 13:19 문재옥
    // 다인슈 요청으로 로그인 API 리턴값에 유저이름, 회사명, 연락처 추가
    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class ResponseUseInf {
       private int  compno;
       private String compnm;
       private String userid;
       private  String usernam;
       private  String userpwd;
       private  String email;
       private  String progcd;
       private  String useyn;
       private  String ltype;
       private  String startuse;
       private  String enduse;
       private String telno;
       private  String pricetype;
       private  String brandcd;
       private Integer smsbalance;
       private String custno;
    }


    @Getter
    @AllArgsConstructor
    @Builder
    public static class RequestUpdate {
        private int id;
        private String name;
        private int age;
    }

    @Getter
    @Setter
    public static class RequestLogin {
        private Integer compno;
        private String  userid;
        private String  password;
    }

    // 21.1.26(화), 16:59 문재옥 추가
    // 홈페이지에서 서비스(FFM/SEL) 유형 변경 요청
    @Getter
    @Setter
    public static class RequestLtype {
        private Integer compno;
        private String Userid;
        private String ltype;
    }

    // 21.1.1.19(화), 13:19 문재옥 수정
    // 다인슈 요청으로 로그인 API 리턴값에 유저이름(usernam), 회사명(compnm), 연락처(telno) 추가
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseLogin {
        private Integer resultCode;
        private String  resultText;
        private Integer compno;
        private String compnm;
        private String  userid;
        private String usernam;
        private String  token;
        private String  email;
        private String  ssn;
        private  String startuse;
        private  String enduse;
        private String telno;
        private String pricetype;
        private Integer smsbalance;
        private String ltype;
        private String custno;

        @Builder
        public ResponseLogin(UserInf.ResponseUseInf userInf, String token, Integer resultCode, String resultText ) {
            this.resultCode = resultCode;
            this.resultText = resultText;
            this.compno = userInf.getCompno();
            this.compnm = userInf.getCompnm();
            this.userid = userInf.getUserid();
            this.usernam = userInf.getUsernam();
            this.token = token;
            this.email = userInf.getEmail();
            this.startuse = userInf.getStartuse();
            this.enduse = userInf.getEnduse();
            this.telno = userInf.getTelno();
            this.pricetype = userInf.getPricetype();
            this.smsbalance = userInf.getSmsbalance();
            this.ltype = userInf.getLtype();
            this.custno = userInf.getCustno();
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseCompno {
        private Integer resultCode;
        private String  resultText;
        private Integer compno;

        @Builder
        public ResponseCompno(int compno, Integer resultCode, String resultText ) {
            this.resultCode = resultCode;
            this.resultText = resultText;
            this.compno = compno;
        }
    }

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
    public static class RequestCreate {
        private Integer compno;
        private String  userid;
        private String  username;
        private String  password;
        private String  email;
        private String  ssn;
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    public static class RequestUserInf {
        private Integer compno;
        private String userid;
        private String usernam;
        private String userpwd;
        private String email;
        private String startuse;
        private String enduse;
        private String pricetype;
        private String telno;

        public RequestUserInf(Integer compno, String userid, String usernam, String userpwd, String email, String startuse, String enduse, String pricetype, String telno) {
            this.compno = compno;
            this.userid = userid;
            this.usernam = usernam;
            this.userpwd = userpwd;
            this.email = email;
            this.startuse = startuse;
            this.enduse = enduse;
            this.pricetype = pricetype;
            this.telno = telno;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response {

        private int    returnCode;
        private String returnMessage;
    }
}
