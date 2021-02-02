package kdjsystem.mllink.api;

import kdjsystem.mllink.dto.sms.SmsInf;
import kdjsystem.mllink.dto.user.UserInf;
import kdjsystem.mllink.mapper.SmsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
@RequestMapping("/api/v1/")
public class SmsChargeAPI {

    private  final SmsMapper smsMapper;
    //smscharge 저장
    @PostMapping("smscharge")
    public UserInf.Response smsChargeInsert(@RequestBody @Valid SmsInf.RequestSmsChargeMst smscharge) {
        int Suss = 0;
        SmsInf.RequestSmsCharge smschargemst = smsMapper.findBySmsCharge(smscharge.getUserid()).orElse(null);

        if(smschargemst!=null){
            return new UserInf.Response(-1,smschargemst.getUserid() + " 이미 가입되어 있습니다" );
        }else{
            //insert만들기
            Suss = smsMapper.setSmsChargeMst(smscharge.getCompno(),smscharge.getUserid(),smscharge.getSmsaliase());
            if(Suss!=0){
                return new UserInf.Response(1,smscharge.getUserid()+" 님 문자정보가입에 성공 하셨습니다." );
            }else{
                return new UserInf.Response(-1,"알수 없는 에러 입니다." );
            }
        }
    }

    @PostMapping("smschargemst")
    public UserInf.Response smsChargeMstUpdate(@RequestBody @Valid SmsInf.RequestSmsChargeMst smscharge) {
        int Suss = 0;
        //update
        Suss = smsMapper.setSmsChargeMstUpdate(smscharge.getUserid(),smscharge.getSmsuseamt(),smscharge.getSmsbalance(),smscharge.getSerialno());
        if(Suss!=0){
            return new UserInf.Response(1,"성공하였습니다." );
        }else{
            return new UserInf.Response(-1,"알수 없는 에러 입니다." );
        }
    }
    //smscharge 조회
    @PostMapping("smschargeselect")
    public List<String> smsChargeMstSelect(@RequestBody @Valid SmsInf.RequestSmsChargeMst smscharge) {

        List<String> list = new ArrayList<>();

        SmsInf.RequestSmsChargeMst data = smsMapper.smsSelect(smscharge.getUserid());
        if(data==null){
            return list;
        }
        list.add(String.valueOf(data.getCompno()));
        list.add(data.getSmsaliase());
        list.add(data.getSmsno());
        list.add(String.valueOf(data.getSmschgamt()));
        list.add(String.valueOf(data.getSmsuseamt()));
        list.add(String.valueOf(data.getSmsbalance()));
        list.add(String.valueOf(data.getContprice()));
        list.add(String.valueOf(data.getSerialno()));
        list.add(data.getUserid());
        list.add(String.valueOf(data.getSmsprice()));
        list.add(String.valueOf(data.getLmsprice()));
        return list;

    }
    @PostMapping("smschargedtl")
    public UserInf.Response smsChargeDtl(@RequestBody @Valid SmsInf.RequestSmsChargeDtl smscharge) {
        int Suss = 0;

        //insert만들기
        Suss = smsMapper.setSmsChargeDtl(smscharge.getCompno(),smscharge.getAliaseseq(),smscharge.getTocontact(),smscharge.getContents(),smscharge.getSentdate(),
                smscharge.getTimespent(),smscharge.getSmstype(),smscharge.getUserid());
        if(Suss!=0){
            return new UserInf.Response(1,"성공하였습니다." );
        }else{
            return new UserInf.Response(-1,"알수 없는 에러 입니다." );
        }
    }

    @PostMapping("smschargeserialup")
    public UserInf.Response smsChargeSerialUpdate(@RequestBody @Valid SmsInf.RequestSmsChargeMst smscharge) {
        int Suss = 0;
        //update
        Suss = smsMapper.setSmsChargeSerial(smscharge.getUserid(),smscharge.getSerialno());
        if(Suss!=0){
            return new UserInf.Response(1,"성공하였습니다." );
        }else{
            return new UserInf.Response(-1,"알수 없는 에러 입니다." );
        }
    }

