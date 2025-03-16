package org.smolski.restapp.group.repository;

import org.smolski.restapp.group.model.entity.GroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GroupRepository extends CrudRepository<GroupEntity, UUID> {
}
