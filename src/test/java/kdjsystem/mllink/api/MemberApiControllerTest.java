package kdjsystem.mllink.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import kdjsystem.mllink.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class MemberApiControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ObjectMapper objectMapper;

//    @Test
//    public void login() throws  Exception{
//        User.RequestLogin user = new User.RequestLogin();
//        user.setCompno(2);
//        user.setUserid("153333");
//        user.setPassword("1q2w3e4r");
//
//        mockMvc.perform(post("/login")
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .accept(MediaType.APPLICATION_JSON_VALUE)
//                .content(objectMapper.writeValueAsString(user)))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }

}