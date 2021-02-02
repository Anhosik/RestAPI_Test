package kdjsystem.mllink.domain.composit_pk;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SMSCharageDtl_ID implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name ="COMPNO")
    Integer compno;
    @Column(name = "USERID" , length = 20)
    private String userId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq",  nullable = false)
    private Long seq;




}
