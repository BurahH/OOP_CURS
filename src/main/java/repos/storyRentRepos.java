package repos;

import domain.StoryRent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface storyRentRepos extends JpaRepository<StoryRent, Long> {
}
