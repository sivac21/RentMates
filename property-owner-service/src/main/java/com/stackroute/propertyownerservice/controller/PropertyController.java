package com.stackroute.propertyownerservice.controller;
import com.google.gson.Gson;
import com.stackroute.propertyownerservice.exception.PropertyAlreadyExistsException;
import com.stackroute.propertyownerservice.exception.PropertyNotFoundException;
import com.stackroute.propertyownerservice.model.Property;
import com.stackroute.propertyownerservice.service.PropertyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @Author Rohit
 * @Date 11/18/2021 2:26 P
 */
@Slf4j
@RestController
//@CrossOrigin( origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class PropertyController {

    private PropertyService propertyService;
    private ResponseEntity responseEntity;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }


    @PostMapping("/property")
    public ResponseEntity<Property> registerProperty (@Valid @RequestParam("property")String property ,@RequestParam("file") MultipartFile multipartFile) throws PropertyAlreadyExistsException  {
        Gson gson = new Gson();
        Property propertyFileObj = gson.fromJson(property, Property.class);
        try {
            Property registeredProperty = propertyService.registerProperty(propertyFileObj,multipartFile);
            responseEntity = new ResponseEntity<>(registeredProperty, HttpStatus.OK);
        } catch (PropertyAlreadyExistsException | IOException e) {
            log.error("Error" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            log.error("Exception " + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity<?> getAllProperties () throws Exception {
        try {
            responseEntity = new ResponseEntity<>(propertyService.getAllProperties(), HttpStatus.OK);
        }catch(Exception e){
            log.error("Exception " + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }


    @PutMapping("/property/{propertyName}")
    public ResponseEntity<?> updateProperty (@RequestBody Property property , @PathVariable String propertyName ) throws PropertyNotFoundException {
        try {
            propertyService.updateProperty(property, propertyName);
            responseEntity = new ResponseEntity<>(property, HttpStatus.OK);
        } catch (PropertyNotFoundException e) {
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }catch(Exception e){
            log.error("Exception " + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

        @DeleteMapping("/property/{propertyName}")
        public ResponseEntity<?> deleteProperty (@PathVariable("propertyName") String propertyName) throws PropertyNotFoundException {
            try {
                propertyService.deleteProperty(propertyName);
            } catch (PropertyNotFoundException e) {
                log.error("Exception occur" + e.getMessage());
                responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
            } catch (Exception e) {
                log.error("Exception occur" + e.getMessage());
                responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return responseEntity;
        }

    @GetMapping("/properties/{propertyName}")
    public ResponseEntity<?> getPropertyByPropertyName (@PathVariable("propertyName") String propertyName) throws PropertyNotFoundException {
        try {
            responseEntity = new ResponseEntity<>(propertyService.getPropertyByPropertyName(propertyName), HttpStatus.OK);
        } catch (PropertyNotFoundException e) {
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }catch (Exception e){
            log.error("Exception occur" + e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


    @GetMapping("/search/{text}")
    public List<?> doMultiMatchQuery(@PathVariable String text){
        //return propertyService.multiMatchQuery(text);
        return propertyService.searchProperty(text);
    }
}
