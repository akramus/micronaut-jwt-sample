package fr.demo.tutorial.auth;

import java.util.Optional;

public interface InsuranceAgents {

    void add(InsuranceAgent agent);

    Optional<InsuranceAgent> findByLogin(String login);
}
