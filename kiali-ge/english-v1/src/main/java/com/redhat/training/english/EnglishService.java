package com.redhat.training.english;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/")
@ApplicationScoped
public class EnglishService {

    @Inject
    @RestClient
    SpanishService spanishService;

    String message = "Hello World!";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        
        return message;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/chained")
    public String chainedGreeting() {
        
        return message + " -> " + spanishService.chainedGreeting();
    }
}