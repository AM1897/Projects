package teamwordk.WebServiceApi.login.repo;

import teamwordk.WebServiceApi.login.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Här kan du lägga till anpassade frågemetoder om det behövs, exempelvis:
    Role findByName(String name);
}

