package kdjsystem.mllink.repository;

import kdjsystem.mllink.domain.Companyinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CompanyRepository extends JpaRepository<Companyinfo, Integer> {

}
