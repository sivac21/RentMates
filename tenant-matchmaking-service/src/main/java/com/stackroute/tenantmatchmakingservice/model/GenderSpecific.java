package com.stackroute.tenantmatchmakingservice.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * @Author Rohit
 * @Date 08-Dec-21 4:07 PM
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Node
public class GenderSpecific {
    @Id
    private String name;

}
