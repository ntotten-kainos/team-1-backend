package org.example.services;

import org.example.daos.EmployeeDao;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService
{
    EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao)
    {
        this.employeeDao = employeeDao;
    }

    public int createEmployee(EmployeeResquest employeeResquest) throws FailedToCreateException, SQLException
    {
        int id = employeeDao..createProduct(productRequest);

        if(id == -1)
        {
            throw new FailedToCreateException(Entity.PRODUCT);
        }
        return id;
    }
}
