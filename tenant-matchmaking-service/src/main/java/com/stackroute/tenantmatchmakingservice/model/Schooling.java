package com.stackroute.tenantmatchmakingservice.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;

/**
 * @Author Rohit
 * @Date 09-Dec-21 3:47 PM
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Schooling {
    @Id
    private String grade;

}
