package com.stackroute.tenantmatchmakingservice.model;

import lombok.*;

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
