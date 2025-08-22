package ua.dragunov.watchlyapi.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dragunov.watchlyapi.dto.UserCreateRequest;
import ua.dragunov.watchlyapi.dto.UserResponse;
import ua.dragunov.watchlyapi.dto.UserUpdateRequest;
import ua.dragunov.watchlyapi.mapper.UserMapper;
import ua.dragunov.watchlyapi.model.Role;
import ua.dragunov.watchlyapi.model.User;
import ua.dragunov.watchlyapi.repository.RoleRepository;
import ua.dragunov.watchlyapi.repository.UserRepository;

import java.util.Optional;


@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        user.getAuthorities().size();
        return user;
    }

    @Transactional
    public UserResponse register(UserCreateRequest registrationRequest) {
        if (userRepository.existsByEmail(registrationRequest.email())) {
            throw new RuntimeException("Email address already in use");
        }

        User user = userMapper.toUser(registrationRequest);
        user.setPassword(passwordEncoder.encode(registrationRequest.password()));

        Role role = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new RuntimeException("Role not found"));


        user.addRole(role);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Transactional
    public void update(String email, UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        userRepository.save(userMapper.toUser(userUpdateRequest, user));
    }

    @Transactional
    public void updateById(long id, UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));

        userRepository.save(userMapper.toUser(userUpdateRequest, user));
    }

    @Transactional
    public UserResponse findById(long id) {
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id)));
    }

    @Transactional(readOnly = true)
    public UserResponse findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toUserResponse)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }

    @Transactional
    public void removeByEmail(String email) {
        userRepository.deleteByEmail(email);
    }
}
