package repos;

import domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface carRepos extends JpaRepository<Car, Long> {
}
