package kdjsystem.mllink.api;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kdjsystem.mllink.dto.wemarket.Makers;
import kdjsystem.mllink.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
@RequestMapping("/api/v1/")
public class UserInf {

    private  final UserMapper userMapper;
    //userinf 저장
    @PostMapping("userinf")
    public kdjsystem.mllink.dto.user.UserInf.Response userinfInsert(@RequestBody @Valid kdjsystem.mllink.dto.user.UserInf.RequestUserInf userinf) {
        int Suss = 0;
        kdjsystem.mllink.dto.user.UserInf.RequestUserInf getuserinf = userMapper.findByidCheck(userinf.getUserid()).orElse(null);

        if(getuserinf!=null){
            return new kdjsystem.mllink.dto.user.UserInf.Response(-1,getuserinf.getUserid() + " 이미 가입되어 있습니다" );
        }else{
            //insert만들기
            Suss = userMapper.setUserInf(userinf.getCompno(),userinf.getUserid(),userinf.getUsernam(),userinf.getUserpwd(),userinf.getEmail(),userinf.getStartuse(),
                    userinf.getEnduse(),userinf.getPricetype(),userinf.getTelno());
            if(Suss!=0){
                return new kdjsystem.mllink.dto.user.UserInf.Response(1,userinf.getUserid()+" 님 기본정보  생성에 성공 하셨습니다." );
            }else{
                return new kdjsystem.mllink.dto.user.UserInf.Response(-1,"알수 없는 에러 입니다." );
            }
        }
    }
    //userinf 수정
    @PutMapping("userinfup")
    public kdjsystem.mllink.dto.user.UserInf.Response userinfUpdate(@RequestBody @Valid kdjsystem.mllink.dto.user.UserInf.RequestUserInf userinf) {
        int Suss = 0;
        kdjsystem.mllink.dto.user.UserInf.RequestUserInf getuserinf = userMapper.findByUserinf(userinf.getCompno(),userinf.getUserid()).orElse(null);

        if(getuserinf!=null){//수정하기
            Suss = userMapper.setUserInfUpdate(userinf.getCompno(),userinf.getUserid(),userinf.getUsernam(),userinf.getUserpwd(),userinf.getEmail());
            if(Suss!=0){
                return new kdjsystem.mllink.dto.user.UserInf.Response(1,userinf.getUserid()+" 님 기본정보  수정에 성공 하셨습니다." );
            }else{
                return new kdjsystem.mllink.dto.user.UserInf.Response(-1,"알수 없는 에러 입니다." );
            }
        }else{
            return new kdjsystem.mllink.dto.user.UserInf.Response(-1,userinf.getUserid() + " 회원정보가 없습니다" );
        }
    }

    //userinf 수정
    @PutMapping("userinfbusup")
    public kdjsystem.mllink.dto.user.UserInf.Response userinfBusUpdate(@RequestBody @Valid kdjsystem.mllink.dto.user.UserInf.RequestUserInf userinf) {
        int Suss = 0;
        kdjsystem.mllink.dto.user.UserInf.RequestUserInf getuserinf = userMapper.findByUserinf(userinf.getCompno(),userinf.getUserid()).orElse(null);

        if(getuserinf!=null){//수정하기
            Suss = userMapper.setUserInfUpdate(userinf.getCompno(),userinf.getUserid(),userinf.getUsernam(),userinf.getUserpwd(),userinf.getEmail());
            if(Suss!=0){
                return new kdjsystem.mllink.dto.user.UserInf.Response(1,getuserinf.getUserid()+" 님 기본정보  수정에 성공 하셨습니다." );
            }else{
                return new kdjsystem.mllink.dto.user.UserInf.Response(-1,"알수 없는 에러 입니다." );
            }
        }else{
            return new kdjsystem.mllink.dto.user.UserInf.Response(-1,userinf.getUserid() + " 회원정보가 없습니다" );
        }
    }

    //사제
    @DeleteMapping("userinfdel")
    public kdjsystem.mllink.dto.user.UserInf.Response userinfDelete(@RequestBody @Valid kdjsystem.mllink.dto.user.UserInf.RequestUserInf userinf) {
        int Suss = 0;
        kdjsystem.mllink.dto.user.UserInf.RequestUserInf getuserinf = userMapper.findByUserinf(userinf.getCompno(),userinf.getUserid()).orElse(null);

        if(getuserinf!=null){//수정하기
            Suss = userMapper.setUserInfDelete(getuserinf.getCompno(),getuserinf.getUserid());
            if(Suss!=0){
                return new kdjsystem.mllink.dto.user.UserInf.Response(1,getuserinf.getUserid()+" 님의 기본정보가 삭제되었습니다." );
            }else{
                return new kdjsystem.mllink.dto.user.UserInf.Response(-1,"알수 없는 에러 입니다." );
            }
        }else{
            return new kdjsystem.mllink.dto.user.UserInf.Response(-1,userinf.getUserid() + " 회원정보가 없습니다" );
        }
    }

    @PostMapping("idcheck")
    public kdjsystem.mllink.dto.user.UserInf.Response idCheck(@RequestBody @Valid kdjsystem.mllink.dto.user.UserInf.RequestUserInf userinf) {

        kdjsystem.mllink.dto.user.UserInf.RequestUserInf Suss = userMapper.findByidCheck(userinf.getUserid()).orElse(null);

        System.out.println(Suss);
        if(Suss == null){//가입가능
            return new kdjsystem.mllink.dto.user.UserInf.Response(1,"회원가입 가능한아이디 입니다." );
        }else{//불가
            return new kdjsystem.mllink.dto.user.UserInf.Response(-1,"중복된 아이디 입니다." );
        }
    }

    //도신 접속시에 저장하기
    @GetMapping("dosincount")
    public void setDosinCount(@RequestParam("compno") String compno,@RequestParam("id") String id,@RequestParam("pw") String pw,@RequestParam("date") String date)
            throws IOException, JsonParseException, JsonMappingException {

        userMapper.setDosinCount(compno,id,pw,date);
    }
}
