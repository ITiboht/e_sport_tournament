package hu.nye.progkor.e_sport_tournament.service;

import hu.nye.progkor.e_sport_tournament.model.User;
import hu.nye.progkor.e_sport_tournament.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

  User save(UserRegistrationDto registrationDto);

}
