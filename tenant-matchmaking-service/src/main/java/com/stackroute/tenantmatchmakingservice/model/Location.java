package com.stackroute.tenantmatchmakingservice.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * @Author Rohit
 * @Date 08-Dec-21 3:21 PM
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Node
public class Location {
    @Id
    private String state;

}
