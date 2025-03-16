package org.smolski.restapp.controller;

import org.smolski.api.GroupsApi;
import org.smolski.restapp.group.GroupStorage;
import org.smolski.model.GroupFilter;
import org.smolski.model.GroupResponse;
import org.smolski.model.ListGroup;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GroupController implements GroupsApi {

    GroupStorage groupStorage;

    @Override
    public ResponseEntity<GroupResponse> getGroupById(UUID groupId) {
        return GroupsApi.super.getGroupById(groupId);
    }

    @Override
    public ResponseEntity<ListGroup> getGroupsByFilter(GroupFilter filterParams) {
        return GroupsApi.super.getGroupsByFilter(filterParams);
    }


    //    @GetMapping("/groups")
//    public List<GroupEntity> getAllByFilter(@RequestParam(required = false) String curatorFirstName) {
//        return groupStorage.getAllByFilter(curatorFirstName);
//    }
}
