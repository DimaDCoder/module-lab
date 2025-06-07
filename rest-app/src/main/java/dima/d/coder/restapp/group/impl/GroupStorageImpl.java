package dima.d.coder.restapp.group.impl;

import dima.d.coder.model.GroupFilter;
import dima.d.coder.restapp.group.GroupStorage;
import dima.d.coder.restapp.group.model.entity.GroupEntity;
import dima.d.coder.restapp.group.model.entity.GroupUserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GroupStorageImpl implements GroupStorage {

    EntityManager entityManager;
    GroupRepository groupRepository;

    @Override
    public GroupEntity getById(UUID id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public List<GroupEntity> getGroups(GroupFilter params) {
        return List.of();
    }

    public List<GroupEntity> getGroups(String curatorFirstName) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<GroupEntity> cq = cb.createQuery(GroupEntity.class);
        Root<GroupUserEntity> from = cq.from(GroupUserEntity.class);
        cq.select(from.get("groupEntity"));
        cq.distinct(true);

//        Fetch<Object, Object> groupEntity = from.fetch("groupEntity");
        Join<Object, Object> userEntityJoin = from.join("userEntity");

        cq.where(cb.and(
//                cb.equal(userEntityJoin.get("firstName"), curatorFirstName)),
                cb.isTrue(userEntityJoin.get("isActive"))),
                cb.isFalse(from.get("isCurator")));

        int pageNumber = 1;
        int pageSize = 5;

        List<GroupEntity> resultList = entityManager.createQuery(cq)
                .setFirstResult((pageNumber - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();

        return resultList;
    }
}
