package com.bitdev.api.api.dto.user;

import com.bitdev.api.api.enumer.Status;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
public class UserStatusUpdatedDto implements Serializable {
    @NotNull
    Long id;
    @NotNull
    Status status;
    @NotNull
    Status oldStatus;
}
