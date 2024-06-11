package com.techalchemy.crud_user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private byte age;
}
