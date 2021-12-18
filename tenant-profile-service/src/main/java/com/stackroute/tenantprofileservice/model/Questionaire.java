package com.stackroute.tenantprofileservice.model;

import lombok.*;

import java.util.List;

/**
 * @Author Siva
 * @Date 11/19/2021 10:39 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Questionaire {
    private List<String> language;
    private String foodType;
    private String drinkingSmoking;
    private String maritalStatus;
}
