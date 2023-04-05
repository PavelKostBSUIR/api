package com.bitdev.api.api.dto.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
public class UpdateUserStatusDto implements Serializable {
    @NotNull
    String status;

    @JsonCreator
    public UpdateUserStatusDto(@JsonProperty("status") String status) {
        this.status = status;
    }
}
