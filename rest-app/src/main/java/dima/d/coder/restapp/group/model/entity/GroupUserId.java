package dima.d.coder.restapp.group.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import dima.d.coder.restapp.user.model.entity.UserEntity;

import java.io.Serializable;

@Data
@Embeddable
public class GroupUserId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "group_id")
    GroupEntity groupEntity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity userEntity;
}
