package com.zkteco.paginationexample.serviceimpl;

import com.zkteco.paginationexample.model.Employee;
import com.zkteco.paginationexample.model.ResultEntity;
import com.zkteco.paginationexample.repository.EmployeeRepository;
import com.zkteco.paginationexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ResultEntity saveAllDetails(List<Employee> employee) {
       List<Employee> employees=employeeRepository.saveAll(employee);
        return new ResultEntity("All Data Saved Successfully",employees);
    }

    @Override
    public ResultEntity getAllEmployeeDetailsWithPagination(int pageNo, int pageSize) {
        Page<Employee> employees1=employeeRepository.findAll(PageRequest.of(pageNo,pageSize));
        return new ResultEntity("data fetched based on page size",employees1);
    }

    @Override
    public ResultEntity getAllEmployeeDetailsWithPaginationAndSort(int pageNo, int pageSize, String field) {
        Page<Employee> employees2=employeeRepository.findAll(PageRequest.of(pageNo,pageSize).withSort(Sort.by(field)));
        return new ResultEntity("data fetched based on page number and page size with sortening is successful",employees2);
    }

    @Override
    public ResultEntity getById(Long id) {
        Optional<Employee> emp=employeeRepository.findById(id);
        return new ResultEntity("All data fetched based on id",emp);
    }

    @Override
    public ResultEntity deleteAllDetailsById(Long id) {
        Employee employee=employeeRepository.findById(id).get();
        if (employee!=null){
            employeeRepository.delete(employee);
            return new ResultEntity("All data deleted besed on id successfull",employee);
        }
        return new ResultEntity("Invalid id ",employee);
    }


}
