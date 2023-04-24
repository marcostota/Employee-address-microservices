package com.tota.addressservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tota.addressservice.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

    @Query(nativeQuery = true, value = "SELECT a.id, a.lane1, a.lane2, a.state, a.zip FROM microservices.address a join microservices.employee e on e.id = a.employee_id where a.employee_id =:employeeId")
    Address findAddresByEmployeeId(@Param("employeeId") int employeeId);
}
