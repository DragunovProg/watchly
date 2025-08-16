package ua.dragunov.watchlyapi.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dragunov.watchlyapi.dto.UserCreateRequest;
import ua.dragunov.watchlyapi.mapper.UserMapper;
import ua.dragunov.watchlyapi.model.User;
import ua.dragunov.watchlyapi.repository.UserRepository;


@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }

    @Transactional
    public void register(UserCreateRequest registrationRequest) {
        if (userRepository.existsByEmail(registrationRequest.email())) {
            throw new RuntimeException("Email address already in use");
        }

        User user = userMapper.toUser(registrationRequest);
        user.setPassword(passwordEncoder.encode(registrationRequest.password()));
    }

    @Transactional
    public void removeByEmail(String email) {
        userRepository.deleteByEmail(email);
    }
}
