package kdjsystem.mllink.domain;

import kdjsystem.mllink.domain.composit_pk.UserId;
import kdjsystem.mllink.domain.enumtype.UserRole;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.servlet.http.PushBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "USERINF")
public class UserInf implements UserDetails {
    @EmbeddedId
    private UserId id;
    @Column(name="USERNAM", length = 20)
    private String userName;
    @Column(name="USERPWD" , length = 20)
    private String passWord;
    @Column(name="EMAIL" , length = 30)
    private String email;

    @Column(nullable = false,name="PROGCD" , length = 100)
    @Enumerated(EnumType.STRING)
    private UserRole role;


    @Column(name="USEYN" , length = 1)
    private String useyn;
    @Column(name="LTYPE" , length = 1)
    private String ltype;

    @Column(name="STARTUSE" , length = 50)
    private String startuse;

    @Column(name="ENDUSE" , length = 50)
    private String enduse;


    @Builder
    public UserInf(Integer compno, String id, String userName, String passWord, String email, UserRole progcd, String useyn, String ltype, String ssn) {
        this.id = UserId.builder().userId(id).compno(compno).build();
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.role = progcd;
        this.useyn = useyn;
        this.ltype = ltype;

        if(ssn !=null && !ssn.isEmpty()){  // ssn 이 있을 경우 에는
            createCompInf(ssn);
        }
    }

    @ManyToOne
    @MapsId("compno")
    @JoinColumns({
            @JoinColumn(name = "compno", referencedColumnName = "compno"),
    })
    private Companyinfo companyinfo;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(this.role.getValue())
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @OneToOne( fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name="compno"),
            @JoinColumn(name="userid")
    })
    private UserCompInf userCompInf;


    public void setCompanyinfo(Companyinfo companyinfo){
         this.companyinfo = companyinfo;
         this.companyinfo.getUserInf().add(this);
    }



    // ---  컴퍼니 저장.
    public  void createCompInf(String ssn){
        userCompInf =  UserCompInf.createUserCompInf(id, ssn);
    }




    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
