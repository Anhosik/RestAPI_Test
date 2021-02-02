package kdjsystem.mllink.api;

import kdjsystem.mllink.domain.Companyinfo;
import kdjsystem.mllink.dto.Result;
import kdjsystem.mllink.dto.company.CompanyInf;
import kdjsystem.mllink.service.company.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
@RequestMapping("/api/v1/")
public class CompanyApiController {
    private  final CompanyService companyService;

    @GetMapping("company")
    @ResponseBody
    public Result select(){
        List<Companyinfo>  companyinfos = companyService.findAll();

         List<CompanyInf.ResponseSelect> datas =     companyinfos.stream()
                .map( p->new CompanyInf.ResponseSelect(p.getCompno(), p.getCompnm())  )
                .collect(Collectors.toList());

         return  new Result(datas);

    }

}
