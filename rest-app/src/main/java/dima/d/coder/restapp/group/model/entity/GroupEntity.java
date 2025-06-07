package dima.d.coder.restapp.group.model.entity;

import dima.d.coder.restapp.user.model.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "group_g")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    @Builder.Default
    Boolean isActive = true;

    @ManyToOne
    UserEntity author;

    @CreationTimestamp
    OffsetDateTime dateCreate;

    @UpdateTimestamp
    OffsetDateTime dateUpdate;
}