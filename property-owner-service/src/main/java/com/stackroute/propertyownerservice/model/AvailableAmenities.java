package com.stackroute.propertyownerservice.model;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AvailableAmenities {
    private boolean commonTv;
    private boolean powerBackup;
    private boolean wifi;
    private boolean gym;
    private boolean refrigerator;
    private boolean lift;

}
