package repos;

import domain.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface personalRepos extends JpaRepository<Personal, Long> {
}
