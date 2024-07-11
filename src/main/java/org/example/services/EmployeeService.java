package org.example.services;

import org.example.daos.EmployeeDao;
import org.example.exceptions.Entity;
import org.example.exceptions.FailedToCreateException;
import org.example.models.EmployeeRequest;

import java.sql.SQLException;

public class EmployeeService {
    EmployeeDao employeeDao;

    public EmployeeService(final EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public int createEmployee(final EmployeeRequest employeeRequest)
            throws FailedToCreateException, SQLException {
        int id = employeeDao.createEmployee(employeeRequest);

        if (id == -1) {
            throw new FailedToCreateException(Entity.EMPLOYEE);
        }
        return id;
    }
}
