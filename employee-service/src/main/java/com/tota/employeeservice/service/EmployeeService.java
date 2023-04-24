package com.tota.employeeservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.tota.employeeservice.entity.Employee;
import com.tota.employeeservice.repo.EmployeeRepo;
import com.tota.employeeservice.response.AddressResponse;
import com.tota.employeeservice.response.EmployeeResponse;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    // @Autowired
    // private RestTemplate restTemplate; // dont use bloclikn client deppreciated

    @Autowired
    private WebClient webClient;

    public EmployeeResponse getEmployeeById(int id) {
        Employee employee = employeeRepo.findById(id).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        AddressResponse addressResponse = webClient
                .get()
                .uri("/address/" + id)
                .retrieve()
                .bodyToMono(AddressResponse.class)
                .block();

        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }
}
