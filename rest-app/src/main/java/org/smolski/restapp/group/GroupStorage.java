package org.smolski.restapp.group;

import org.smolski.restapp.group.model.entity.GroupEntity;
import org.smolski.model.GroupFilter;

import java.util.List;
import java.util.UUID;

public interface GroupStorage {

    GroupEntity getById(UUID id);

    List<GroupEntity> getGroups(GroupFilter params);
}