    @PostMapping("smsprice")
    public UserInf.Response smsChargeInsertNUpdate(@RequestBody @Valid SmsInf.RequestSmsChargeMst smscharge) {
        int Suss = 0;
        SmsInf.RequestSmsChargeMst smschargemst = smsMapper.findBySmscheck(smscharge.getCompno(),smscharge.getUserid()).orElse(null);

        if(smschargemst!=null){//업데이트하기
            Suss = smsMapper.setSmsPriceUpdate(smscharge.getCompno(),smscharge.getUserid(),(smscharge.getSmschgamt()+smschargemst.getSmschgamt()),(smscharge.getSmsbalance()+smschargemst.getSmsbalance()));
            if(Suss!=0){
                return new UserInf.Response(1,"정상처리" );
            }else{
                return new UserInf.Response(-1,"알수 없는 에러 입니다." );
            }
        }else{
            return new UserInf.Response(-1,"회원정보가 없습니다." );
        }
    }

    @PostMapping("smschargedtlall")
    public List<List<String>> smsChargeDtlAllSelect(@RequestBody @Valid SmsInf.RequestSmsChargeDtl smscharge) {
        List<List<String>> contents = new ArrayList<>();

        List<SmsInf.RequestSmsChargeDtl> datas = smsMapper.smschargeDtlAll(smscharge.getUserid());
        if(datas==null){
            return contents;
        }else{
            for(SmsInf.RequestSmsChargeDtl data : datas){
                List<String> list = new ArrayList<>();
                list.add(String.valueOf(data.getAliaseseq()));
                list.add(data.getTocontact());
                list.add(data.getContents());
                list.add(data.getSentdate());
                list.add(data.getTimespent());
                list.add(data.getSmstype());
                if (data.getSmstype().equals("KAKAO")) {
					list.add("13");
				} else if (data.getSmstype().equals("MMS")) {
					list.add("20");
				} else if (data.getSmstype().equals("LMS")) {
					list.add("53");
				} else {
					list.add("0");
				}
                contents.add(list);
            }
            return contents;
        }


    }

    @PostMapping("smsdtl")
    public List<List<String>> smsChargeDtlSelect(@RequestBody @Valid SmsInf.RequestChargeDtl smscharge) {
        List<List<String>> contents = new ArrayList<>();
        smscharge.setContent(smscharge.getContent()==null?"%%":"%"+smscharge.getContent()+"%");
        List<SmsInf.RequestSmsChargeDtl> datas = null;
        switch (smscharge.getSelect()){
            case 0 : datas = smsMapper.smschargeDtlseq(smscharge.getUserid(),smscharge.getOrddtFrom(),smscharge.getOrddtTo(),smscharge.getContent()==null?"":smscharge.getContent());
                break;
            case 1 : datas = smsMapper.smschargeDtltocontact(smscharge.getUserid(),smscharge.getOrddtFrom(),smscharge.getOrddtTo(),smscharge.getContent()==null?"":smscharge.getContent());
                break;
            case 2 : datas = smsMapper.smschargeDtlcontents(smscharge.getUserid(),smscharge.getOrddtFrom(),smscharge.getOrddtTo(),smscharge.getContent()==null?"":smscharge.getContent());
                break;
        }

        if(datas==null){
            return contents;
        }else{
            for(SmsInf.RequestSmsChargeDtl data : datas){
                List<String> list = new ArrayList<>();
                list.add(String.valueOf(data.getAliaseseq()));
                list.add(data.getTocontact());
                list.add(data.getContents());
                list.add(data.getSentdate());
                list.add(data.getTimespent());
                list.add(data.getSmstype());
                if (data.getSmstype().equals("KAKAO")) {
                    list.add("13");
                } else if (data.getSmstype().equals("MMS")) {
                    list.add("20");
                } else if (data.getSmstype().equals("LMS")) {
                    list.add("53");
                } else {
                    list.add("0");
                }
                contents.add(list);
            }
            return contents;
        }


    }
}
