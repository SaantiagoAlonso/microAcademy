package co.scastillos.microservices.user_microservice.configuration;

import co.scastillos.microservices.user_microservice.domain.user.NewUserRequest;
import co.scastillos.microservices.user_microservice.domain.user.UpdateUserRequest;
import co.scastillos.microservices.user_microservice.domain.user.User;
import co.scastillos.microservices.user_microservice.domain.user.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapping {

    public User toUser(NewUserRequest newUserDto){
        return User.builder()
                .username(newUserDto.username())
                .password(newUserDto.password())
                .name(newUserDto.name())
                .lastname(newUserDto.lastname())
                .email(newUserDto.email())
                .age(newUserDto.age())
                .phone(newUserDto.phone())
                .build();
    }

    public User toUser(UpdateUserRequest userUpdate){
        return User.builder()
                .username(userUpdate.username())
                .password(userUpdate.password())
                .name(userUpdate.name())
                .lastname(userUpdate.lastname())
                .email(userUpdate.email())
                .age(userUpdate.age())
                .phone(userUpdate.phone())
                .build();
    }

    public UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .lastname(user.getLastname())
                .name(user.getName())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .age(user.getAge())
                .phone(user.getPhone())
                .build();
    }


}
