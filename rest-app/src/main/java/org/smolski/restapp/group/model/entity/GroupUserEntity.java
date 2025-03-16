package org.smolski.restapp.group.model.entity;

import org.smolski.restapp.user.model.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "group_user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupUserEntity {

    @EmbeddedId
    GroupUserId id;

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "group_id")
    GroupEntity groupEntity;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    UserEntity userEntity;

    @Column(nullable = false)
    Boolean isCurator;

    @CreationTimestamp
    OffsetDateTime dateCreate;
}
