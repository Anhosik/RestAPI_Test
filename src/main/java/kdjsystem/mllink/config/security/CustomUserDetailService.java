package kdjsystem.mllink.config.security;
import kdjsystem.mllink.domain.UserInf;
import kdjsystem.mllink.domain.composit_pk.UserId;
import kdjsystem.mllink.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;



    @Override
    public UserInf loadUserByUsername(String userPk) {
        List<String>  list_user = Arrays.asList(userPk.split(","));
        return userRepository.findById( UserId.getUserId(Integer.parseInt(list_user.get(0)), list_user.get(1).toString()))
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }
}