package com.stackroute.tenantmatchmakingservice.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class College {
    private String collegeName;
    private String degree;
    private boolean passedOut;
}
