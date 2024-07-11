package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Staff;
import com.luv2code.springboot.cruddemo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StaffRestController {

    private StaffService staffService;

    @Autowired
    public StaffRestController(StaffService theStaffService) {
        staffService = theStaffService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Staff> findAll() {
        return staffService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Staff getStaff(@PathVariable int employeeId) {

        Staff theStaff = staffService.findById(employeeId);

        if (theStaff == null) {
            throw new RuntimeException("Staff id not found - " + employeeId);
        }

        return theStaff;
    }

    // add mapping for POST /employees - add new employee

    @PostMapping("/employees")
    public Staff addStaff(@RequestBody Staff theStaff) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theStaff.setId(0);

        Staff dbStaff = staffService.save(theStaff);

        return dbStaff;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/employees")
    public Staff updateStaff(@RequestBody Staff theStaff) {

        Staff dbStaff = staffService.save(theStaff);

        return dbStaff;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteStaff(@PathVariable int employeeId) {

        Staff tempStaff = staffService.findById(employeeId);

        // throw exception if null

        if (tempStaff == null) {
            throw new RuntimeException("Staff id not found - " + employeeId);
        }

        staffService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }

}














