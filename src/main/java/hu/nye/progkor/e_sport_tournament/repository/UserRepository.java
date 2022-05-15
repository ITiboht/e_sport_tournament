package hu.nye.progkor.e_sport_tournament.repository;

import hu.nye.progkor.e_sport_tournament.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
