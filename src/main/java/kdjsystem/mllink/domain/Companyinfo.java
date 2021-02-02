package kdjsystem.mllink.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Companyinfo")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Companyinfo {
    @Id
    @Column(name = "COMPNO" )
    private Integer compno;

    @Column(name = "COMPNM")
    private String compnm;
    @Column(name = "SB_CMP_ID")
    private String sb_cmp_id;
    @Column(name = "SB_AUTH_KEY")
    private String sb_auth_key;
    @Column(name = "SB_PROD_FILE")
    private String sb_prod_file;
    @Column(name = "SB_ORD_FILE")
    private String sb_ord_file;
    @Column(name = "SB_CLAIM_FILE")
    private String sb_claim_file;
    @Column(name = "EC_COM_CD")
    private String ec_com_cd;
    @Column(name = "EC_USR_ID")
    private String ec_usr_id;
    @Column(name = "EC_API_KEY")
    private String ec_api_key;
    @Column(name = "IMGFOLDER")
    private String imgfolder;
    @Column(name = "CUSTNO")
    private String custno;
    @Column(name = "CEONM")
    private String ceonm;
    @Column(name = "ZIPCODE")
    private String zipcode;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "BUSINESS")
    private String business;
    @Column(name = "EVENT")
    private String event;
    @Column(name = "TELNO")
    private String telno;
    @Column(name = "CPHON")
    private String cphon;
    @Column(name = "FAXNO")
    private String faxno;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "KAKAO_KEY")
    private String kakao_key;
    @Column(name = "SABANGID")
    private String sabangid;
    @Column(name = "SABANGPW")
    private String sabangpw;
    @Column(name = "COMPALS")
    private String compals;

    @JsonIgnore
    @OneToMany(mappedBy = "companyinfo", fetch = FetchType.LAZY)
    private List<UserInf> userInf = new ArrayList<>();


    @Builder
    public Companyinfo(Integer compno, String compnm, String sb_cmp_id, String sb_auth_key, String sb_prod_file, String sb_ord_file, String sb_claim_file, String ec_com_cd, String ec_usr_id, String ec_api_key, String imgfolder, String custno, String ceonm, String zipcode, String address, String business, String event, String telno, String cphon, String faxno, String email, String kakao_key, String sabangid, String sabangpw, String compals) {
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
    }
}
