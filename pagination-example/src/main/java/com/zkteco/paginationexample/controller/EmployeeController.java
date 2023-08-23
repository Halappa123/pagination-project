package com.zkteco.paginationexample.controller;

import com.zkteco.paginationexample.model.Employee;
import com.zkteco.paginationexample.model.ResultEntity;
import com.zkteco.paginationexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save_all")
    public ResponseEntity<ResultEntity> saveAllEmployeeDetails(@RequestBody List<Employee> employee){
        return new ResponseEntity<ResultEntity>(employeeService.saveAllDetails(employee), HttpStatus.ACCEPTED);
    }

    @GetMapping("/get_all/{pageNo}/{pageSize}")
    public ResponseEntity<ResultEntity>  getAllEmployeeDetailsWithPagination(@PathVariable int pageNo,
                                                                             @PathVariable int  pageSize){
        return new ResponseEntity<ResultEntity>(employeeService.getAllEmployeeDetailsWithPagination(pageNo,pageSize),HttpStatus.ACCEPTED);
    }

    @GetMapping("/get_all/{pageNo}/{pageSize}/{field}")
    public ResponseEntity<ResultEntity>  getAllEmployeeDetailsWithPaginationAndSort(@PathVariable int pageNo,
                                                                             @PathVariable int  pageSize,
                                                                             @PathVariable String field){
        return new ResponseEntity<ResultEntity>(employeeService.getAllEmployeeDetailsWithPaginationAndSort(pageNo,pageSize,field),HttpStatus.ACCEPTED);
    }
    @GetMapping("/get_all/{id}")
    public ResponseEntity<ResultEntity> getAllDetailsById(@PathVariable Long id){
        return new ResponseEntity<ResultEntity>(employeeService.getById(id),HttpStatus.ACCEPTED);
    }
}
