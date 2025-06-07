package dima.d.coder.restapp.group.model.entity;

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

    @Column(nullable = false)
    Boolean isCurator;

    @CreationTimestamp
    OffsetDateTime dateCreate;
}
