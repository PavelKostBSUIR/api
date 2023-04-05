package com.bitdev.api.api.dto.user;

import com.bitdev.api.api.enumer.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
public class GetUserDto implements Serializable {
    @NotBlank
    String name;
    @NotNull
    Status status;
    @Email
    String email;
    @NotBlank
    String imageURI;
}
