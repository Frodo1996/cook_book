package pl.javastart.cookbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.cookbook.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
