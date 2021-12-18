package com.stackroute.tenantprofileservice.model;

import lombok.*;

/**
 * @Author Siva
 * @Date 12/11/2021 11:25 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GroupChat {
    private String messageSendBy;
    private String message;
    private long messageSendOn;
}
