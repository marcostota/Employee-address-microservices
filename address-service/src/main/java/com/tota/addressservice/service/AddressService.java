package com.tota.addressservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tota.addressservice.entity.Address;
import com.tota.addressservice.repository.AddressRepo;
import com.tota.addressservice.response.AddressResponse;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;

    public AddressResponse getAddressByEmployee(int employee_id) {

        Address address = addressRepo.findAddresByEmployeeId(employee_id);

        AddressResponse addressResponse = modelMapper.map(address, AddressResponse.class);
        return addressResponse;
    }
}
