package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.daos.DatabaseConnector;
import org.example.exceptions.FailedToCreateException;
import org.example.models.DeliveryEmpRequest;
import org.example.models.SalesEmployee;
import org.example.services.DeliveryEmpService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Api("Engineering Academy - Group Challenge 2 - Team 3 - Delivery Employee API")
@Path("/api/delivery-employee")
public class DeliveryEmpController {
    DeliveryEmpService deliveryEmpService;

    public DeliveryEmpController(
            final DeliveryEmpService deliveryEmpService) {
        this.deliveryEmpService = deliveryEmpService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDeliveryEmployee(
            final DeliveryEmpRequest deliveryEmpRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(deliveryEmpService
                            .createDeliveryEmployee(deliveryEmpRequest))
                    .build();
        } catch (FailedToCreateException | SQLException e) {
            System.out.println(e);
            return Response.serverError().build();
        }
    }




}
