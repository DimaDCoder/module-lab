package dima.d.coder.restapp.group.impl;

import dima.d.coder.restapp.group.model.entity.GroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface GroupRepository extends CrudRepository<GroupEntity, UUID> {
}
