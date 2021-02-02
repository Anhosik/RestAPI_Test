package kdjsystem.mllink.domain.composit_pk;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserId  implements Serializable {
    @Column(name ="COMPNO")
    Integer compno;
    @Column(name = "USERID" , length = 20)
    private String userId;

    public static  UserId getUserId(Integer compno,String id){
        return UserId.builder().userId(id).compno(compno).build();
    }

    @Builder
    public UserId(Integer compno, String userId) {
        this.compno = compno;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return String.format("%s%s", this.compno, this.userId);
    }
}
