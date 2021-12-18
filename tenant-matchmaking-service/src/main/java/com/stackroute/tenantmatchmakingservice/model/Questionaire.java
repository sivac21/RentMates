package com.stackroute.tenantmatchmakingservice.model;

import lombok.*;

import java.util.List;

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
