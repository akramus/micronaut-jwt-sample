package fr.demo.tutorial.client.web;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Arrays;
import java.util.Collection;

@Controller("/client")
public class CustomerController {


    @Get(uri = "/list", produces = MediaType.TEXT_PLAIN)
    public Collection<String> findAll() {
        return Arrays.asList("Akram,Saka,Tahya");
    }
}
