package com.stackroute.tenantprofileservice.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Siva
 * @Date 12/11/2021 11:20 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document
public class TenantGroup {
    @Id
    private String groupName;
    private String tenantMember1;
    private String tenantMember2;
    private long groupCreatedOn;
    private String groupCreatedBy;
    private List<GroupChat> messageBody = new ArrayList<>();
}
