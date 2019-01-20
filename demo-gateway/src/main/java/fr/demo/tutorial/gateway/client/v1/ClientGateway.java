package fr.demo.tutorial.gateway.client.v1;

import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;

@Client(id = "client-service", path = "/client")
@Retryable(attempts = "2", delay = "2s")
public interface ClientGateway {
}
