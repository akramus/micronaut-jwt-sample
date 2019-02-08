package fr.demo.tutorial.gateway.client.v1;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;

import java.util.List;

@Client(id = "customer-service", path = "/client")
@Retryable(attempts = "2", delay = "2s")
public interface CustomerGateway {


    @Get("/list")
    List<String>  findAll();

}
