package Server.repos;

import API.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface messageRepos extends JpaRepository<Message, Long> {
}
