package Server.repos;

import API.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface userRepos extends JpaRepository<User, Long> {
    List<User> findAllByUsername(String username);
}
