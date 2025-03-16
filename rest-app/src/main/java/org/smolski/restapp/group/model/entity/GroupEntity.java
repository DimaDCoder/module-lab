package org.smolski.restapp.group.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.List;
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

//    @OneToMany
//    @JoinColumn(name = "group_id")
//    @SQLRestriction("is_curator = false")
//    List<GroupUserEntity> groupMembers;
//
//    @OneToMany
//    @JoinColumn(name = "group_id")
//    @SQLRestriction("is_curator = true")
//    List<GroupUserEntity> groupCurators;

    @CreationTimestamp
    OffsetDateTime dateCreate;

    @UpdateTimestamp
    OffsetDateTime dateUpdate;
}