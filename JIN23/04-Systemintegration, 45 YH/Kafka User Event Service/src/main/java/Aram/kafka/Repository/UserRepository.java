package Aram.kafka.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Aram.kafka.payload.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

