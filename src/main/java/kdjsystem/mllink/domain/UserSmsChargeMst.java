package kdjsystem.mllink.domain;

import kdjsystem.mllink.domain.composit_pk.SMSCharageDtl_ID;
import kdjsystem.mllink.domain.composit_pk.UserId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_smschargemst")
public class UserSmsChargeMst {

    @EmbeddedId
    private UserId id;
    @Column(name = "smsaliase")
    private String smsaliase;
    @Column(name = "smsno")
    private String smsno;
    @Column(name = "smschgamt")
    private Integer smschgamt;
    @Column(name = "smsuseamt")
    private Integer smsuseamt;
    @Column(name = "smsbalance")
    private Integer smsbalance;
    @Column(name = "contprice")
    private Integer contprice;
    @Column(name = "serialno")
    private Integer serialno;

    @Column(name = "smsprice")
    private Integer smsprice;
    @Column(name = "lmsprice")
    private Integer lmsprice;

}
