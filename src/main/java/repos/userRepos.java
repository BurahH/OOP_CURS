package repos;

import domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepos extends JpaRepository<User, Long> {
}
