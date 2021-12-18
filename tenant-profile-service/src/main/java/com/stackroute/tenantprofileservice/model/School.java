package com.stackroute.tenantprofileservice.model;

import lombok.*;

/**
 * @Author Siva
 * @Date 11/19/2021 10:43 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class School {
    private String schoolName;
    private String grade;
    private boolean passedOut;
}
