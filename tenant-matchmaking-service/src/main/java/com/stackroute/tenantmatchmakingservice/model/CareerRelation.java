package com.stackroute.tenantmatchmakingservice.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;

/**
 * @Author Rohit
 * @Date 13-Dec-21 3:39 PM
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CareerRelation {
    @Id
    private String occupation;

}
