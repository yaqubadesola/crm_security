package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Staff;

import java.util.List;

public interface StaffService {

    List<Staff> findAll();

    Staff findById(int theId);

    Staff save(Staff theStaff);

    void deleteById(int theId);

}
