package hu.nye.progkor.esport.service;

import hu.nye.progkor.esport.model.User;
import hu.nye.progkor.esport.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

  User save(UserRegistrationDto registrationDto);

}
