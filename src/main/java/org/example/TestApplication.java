package org.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import io.jsonwebtoken.Jwts;
import org.example.controllers.*;
import org.example.daos.*;
import org.example.services.*;

import java.security.Key;


public class TestApplication extends Application<TestConfiguration> {
    public static void main(final String[] args) throws Exception {
        new TestApplication().run(args);
    }
    @Override
    public String getName() {
        return "Test";
    }
    @Override
    public void initialize(final Bootstrap<TestConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
                    final TestConfiguration configuration) {
                return configuration.getSwagger();
            }
        });
    }
    @Override
    public void run(final TestConfiguration configuration,
                    final Environment environment) {

        Key jwtKey = Jwts.SIG.HS256.key().build();

        environment.jersey()
                .register(
                        new EmployeeController(
                        new EmployeeService(new EmployeeDao())));

        environment.jersey()
                .register(new ProjectController(
                        new ProjectService(
                        new ProjectDao())));

        environment.jersey().register(
                new SalesEmpController(
                      new SalesEmpService(
                            new SalesEmpDao())));

        environment.jersey().register(
                new DeliveryEmpController(
                        new DeliveryEmpService(
                                new DeliveryEmpDao())));

        environment.jersey().register(
                new DeliveryEmpController(
                        new DeliveryEmpService(
                                new DeliveryEmpDao())));

        environment.jersey().register(
                new AuthController(
                        new AuthService(
                                new AuthDao(),
                                jwtKey
                        )
                )
        );
    }


}
