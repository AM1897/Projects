package Aram.WebServiceBooks.login.repo;

import Aram.WebServiceBooks.login.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {


    boolean existsByUsername(String username);
    boolean existsById(Long id);



    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findById (long id);

}