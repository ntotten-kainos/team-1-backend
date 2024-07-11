package org.example.services;

import org.example.daos.SalesEmpDao;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.Entity;
import org.example.exceptions.FailedToCreateException;
import org.example.models.SalesEmpRequest;
import org.example.models.SalesEmployee;

import java.sql.SQLException;

public class SalesEmpService {
    private final SalesEmpDao salesEmpDao;

    public SalesEmpService(final SalesEmpDao dao) {
        this.salesEmpDao = dao;
    }

    public int createSalesEmployee(final SalesEmpRequest salesEmpRequest)
            throws SQLException, FailedToCreateException {
        int id = salesEmpDao.createSalesEmployee(salesEmpRequest);
        System.err.println(id);
        if (id == -1) {
            throw new FailedToCreateException(Entity.SALES_EMPLOYEE);
        }
        return id;
    }

    public SalesEmployee getSalesEmployeeById (int id) throws SQLException,
            DoesNotExistException {

        SalesEmployee salesEmployee = salesEmpDao.getSalesEmployeeById(id);

        if(salesEmployee == null) {
            throw new DoesNotExistException(Entity.SALES_EMPLOYEE);
        }

        return salesEmployee;
    }

}
