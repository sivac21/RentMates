package com.stackroute.tenantprofileservice.service;

import com.stackroute.tenantprofileservice.exception.TenantGroupNotFoundException;
import com.stackroute.tenantprofileservice.model.GroupChat;
import com.stackroute.tenantprofileservice.model.TenantGroup;

import java.util.List;

/**
 * @Author Siva
 * @Date 12/11/2021 11:46 AM
 */
public interface TenantGroupService {
    TenantGroup saveGroup(TenantGroup tenantGroup) throws Exception;
    List<TenantGroup> getAllGroups() throws Exception;
    TenantGroup updateGroup(GroupChat groupChat, String groupName) throws TenantGroupNotFoundException;
    TenantGroup getTenantGroupByName(String groupName) throws TenantGroupNotFoundException;
    TenantGroup deleteGroup(String groupName) throws TenantGroupNotFoundException;
//    List<TenantGroup> getTenantGroupsByEmail(String email);
}
