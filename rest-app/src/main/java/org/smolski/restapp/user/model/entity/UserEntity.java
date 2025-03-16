package org.smolski.restapp.user.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_u")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {

    @Id
    String id;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    String middleName;

    @Column(nullable = false)
    @Builder.Default
    Boolean isActive = true;

    @CreationTimestamp
    OffsetDateTime dateCreate;

    @UpdateTimestamp
    OffsetDateTime dateUpdate;
}