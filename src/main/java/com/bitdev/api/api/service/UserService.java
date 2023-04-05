package com.bitdev.api.api.service;

import com.bitdev.api.api.dto.user.*;
import com.bitdev.api.api.entity.User;
import com.bitdev.api.api.enumer.Status;
import com.bitdev.api.api.mapper.UserMapper;
import com.bitdev.api.api.repo.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Data
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    @Transactional
    public UserCreatedDto create(CreateUserDto createUserDto) {
        return userMapper.userToUserCreatedDto(userRepository.save(userMapper.createUserDtoToUser(createUserDto)));
    }

    @Transactional
    public GetUserDto get(Long id) {
        return userMapper.userToGetUserDto(userRepository.getReferenceById(id));
    }

    public UserStatusUpdatedDto updateStatus(Long id, UpdateUserStatusDto updateUserStatusDto) {
        User user = userRepository.getReferenceById(id);
        Status oldStatus = user.getStatus();
        Status newStatus = Status.getStatusFromCode(updateUserStatusDto.getStatus());
        UserStatusUpdatedDto userStatusUpdatedDto = UserStatusUpdatedDto.builder().status(newStatus).oldStatus(oldStatus).id(id).build();
        user.setStatus(newStatus);
        userRepository.save(user);
        return userStatusUpdatedDto;
    }
}
