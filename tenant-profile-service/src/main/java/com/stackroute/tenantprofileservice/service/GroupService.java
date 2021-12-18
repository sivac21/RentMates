package com.stackroute.tenantprofileservice.service;

import com.stackroute.tenantprofileservice.model.TenantGroup;

import java.util.List;

/**
 * @Author Siva
 * @Date 12/13/2021 1:06 PM
 */
public interface GroupService {
//    TenantGroup saveGroup(TenantGroup tenantGroup) throws TenantGroupAlreadyExistsException;
//    List<TenantGroup> getAllGroups() throws Exception;
//    TenantGroup updateGroup(GroupChat groupChat, String groupName) throws TenantGroupNotFoundException;
//    TenantGroup getTenantGroupByName(String groupName) throws TenantGroupNotFoundException;
//    TenantGroup deleteGroup(String groupName) throws TenantGroupNotFoundException;
    List<TenantGroup> getTenantGroupsByEmail(String email);
}
