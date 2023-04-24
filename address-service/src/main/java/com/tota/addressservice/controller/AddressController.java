package com.tota.addressservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tota.addressservice.response.AddressResponse;
import com.tota.addressservice.service.AddressService;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address/{employee_Id}")
    ResponseEntity<AddressResponse> getAddressByEmployee(@PathVariable("employee_Id") int employee_Id) {
        AddressResponse addressResponse = addressService.getAddressByEmployee(employee_Id);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }

}
