package dima.d.coder.restapp.controller;

import dima.d.coder.api.GroupsApi;
import dima.d.coder.model.GroupFilter;
import dima.d.coder.model.GroupResponse;
import dima.d.coder.model.ListGroup;
import dima.d.coder.restapp.group.GroupStorage;
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
