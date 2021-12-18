package com.stackroute.tenantmatchmakingservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * @Author Rohit
 * @Date 08-Dec-21 3:28 PM
 */


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Node
public class Tenant {
    @Id
    private String email;
    private String fullName;
    private String contactNumber;
}
