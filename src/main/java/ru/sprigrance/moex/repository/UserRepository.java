package ru.sprigrance.moex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sprigrance.moex.domain.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
