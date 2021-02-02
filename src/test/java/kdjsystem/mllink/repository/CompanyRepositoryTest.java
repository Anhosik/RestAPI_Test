package kdjsystem.mllink.repository;

import kdjsystem.mllink.domain.Companyinfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyRepositoryTest {
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    @Commit
    public void 회사정보_저장() throws Exception{
        //  given
        Companyinfo companyinfo =   Companyinfo.builder()
                .compno(1)
                .compnm("도매의신")
                .sb_cmp_id("dosin")
                .compals("D1").build();

        em.persist(companyinfo);

        int orderCount = 2;
        // when
        Companyinfo findCompanyInfo =     companyRepository.findById(companyinfo.getCompno()).orElse(null);
        // then
        assertEquals("상품 저장은 잘되는가", companyinfo.getCompno(), findCompanyInfo.getCompno());
    }

}