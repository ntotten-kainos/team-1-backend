package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.FailedToCreateException;
import org.example.models.EmployeeRequest;
import org.example.services.EmployeeService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Engineering Academy - Group Challenge 2 - Team 3 - Sales Employee API")
@Path("/api/employee")
public class EmployeeController {
     EmployeeService employeeService;

    public EmployeeController(
            final EmployeeService employeeService) {
            this.employeeService = employeeService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmployee(final EmployeeRequest employeeRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(employeeService.createEmployee(employeeRequest))
                    .build();
        } catch (SQLException | FailedToCreateException e) {
            return Response.serverError().build();
        }
    }

}
