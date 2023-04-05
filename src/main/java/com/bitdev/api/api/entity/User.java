package com.bitdev.api.api.entity;

import com.bitdev.api.api.enumer.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    String name;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    @NotNull
    Status status = Status.OFFLINE;

    @Column(unique = true)
    @Email
    String email;

    @NotBlank
    String imageURI;
}
