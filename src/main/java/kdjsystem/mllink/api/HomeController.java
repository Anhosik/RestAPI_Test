package kdjsystem.mllink.api;

import kdjsystem.mllink.config.security.JwtTokenProvider;
import kdjsystem.mllink.dto.user.UserInf;
import kdjsystem.mllink.mapper.UserMapper;
import kdjsystem.mllink.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@Slf4j
@Validated
public class HomeController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;


    private final   UserMapper userMapper;



    // 회원가입
    ///@PostMapping(value = "join")
//    public ResponseEntity signUp(@RequestBody @Valid UserParam userVO) {
//        // 사용자의 이메일이 이미 존재하는 경우 예외를 발생시키고, 없을 경우 비밀번호를 암호화한다.
//        if (!userService.findByEmail(userVO.getEmail()).isPresent()) {
//
//           UserInf newUser =  UserInf.builder()
//                    .id(userVO.getUserid())
//                    .compno(userVO.getCompno())
//                    .passWord(passwordEncoder.encode(userVO.getPassword()))
//                    .progcd(UserRole.USER)
//                    .email(userVO.getEmail())
//                    .ssn(userVO.getSsn() )
//                    .build();
//
//
//            userService.signUp(newUser);
//            log.debug("Sign Up Complete");
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//
//    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {

//        UserInf member = userService.findByUserId (user, user.get("id"))
//                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
//
//        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
//            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
//        }
//        return jwtTokenProvider.createToken(member.getId(), member.getRole());
        return "";
    }

    @GetMapping("/test")
    public  String test(){
        return "ahnhosick_test";
    }

    @GetMapping("/test1")

    public UserInf.RequestLogin test1(@RequestParam Integer compno, @RequestParam String userid){

        return userMapper.getUserProfile(compno,userid);
    }

}
