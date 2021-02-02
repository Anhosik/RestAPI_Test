package kdjsystem.mllink.repository;

import kdjsystem.mllink.domain.composit_pk.UserId;
import kdjsystem.mllink.domain.UserInf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserInf, UserId> {

    Optional<UserInf> findByEmail(String email);
}
