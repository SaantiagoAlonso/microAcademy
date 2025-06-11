package co.scastillos.microservices.user_microservice.service;

import co.scastillos.microservices.user_microservice.configuration.UserMapping;
import co.scastillos.microservices.user_microservice.domain.user.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapping userMapping;

    public void createUser(@Valid NewUserRequest newUser) {
        User user = userMapping.toUser(newUser);
        userRepository.save(user);
    }

    public List<UserResponse> findAll() {
        return userRepository.findAll().stream().map(userMapping::toUserResponse).toList();
    }

    public UserResponse findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapping.toUserResponse(user);
    }

    @Transactional
    public UserResponse updateUser(@Valid UpdateUserRequest userDto) {
        User user = userRepository.findById(userDto.id()).orElseThrow();
        User userUpdate = userMapping.updateUserFromDto(userDto,user);
        userRepository.save(userUpdate);
        return userMapping.toUserResponse(userUpdate);
    }

    public void deleteUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }
}
