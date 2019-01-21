package fr.demo.tutorial.auth.domain;


import io.micronaut.security.authentication.UserDetails;
import lombok.Getter;

import java.util.Collection;

@Getter
public class HelpDeskAgentDetails extends UserDetails {

    private String avatarUrl;

    public HelpDeskAgentDetails(String username, String avatarUrl, Collection<String> roles) {
        super(username, roles);
        this.avatarUrl = avatarUrl;
    }

}
