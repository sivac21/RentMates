package com.stackroute.tenantmatchmakingservice.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString

public class TenantProfile {
    @Id
    private String email;
    private String fullName;
    private int age;
    private String city;
    private String contactNumber;
    private Gender gender;
    private String state;
    private List<String> hobbies;
    private String ambition;
    private String passion;
    private Questionaire questionaire;
    private School school;
    private College college;
    private Career career;
    private byte[] image;
}
