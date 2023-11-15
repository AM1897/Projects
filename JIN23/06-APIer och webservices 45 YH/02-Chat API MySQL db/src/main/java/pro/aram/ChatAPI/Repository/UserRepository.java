package pro.aram.ChatAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.aram.ChatAPI.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
