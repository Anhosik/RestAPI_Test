package kdjsystem.mllink.service.company;

import kdjsystem.mllink.domain.Companyinfo;
import kdjsystem.mllink.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private  final CompanyRepository companyRepository;

    public Optional<Companyinfo> findById(Integer id){
         return   companyRepository.findById(id);
    }

    public List<Companyinfo> findAll(){
        return   companyRepository.findAll();
    }
}
