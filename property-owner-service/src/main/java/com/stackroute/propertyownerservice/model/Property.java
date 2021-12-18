package com.stackroute.propertyownerservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;

/**
 * @Author Rohit
 * @Date 11/18/2021 2:26 PM
 */
@Document(indexName = "ownerprofile")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Property {

    @Id
    @NotNull
    private String propertyName;
    @NotNull
    private long ownerContactNumber;
    @NotNull
    private String roomType;
    @NotNull
    @Positive
    private int expectedRent;
    @NotNull
    @Positive
    private int advancedDeposit;
    @NotNull
    private RoomAmenities roomAmenities;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @NotNull
    private String locality;
    @NotNull
    private List<String> nearByPlace;
    @NotNull
    private PlaceAvailableFor placeAvailableFor;
    @NotNull
    private PreferredTenant preferredTenant;
    @NotNull
    private boolean foodAvailability;
    @NotNull
    private long availableFrom;
    @NotNull
    private Rules rules;
    @NotNull
    private boolean laundry;
    @NotNull
    private boolean roomCleaningService;
    @NotNull
    private Parking parking;
    @NotNull
    private AvailableAmenities availableAmenities;
    private String ownedBy;
    private byte[] image;
}
