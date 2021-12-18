package com.stackroute.tenantmatchmakingservice.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * @Author Rohit
 * @Date 09-Dec-21 9:29 AM
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Node
public class MaritalStatus {

    @Id
    private String name;
}
