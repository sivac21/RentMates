package com.stackroute.tenantprofileservice.controller;

import com.stackroute.tenantprofileservice.exception.TenantGroupNotFoundException;
import com.stackroute.tenantprofileservice.model.GroupChat;
import com.stackroute.tenantprofileservice.model.TenantGroup;
import com.stackroute.tenantprofileservice.service.GroupServiceImpl;
import com.stackroute.tenantprofileservice.service.TenantGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Siva
 * @Date 12/11/2021 1:06 PM
 */
@Slf4j
@RestController
@RequestMapping("/api/v1")
//@CrossOrigin
public class TenantGroupController {
    private TenantGroupService tenantGroupService;
    private ResponseEntity responseEntity;
    private GroupServiceImpl groupServiceImpl;

    @Autowired
    public TenantGroupController(TenantGroupService tenantGroupService, GroupServiceImpl groupServiceImpl) {
        this.tenantGroupService = tenantGroupService;
        this.groupServiceImpl = groupServiceImpl;
    }

    @PostMapping("/group")
    public ResponseEntity<TenantGroup> saveGroup(@RequestBody TenantGroup tenantGroup) throws Exception {
        log.debug("Save request received for Tenant group" + tenantGroup + "at" + java.time.LocalDateTime.now());
        try {
            log.info("Group details" + tenantGroup);
            TenantGroup savedGroup = tenantGroupService.saveGroup(tenantGroup);
            log.info("Saved group successfully" + savedGroup);
            responseEntity = new ResponseEntity<>(savedGroup, HttpStatus.OK);
        }
        catch (Exception e){
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/groups")
    public ResponseEntity<List<TenantGroup>> getAllGroups() throws Exception{
        responseEntity = new ResponseEntity<List<TenantGroup>>((List<TenantGroup>) tenantGroupService.getAllGroups(), HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/group/{groupName}")
    public ResponseEntity<?> updateGroup (@PathVariable("groupName") String groupName, @RequestBody GroupChat groupChat) throws TenantGroupNotFoundException{
        try {
            tenantGroupService.updateGroup(groupChat, groupName);
            responseEntity = new ResponseEntity<>(groupChat,HttpStatus.OK);
        }
        catch (TenantGroupNotFoundException e) {
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/groups/{groupName}")
    public ResponseEntity<?> getGroupByGroupName(@PathVariable("groupName") String groupName) throws TenantGroupNotFoundException{
        try {
            responseEntity = new ResponseEntity<>(tenantGroupService.getTenantGroupByName(groupName), HttpStatus.OK);
        }
        catch (Exception e){
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("/group/{groupName}")
    public ResponseEntity<?> deleteGroup(@PathVariable("groupName") String groupName) throws TenantGroupNotFoundException{
        try {
            tenantGroupService.deleteGroup(groupName);
        }
        catch (TenantGroupNotFoundException e){
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (Exception e) {
            log.error("Exception occur" + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/tenantgroups/{email}")
    public ResponseEntity<?> getGroupsByUserEmail(@PathVariable("email") String email) {
        try {
            responseEntity = new ResponseEntity(groupServiceImpl.getTenantGroupsByEmail(email),HttpStatus.OK);
        }
        catch (Exception e) {
            responseEntity = new ResponseEntity("Error! try after sometimes", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
