package kdjsystem.mllink.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
@RequestMapping("/user/api/v1/")
public class SMSApiController {

    @GetMapping("sms")
    public String getSms(){
        return "ssmsdfsf";
    }
}
