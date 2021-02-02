package kdjsystem.mllink.api;

import kdjsystem.mllink.dto.company.CompanyInf;
import kdjsystem.mllink.dto.user.UserInf;
import kdjsystem.mllink.mapper.CompaynyMapper;
import kdjsystem.mllink.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
@RequestMapping("/api/v1/")
public class CompanyInfoAPI {

    private  final UserMapper userMapper;
    private final CompaynyMapper compaynyMapper;
    //companyinfo 저장
    @PostMapping("companyinfo")
    public UserInf.Response companyinfoInsert(@RequestBody @Valid CompanyInf.RequestCompanyCreate company) {
        int Suss = 0;
        CompanyInf.Company companymember = compaynyMapper.findByCustNoSearch(company.getCustno(),company.getUserid()).orElse(null);

        if(companymember!=null){
            return new UserInf.Response(-1,"이미 등록된 사업자 번호입니다." );
        }else{
            //insert만들기
            Suss = compaynyMapper.setCompanyInfo(company.getStartuse(),company.getEnduse(),company.getCompnm(),company.getCustno(),company.getCeonm(),company.getEmail(),company.getUserid());
            if(Suss!=0){
                return new UserInf.Response(1,company.getCompnm()+" 님 회원가입에 성공 하셨습니다." );
            }else{
                return new UserInf.Response(-1,"알수 없는 에러 입니다." );
            }
        }
    }
    @PutMapping("companyinfoup")
    public UserInf.Response companyinfoUpdate(@RequestBody @Valid CompanyInf.RequestCompanyCreate company) {
        int Suss = 0;
        CompanyInf.Company companymember = compaynyMapper.findByCompno(company.getCompno()).orElse(null);

        if(companymember!=null){
            //insert만들기
            Suss = compaynyMapper.setCompanyInfoUpdate(company.getCompno(),company.getCompnm(),company.getCphon(),company.getEmail());
            if(Suss!=0){
                return new UserInf.Response(1,company.getCompnm()+" 님 회원 수정에 성공 하셨습니다." );
            }else{
                return new UserInf.Response(-1,"알수 없는 에러 입니다." );
            }

        }else{//회사코드가 없는겅우
            return new UserInf.Response(-1,company.getCompnm() + " 님의 정보가 없습니다." );
        }
    }
    //사업자수정
    @PutMapping("companyinfobusup")
    public UserInf.Response companyinfoBusUpdate(@RequestBody @Valid CompanyInf.RequestCompanyCreate company) {
        int Suss = 0;
        CompanyInf.Company companymember = compaynyMapper.findByCompno(company.getCompno()).orElse(null);

        if(companymember!=null){

            Suss = compaynyMapper.setCompanyInfoBusUpdate(company.getCompno(),company.getCompnm(),company.getCphon(),company.getEmail(),company.getCustno(),company.getCeonm());
            if(Suss!=0){
                return new UserInf.Response(1,company.getCompnm()+" 님 회원 수정에 성공 하셨습니다." );
            }else{
                return new UserInf.Response(-1,"알수 없는 에러 입니다." );
            }

        }else{//회사코드가 없는겅우
            return new UserInf.Response(-1,company.getCompnm() + " 님의 정보가 없습니다." );
        }
    }

    //삭제
    @DeleteMapping("companyinfodel")
    public UserInf.Response companyinfoDelete(@RequestBody @Valid CompanyInf.RequestCompanyCreate company) {
        int Suss = 0;
        CompanyInf.Company companymember = compaynyMapper.findByCompno(company.getCompno()).orElse(null);

        if(companymember!=null){
            //insert만들기
            Suss = compaynyMapper.setCompanyInfoDelete(companymember.getCompno());
            if(Suss!=0){
                return new UserInf.Response(1,companymember.getCompnm()+" 님의 정보를 삭제하였습니다." );
            }else{
                return new UserInf.Response(-1,"알수 없는 에러 입니다." );
            }

        }else{//회사코드가 없는겅우
            return new UserInf.Response(-1,"가입정보가 없습니다." );
        }
    }

    //smscharge 조회
    @PostMapping("company")
    public List<String> allCompany(@RequestBody @Valid CompanyInf.RequestCompanyCreate company) {

        List<String> list = new ArrayList<>();

        CompanyInf.Company data = compaynyMapper.findByCompno(company.getCompno()).orElse(null);
        if(data==null){
            return list;
        }
        list.add(String.valueOf(data.getCompno()));//01 COMPNo
        list.add(data.getCompnm());//02 compnm
        list.add(data.getSb_cmp_id());//03 sb_cmp_id
        list.add(data.getSb_auth_key());//04 sb_auth_key
        list.add(data.getSb_prod_file());//05 sb_prod_file
        list.add(data.getSb_ord_file());//06 sb_ord_file
        list.add(data.getSb_claim_file());//07 sb_claim_file
        list.add(data.getEc_com_cd());//08 ec_com_cd
        list.add(data.getEc_usr_id());//09 ec_usr_id
        list.add(data.getEc_api_key());//10 ec_api_key
        list.add(data.getImgfolder());//11
        list.add(data.getCustno());//12
        list.add(data.getCeonm());//13
        list.add(data.getZipcode());//14
        list.add(data.getAddress());//15
        list.add(data.getBusiness());//16
        list.add(data.getEvent());//17
        list.add(data.getTelno());//18
        list.add(data.getCphon());//19
        list.add(data.getFaxno());//20
        list.add(data.getEmail());//21
        list.add(data.getKakao_key());//22
        list.add(data.getSabangid());//23
        list.add(data.getSabangpw());//24
        list.add(data.getCompals());//25 compals
        list.add(data.getUserid());//26 userid
        return list;

    }

    @PostMapping("custnocheck")
    public UserInf.Response custnoCheck(@RequestBody @Valid CompanyInf.Company company) {
        if(company.getCustno().replaceAll("-","").length()!=10){
            return new UserInf.Response(-1,"유효하지 않는 사업자번호입니다." );
        }
        CompanyInf.Company Suss = compaynyMapper.findByCustNo(company.getCustno()).orElse(null);

        System.out.println(Suss);
        if(Suss == null){//가입가능
            return new UserInf.Response(1,"회원가입 가능한아이디 입니다." );
        }else{//불가
            return new UserInf.Response(-1,"중복된 사업자 번호입니다." );
        }
    }
}
