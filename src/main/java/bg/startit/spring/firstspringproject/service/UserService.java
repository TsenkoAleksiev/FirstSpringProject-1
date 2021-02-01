package bg.startit.spring.firstspringproject.service;

import bg.startit.spring.firstspringproject.model.User;
import bg.startit.spring.firstspringproject.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository,
      PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    // create admin user
    if (userRepository.count() == 0) {
      User user = new User();
      user.setUsername("admin");
      user.setPassword(passwordEncoder.encode("admin"));
      userRepository.save(user);
    }
    return userRepository.findByUsername(s)
        .orElseThrow(() -> new UsernameNotFoundException("Not Found."));
  }
}
