package dima.d.coder.restapp.group;

import dima.d.coder.model.GroupFilter;
import dima.d.coder.restapp.group.model.entity.GroupEntity;

import java.util.List;
import java.util.UUID;

public interface GroupStorage {

    GroupEntity getById(UUID id);

    List<GroupEntity> getGroups(GroupFilter params);
}
