package dima.d.coder.restapp.group.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import dima.d.coder.restapp.user.model.entity.UserEntity;

import java.io.Serializable;

@Data
@Embeddable
public class GroupUserId implements Serializable {

    @ManyToOne
    GroupEntity group;

    @ManyToOne
    UserEntity user;
}
