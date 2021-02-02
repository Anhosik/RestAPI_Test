package kdjsystem.mllink.repository;

import kdjsystem.mllink.domain.Companyinfo;
import kdjsystem.mllink.domain.composit_pk.UserId;
import kdjsystem.mllink.domain.UserInf;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
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
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager em;


    @Transactional
    @Commit
    @Test
    public void 회정정보저장(){
        System.out.println("");
        System.out.println("BeforeEach method call");
       UserInf user1 =   UserInf.builder()
                .compno(1)
                .id("kdj")
                .passWord("1111")
                .build();

        UserInf user2 =   UserInf.builder()
                .compno(1)
                .id("kdj2")
                .passWord("1111")
                .build();

        UserInf user3 =   UserInf.builder()
                .compno(1)
                .id("kdj3")
                .passWord("1111")
                .ssn("780415")
                .build();

        em.persist(user1);
        em.persist(user2);
        em.persist(user3);
    }



    @Transactional
    @Commit
    @Test
    public void 회사정보_저장(){
        System.out.println("");
        System.out.println("BeforeEach method call");
        Companyinfo companyinfo =   Companyinfo.builder()
                .compno(9999)
                .compnm("개인사업자")
                .sb_cmp_id("8")
                .build();

        em.persist(companyinfo);
    }





    @Test
    @Transactional(readOnly =true)
    public void 사용자정보_조회() throws Exception{
        //  given
        UserInf user1 =  userRepository.findById ( UserId.getUserId(1,"kdj")).orElse(null);
        UserInf user2 =  userRepository.findById ( UserId.getUserId(1,"kdj2")).orElse(null);
        UserInf user3 =  userRepository.findById ( UserId.getUserId(1,"kdj3")).orElse(null);



        System.out.println(user1.getId().getUserId());
        System.out.println(user2.getId().getUserId());
        System.out.println(user3.getId().getUserId());
        System.out.println(user3.getUserCompInf().getSsn());
        // when

        // then
        //assertEquals("상품 저장은 잘되는가", companyinfo.getCompno(), findCompanyInfo.getCompno());
    }




    @Test
    @Transactional(readOnly =true)
    public void 사용자회사정보_조회() throws Exception{
        //  given
        UserInf user1 =  userRepository.findById ( UserId.getUserId(1,"kdj")).orElse(null);
       // UserInf user2 =  userRepository.findById ( UserId.getUserId(1,"kdj2")).orElse(null);
       // UserInf user3 =  userRepository.findById ( UserId.getUserId(1,"kdj3")).orElse(null);


        System.out.println( user1.getCompanyinfo().getCompnm());

        for( UserInf userInf :  user1.getCompanyinfo().getUserInf()){
            System.out.println(userInf.getId().getUserId());
        }

        // when

        // then
        //assertEquals("상품 저장은 잘되는가", companyinfo.getCompno(), findCompanyInfo.getCompno());
    }

}