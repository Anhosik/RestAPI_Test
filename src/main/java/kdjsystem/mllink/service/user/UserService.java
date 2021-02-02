package kdjsystem.mllink.service.user;

import kdjsystem.mllink.domain.UserInf;
import kdjsystem.mllink.domain.composit_pk.UserId;
import kdjsystem.mllink.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void signUp(UserInf userVO) {
         userRepository.save(userVO);
    }


    public Optional<UserInf> findByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }

    public Optional<UserInf> findByUserId(Integer compno, String userID){
        return userRepository.findById(UserId.getUserId(compno, userID));
    }


    public List<UserInf> findAll() {
        return userRepository.findAll();
    }

}
