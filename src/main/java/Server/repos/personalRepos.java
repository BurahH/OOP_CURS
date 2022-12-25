package Server.repos;

import API.domain.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface personalRepos extends JpaRepository<Personal, Long> {
}
