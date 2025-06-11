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
        if (userDto.username() != null){
            user.setUsername(userDto.username());
        }
        if(userDto.password() != null){
            user.setPassword(userDto.password());
        }
        if(userDto.username() != null){
            user.setUsername(userDto.username());
        }
        if(userDto.name() != null){
            user.setName(userDto.name());
        }
        if(userDto.lastname() != null){
            user.setLastname(userDto.lastname());
        }
        if(userDto.email() != null){
            user.setEmail(userDto.email());
        }
        if(userDto.age() != null){
            user.setAge(userDto.age());
        }
        if(userDto.phone() != null){
            user.setPhone(userDto.phone());
        }
        userRepository.save(user);
        return userMapping.toUserResponse(user);
    }

    public void deleteUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }
}
