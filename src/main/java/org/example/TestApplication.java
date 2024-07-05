package org.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.example.controllers.EmployeeController;
import org.example.daos.EmployeeDao;
import org.example.services.EmployeeService;
import org.example.controllers.DeliveryEmpController;
import org.example.daos.DeliveryEmpDao;
import org.example.services.DeliveryEmpService;
import org.example.controllers.ProjectController;
import org.example.controllers.TestController;
import org.example.daos.ProjectDao;
import org.example.daos.TestDao;
import org.example.services.ProjectService;
import org.example.controllers.SalesEmpController;
import org.example.daos.SalesEmpDao;
import org.example.services.SalesEmpService;
import org.example.services.TestService;

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
        environment.jersey()
                .register(
                        new EmployeeController(
                        new EmployeeService(new EmployeeDao())));

        environment.jersey()
                .register(new ProjectController(
                        new ProjectService(
                        new ProjectDao())));

        environment.jersey().register(

                new SalesEmpController(new SalesEmpService(new SalesEmpDao())));

        environment.jersey().register(
                new DeliveryEmpController(
                        new DeliveryEmpService(
                                new DeliveryEmpDao())));
    }

}
