package fr.demo.tutorial.compteur.web;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

import javax.validation.constraints.NotBlank;

public class
CompteurController {

    @Get(uri = "/client/{name}", produces = MediaType.TEXT_PLAIN)
    public Single<String> hello(@NotBlank String name) {
        return Single.just("Hello " + name + "!");
    }
}
