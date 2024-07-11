package org.example.services;


import org.example.daos.DeliveryEmpDao;
import org.example.exceptions.Entity;
import org.example.exceptions.FailedToCreateException;
import org.example.models.DeliveryEmpRequest;
import org.example.models.DeliveryEmployee;

import java.sql.SQLException;
import java.util.List;

public class DeliveryEmpService {
    DeliveryEmpDao deliveryEmpDao;

    public DeliveryEmpService(final DeliveryEmpDao deliveryEmpDao) {
        this.deliveryEmpDao = deliveryEmpDao;
    }

    public int createDeliveryEmployee(
            final DeliveryEmpRequest deliveryEmpRequest)
            throws SQLException, FailedToCreateException {
        int id = deliveryEmpDao.createDeliveryEmployee(deliveryEmpRequest);
        if (id == -1) {
            throw new FailedToCreateException(Entity.DELIVERY_EMPLOYEE);
        }
        return id;
    }

    public List<DeliveryEmployee> getAllDeliveryEmployees() throws SQLException {
        return deliveryEmpDao.getAllDeliveryEmployees();
    }

}
