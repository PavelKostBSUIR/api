package com.bitdev.api.api.mapper;

import com.bitdev.api.api.dto.user.*;
import com.bitdev.api.api.entity.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    User createUserDtoToUser(CreateUserDto createUserDto);

    CreateUserDto userToCreateUserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUserFromCreateUserDto(CreateUserDto createUserDto, @MappingTarget User user);

    User userCreatedDtoToUser(UserCreatedDto userCreatedDto);

    UserCreatedDto userToUserCreatedDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUserFromUserCreatedDto(UserCreatedDto userCreatedDto, @MappingTarget User user);

    User updateUserStatusDtoToUser(UpdateUserStatusDto updateUserStatusDto);

    UpdateUserStatusDto userToUpdateUserStatusDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUserFromUpdateUserStatusDto(UpdateUserStatusDto updateUserStatusDto, @MappingTarget User user);

    User userStatusUpdatedDtoToUser(UserStatusUpdatedDto userStatusUpdatedDto);

    UserStatusUpdatedDto userToUserStatusUpdatedDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUserFromUserStatusUpdatedDto(UserStatusUpdatedDto userStatusUpdatedDto, @MappingTarget User user);

    User getUserDtoToUser(GetUserDto getUserDto);

    GetUserDto userToGetUserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUserFromGetUserDto(GetUserDto getUserDto, @MappingTarget User user);
}
