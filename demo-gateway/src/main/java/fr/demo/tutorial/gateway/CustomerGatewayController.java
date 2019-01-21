package fr.demo.tutorial.gateway;

import fr.demo.tutorial.gateway.client.v1.CustomerGateway;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import javax.inject.Inject;
import java.util.Collection;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/client")
public class CustomerGatewayController {
    @Inject
    private CustomerGateway customerGateway;

    @Get("/list")
    Collection<String> findAll() {
        return customerGateway.findAll();
    }


}
