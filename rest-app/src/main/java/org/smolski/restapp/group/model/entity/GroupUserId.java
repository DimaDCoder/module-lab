package org.smolski.restapp.group.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Embeddable
public class GroupUserId implements Serializable {

    UUID groupId;

    String userId;
}
