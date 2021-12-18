package com.stackroute.tenantprofileservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @Author Siva
 * @Date 11/18/2021 2:18 PM
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Component
@Document
public class TenantProfile  {
    @Id
    @Email
    private String email;

//    @NotNull
//    @Size(min = 4, max = 20)
    private String fullName;

//    @NotNull
//    @Min(value = 18)
    private int age;

  //  @NotNull
    private String city;

 //   @NotNull
    private String contactNumber;

  //  @NotNull
    private Gender gender;

  //  @NotNull
    private String state;

  //  @NotNull
    private List<String> hobbies;

  //  @NotNull
    private String ambition;

   // @NotNull
    private String passion;

  //  @NotNull
    private Questionaire questionaire;

  //  @NotNull
    private School school;

   // @NotNull
    private College college;

   // @NotNull
    private Career career;

    private byte[] image;

}
