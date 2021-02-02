package kdjsystem.mllink.dto.company;

import kdjsystem.mllink.dto.user.UserInf;
import lombok.*;

public class CompanyInf {

    @Getter
    @AllArgsConstructor
    @Builder
    public static class ResponseSelect {
        private int compno;
        private String compnm;
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
    @NoArgsConstructor
    @Builder
    public static class Company {
        private Integer compno;
        private String compnm;
        private String sb_cmp_id;
        private String sb_auth_key;
        private String sb_prod_file;
        private String sb_ord_file;
        private String sb_claim_file;
        private String ec_com_cd;
        private String ec_usr_id;
        private String ec_api_key;
        private String imgfolder;
        private String custno;
        private String ceonm;
        private String zipcode;
        private String address;
        private String business;
        private String event;
        private String telno;
        private String cphon;
        private String faxno;
        private String email;
        private String kakao_key;
        private String sabangid;
        private String sabangpw;
        private String compals;
        private String userid;
        private String startuse;
        private String enduse;

        public Company(Integer compno, String compnm, String sb_cmp_id, String sb_auth_key, String sb_prod_file, String sb_ord_file, String sb_claim_file, String ec_com_cd, String ec_usr_id, String ec_api_key, String imgfolder, String custno, String ceonm, String zipcode, String address, String business, String event, String telno, String cphon, String faxno, String email, String kakao_key, String sabangid, String sabangpw, String compals, String userid, String startuse, String enduse) {
            this.compno = compno;
            this.compnm = compnm;
            this.sb_cmp_id = sb_cmp_id;
            this.sb_auth_key = sb_auth_key;
            this.sb_prod_file = sb_prod_file;
            this.sb_ord_file = sb_ord_file;
            this.sb_claim_file = sb_claim_file;
            this.ec_com_cd = ec_com_cd;
            this.ec_usr_id = ec_usr_id;
            this.ec_api_key = ec_api_key;
            this.imgfolder = imgfolder;
            this.custno = custno;
            this.ceonm = ceonm;
            this.zipcode = zipcode;
            this.address = address;
            this.business = business;
            this.event = event;
            this.telno = telno;
            this.cphon = cphon;
            this.faxno = faxno;
            this.email = email;
            this.kakao_key = kakao_key;
            this.sabangid = sabangid;
            this.sabangpw = sabangpw;
            this.compals = compals;
            this.userid = userid;
            this.startuse = startuse;
            this.enduse = enduse;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    public static class RequestCompanyCreate {
        private Integer compno;
        private String startuse;
        private String enduse;
        private String compnm;
        private String custno;
        private String ceonm;
        private String  email;
        private String cphon;
        private String userid;

        public RequestCompanyCreate(Integer compno, String startuse, String enduse, String compnm, String custno, String ceonm, String email,String cphon,String userid) {
            this.compno = compno;
            this.startuse = startuse;
            this.enduse = enduse;
            this.compnm = compnm;
            this.custno = custno;
            this.ceonm = ceonm;
            this.email = email;
            this.cphon = cphon;
            this.userid = userid;
        }
    }


}
