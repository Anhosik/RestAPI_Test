package kdjsystem.mllink.api;

import kdjsystem.mllink.config.security.JwtTokenProvider;
import kdjsystem.mllink.domain.Companyinfo;
import kdjsystem.mllink.domain.composit_pk.UserId;
import kdjsystem.mllink.domain.enumtype.UserRole;
import kdjsystem.mllink.dto.sms.SmsInf;
import kdjsystem.mllink.dto.user.UserInf;
import kdjsystem.mllink.exception.PasswordWrongException;
import kdjsystem.mllink.exception.UserNotFoundException;
import kdjsystem.mllink.mapper.UserMapper;
import kdjsystem.mllink.service.company.CompanyService;
import kdjsystem.mllink.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
@RequestMapping("/api/v1/")
public class MemberApiController {
    private final UserService userService;
    private  final CompanyService companyService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    private  final UserMapper userMapper;

    // 회원가입
    @PostMapping(value = "signup")
    public UserInf.Response signup(@RequestBody @Valid UserInf.RequestCreate userReuest) {
        // 사용자의 아이디 체크. 이미 존재하는 경우 예외를 발생시키고, 없을 경우 비밀번호를 암호화한다.

        if (!userService.findByUserId(userReuest.getCompno(), userReuest.getUserid()).isPresent()) {
                      kdjsystem.mllink.domain.UserInf newUser =  kdjsystem.mllink.domain.UserInf.builder()
                      .id(userReuest.getUserid())
                      .compno(userReuest.getCompno())
                      .passWord(passwordEncoder.encode(userReuest.getPassword()))
                      .progcd(UserRole.USER)
                      .email(userReuest.getEmail())
                      .ssn(userReuest.getSsn() )
                      .build();

            Companyinfo findCompanyinfo =  companyService.findById(newUser.getId().getCompno())
                                            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회사입니다. "));

            newUser.setCompanyinfo(findCompanyinfo);    // 사용자 회사 정보를 셋팅한다.
            userService.signUp(newUser);

            kdjsystem.mllink.domain.UserInf findMember =      userService.findByUserId(userReuest.getCompno(), userReuest.getUserid())
                                            .orElseThrow(() -> new IllegalArgumentException("알수 없는 에러 입니다."));

            return  new UserInf.Response(1,findMember.getUsername() + " 님 회원가입에 성공 하셨습니다." );

        } else{
            new UserInf.Response(1,userReuest.getUsername() + " 이미 가입되어 있습니다" );
        }

        return new UserInf.Response(-1, HttpStatus.BAD_REQUEST.getReasonPhrase());
    }


    private  boolean isPasswordCheck(String param_password, String  password ){
//        if (!passwordEncoder.matches( param_password , password))
//            return false;

        if(!param_password.equals(password))
            return false;

        return true;
    }


    // test
    // 로그인
    @PostMapping("login")
    public UserInf.ResponseLogin login(@RequestBody  @Valid UserInf.RequestLogin user) {


        UserInf.ResponseUseInf member = userMapper.findByUserId (user.getUserid())
               .orElseThrow(() -> new UserNotFoundException("가입되지 않은 사용자 입니다."));


        if (!isPasswordCheck( user.getPassword() , member.getUserpwd())) {
            throw  new PasswordWrongException("잘못된 비밀 번호 입니다..");
        }

        UserRole role = UserRole.ADMIN;
        String token;
        UserId userId =  UserId.builder().userId(member.getUserid()).compno(member.getCompno()).build();
        token = jwtTokenProvider.createToken(userId, role);

        if(member.getCustno()==null){
            member.setCustno("N");
        }else{
            member.setCustno("Y"); 
        }

        UserInf.ResponseLogin loginUser    = new UserInf.ResponseLogin(member, token, 0, "SUCESS");
        log.debug(loginUser.toString());
        return loginUser;
    }

    // 로그인
    @PostMapping("login2")
    public UserInf.ResponseLogin login2(@RequestBody  @Valid UserInf.RequestLogin user) {


        UserInf.ResponseUseInf member = userMapper.findByUserId2(user.getCompno(), user.getUserid())
                .orElseThrow(() -> new UserNotFoundException("가입되지 않은 사용자 입니다."));


        if (!isPasswordCheck( user.getPassword() , member.getUserpwd())) {
            throw  new PasswordWrongException("잘못된 비밀 번호 입니다..");
        }

        UserRole role = UserRole.ADMIN;
        String token;
        UserId userId =  UserId.builder().userId(member.getUserid()).compno(member.getCompno()).build();
        token = jwtTokenProvider.createToken(userId, role);


        UserInf.ResponseLogin loginUser    =new UserInf.ResponseLogin(member, token, 1, "SUCESS");
        log.debug(loginUser.toString());
        return loginUser;
    }

    //compno MAX구하기
    @GetMapping("maxcompnochk")
    public UserInf.ResponseCompno compnoMaxCount() {

        int Maxcount = userMapper.findByCompno ();

        UserInf.ResponseCompno loginUser = new UserInf.ResponseCompno(Maxcount+1, 0, "SUCESS");
        log.debug(loginUser.toString());
        return loginUser;
    }

    // 홈페이지(나의정보)에서 서비스신청(몰링크FFM/몰링크SEL) 시
    // USERINF의 LTYPE 값(0:몰링크FFM, 2:몰링크SEL) 변경
    @PostMapping("userltypeup")
    public UserInf.Response userltypeup(@RequestBody @Valid UserInf.RequestLtype user) {
        int Suss = 0;

        Suss = userMapper.setUserLtypeUpdate(user.getCompno(), user.getUserid(), user.getLtype());

        if (Suss == 0) {
            return new UserInf.Response(-1,"회원정보와 일치하는 자료가 없습니다." );
        } else if (Suss == 1) {
            return new UserInf.Response(1,"정상처리" );
        }else {
            return new UserInf.Response(-1,"알수 없는 에러 입니다." );
        }
    }
}
