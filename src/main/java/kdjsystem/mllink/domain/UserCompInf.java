package kdjsystem.mllink.domain;

import kdjsystem.mllink.domain.composit_pk.UserId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "usercompinf")
public class UserCompInf {
    @EmbeddedId
    private UserId id;

    @Column(name="ssn", length = 20)
    private String ssn;

    @OneToOne(mappedBy = "userCompInf")
    private UserInf userInf;


    //  사용자 컴프 등록..
    public static UserCompInf  createUserCompInf(UserId id, String ssn){
        UserCompInf userCompInf = new UserCompInf();
        userCompInf.id = id;
        userCompInf.ssn = ssn;
        return userCompInf;
    }
}
