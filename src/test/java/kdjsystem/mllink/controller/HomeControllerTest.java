package kdjsystem.mllink.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kdjsystem.mllink.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)

@AutoConfigureMockMvc
public class HomeControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void login() throws  Exception{
//
//        mockMvc.perform(post("/signUp")
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .accept(MediaType.APPLICATION_JSON_VALUE)
//                .content(objectMapper.writeValueAsString(param)))
//                .andDo(print())
//                .andExpect(status().isOk());
    }



//    @Test
//    public void add() throws Exception {
//        UserParam param = UserParam.builder()
//                            .compno(9999)
//                            .userid("kdjsystem")
//                            .password("12345")
//                            .email("kdjsystem")
//                            .username("홍길동")
//                            .ssn("123456")
//                            .build();
//
//        System.out.println(objectMapper.writeValueAsString(param));
//
//        mockMvc.perform(post("/signUp")
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .accept(MediaType.APPLICATION_JSON_VALUE)
//                .content(objectMapper.writeValueAsString(param)))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }

}