package pl.matkoc.Approval_material.service.registration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.matkoc.Approval_material.domain.model.Material;
import pl.matkoc.Approval_material.domain.model.User;
import pl.matkoc.Approval_material.domain.repository.UserRepository;
import pl.matkoc.Approval_material.service.RegistrationService;

@Service @Slf4j
public class DefaultRegistrationService implements RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public DefaultRegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void register(RegistrationData registrationData) {
        log.debug("Dane do rejestracji: {}", registrationData);
        User user =  new User();
        user.setFirstName((registrationData.getFirstName()));
        user.setLastName(registrationData.getLastName());
        user.setUsername(registrationData.getUsername());
        user.setPassword(passwordEncoder.encode(registrationData.getPassword()));
        user.setEmail(registrationData.getEmail());
        user.setActive(true);
        log.debug("Użytkownik do zapisu:{}", user);
        userRepository.save(user);
        log.debug("Zapisano użytkownika: {}",user);

    }
}
