package com.zkteco.paginationexample.service;

import com.zkteco.paginationexample.model.Employee;
import com.zkteco.paginationexample.model.ResultEntity;

import java.util.List;

public interface EmployeeService {
    ResultEntity saveAllDetails(List<Employee> employee);

    ResultEntity getAllEmployeeDetailsWithPagination(int pageNo, int pageSize);

    ResultEntity getAllEmployeeDetailsWithPaginationAndSort(int pageNo, int pageSize, String field);

    ResultEntity getById(Long id);
}
