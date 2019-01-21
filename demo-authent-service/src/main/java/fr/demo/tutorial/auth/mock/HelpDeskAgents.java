package fr.demo.tutorial.auth.mock;

import fr.demo.tutorial.auth.domain.HelpDeskAgent;

import java.util.Optional;

public interface HelpDeskAgents {

    void add(HelpDeskAgent agent);

    Optional<HelpDeskAgent> findByLogin(String login);
}
