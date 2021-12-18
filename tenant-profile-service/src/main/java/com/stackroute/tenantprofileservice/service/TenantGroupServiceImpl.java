package com.stackroute.tenantprofileservice.service;

import com.stackroute.tenantprofileservice.exception.TenantGroupNotFoundException;
import com.stackroute.tenantprofileservice.model.GroupChat;
import com.stackroute.tenantprofileservice.model.TenantGroup;
import com.stackroute.tenantprofileservice.repository.TenantGroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author Siva
 * @Date 12/11/2021 11:46 AM
 */

@Service
@Slf4j
public class TenantGroupServiceImpl implements TenantGroupService{

    private TenantGroupRepository tenantGroupRepository;
//    private GroupService groupService;

    @Autowired
    public TenantGroupServiceImpl(TenantGroupRepository tenantGroupRepository) {
        this.tenantGroupRepository = tenantGroupRepository;
//        this.groupService = groupService;
    }

//    @Override
//    public List<TenantGroup> getTenantGroupsByEmail(String email) {
//        return groupService.getTenantGroupsByEmail(email);
//    }

    @Override
    public TenantGroup saveGroup(TenantGroup tenantGroup) throws Exception {
        log.debug("Inside saveGroup()");
        TenantGroup savedGroup = new TenantGroup();
        tenantGroup.setGroupName("TGP"+ generateString());
        tenantGroup.setGroupCreatedOn(System.currentTimeMillis());
        savedGroup = tenantGroupRepository.save(tenantGroup);
        return savedGroup;
    }

    @Override
    public List<TenantGroup> getAllGroups() throws Exception {
        return (List<TenantGroup>) tenantGroupRepository.findAll();
    }

    @Override
    public TenantGroup updateGroup(GroupChat groupChat, String groupName) throws TenantGroupNotFoundException {
        log.debug("Inside updateGroup()");
        Optional<TenantGroup> groupExist = tenantGroupRepository.findById(groupName);
        if (!groupExist.isPresent())
        {
            log.error("Group is not found");
            throw new TenantGroupNotFoundException();
        }
//        List<GroupChat> groupChatList = new ArrayList<>();
        groupChat.setMessageSendOn(System.currentTimeMillis());
        groupExist.get().getMessageBody().add(groupChat);
        return tenantGroupRepository.save(groupExist.get());
    }

    @Override
    public TenantGroup getTenantGroupByName(String groupName) throws TenantGroupNotFoundException {
        TenantGroup tenantGroup = null;
        tenantGroup = tenantGroupRepository.findById(groupName).orElse(null);
        if (tenantGroup!=null)
        {
            return tenantGroup;
        }
        else {
            log.error("Group is not found");
            throw new TenantGroupNotFoundException();
        }
    }

    @Override
    public TenantGroup deleteGroup(String groupName) throws TenantGroupNotFoundException {
        log.debug("Inside deleteGroup()");
        TenantGroup tenantGroup = null;
        if (tenantGroupRepository.findById(groupName).isEmpty())
        {
            log.error("Group is not found");
            throw new TenantGroupNotFoundException();
        }
        else {
            tenantGroupRepository.deleteById(groupName);
        }
        return tenantGroup;
    }

//    public String groupName() {
//    int leftLimit = 48; // numeral '0'
//    int rightLimit = 122; // letter 'z'
//    int targetStringLength = 4;
//    Random random = new Random();
//
//    String generatedString = random.ints(leftLimit, rightLimit + 1)
//            .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
//            .limit(targetStringLength)
//            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
//            .toString();
//    return ("TENGRP" + generatedString);
//    }

    public String generateString() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(4);

        for (int i = 0; i < 4; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

}
