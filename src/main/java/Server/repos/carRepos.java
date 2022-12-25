package Server.repos;

import API.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface carRepos extends JpaRepository<Car, Long> {
}
