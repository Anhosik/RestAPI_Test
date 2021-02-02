package kdjsystem.mllink.domain;

import kdjsystem.mllink.domain.composit_pk.SMSCharageDtl_ID;
import kdjsystem.mllink.domain.composit_pk.UserId;
import kdjsystem.mllink.domain.enumtype.SMSTYPE;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_smschargedtl")
public class UserSmsChargeDtl {

    @EmbeddedId
    private SMSCharageDtl_ID id;

    @Column(name="tocontact")
    private  String tocontact;

    @Column(name="contents")
    private  String contents;

    @Column(name="senddate")
    private LocalDateTime senddate;

    @Enumerated(EnumType.STRING)
    private SMSTYPE smstype;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="compno", referencedColumnName="compno", insertable=false, updatable=false),
            @JoinColumn(name="userid", referencedColumnName="USERID",insertable=false, updatable=false)
    })
    private  UserSmsChargeMst userSmsChargeMst;


}
