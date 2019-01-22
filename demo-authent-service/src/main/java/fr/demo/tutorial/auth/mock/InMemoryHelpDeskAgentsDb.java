package fr.demo.tutorial.auth.mock;

import fr.demo.tutorial.auth.domain.HelpDeskAgent;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class InMemoryHelpDeskAgentsDb implements HelpDeskAgents {

    private Map<String, HelpDeskAgent> db = new ConcurrentHashMap<>();

    public InMemoryHelpDeskAgentsDb() {
        add(new HelpDeskAgent("d.akram", "toujoursla", "static/avatars/jimmy_solid.png", Arrays.asList("TRI", "HSI", "FAI", "CAR")));
        add(new HelpDeskAgent("a.saka", "jesuisgentil", "static/avatars/danny_solid.png", Arrays.asList("TRI", "HSI")));
        add(new HelpDeskAgent("b.tahya", "admin", "static/avatars/admin.png", Arrays.asList("TRI", "HSI")));
        add(new HelpDeskAgent("f.jules", "presidentdelafifa", "static/avatars/agent1.png", Arrays.asList("TRI", "HSI")));
    }

    @Override
    public void add(HelpDeskAgent agent) {
        db.put(agent.getLogin(), agent);
    }

    @Override
    public Optional<HelpDeskAgent> findByLogin(String login) {
        HelpDeskAgent agent = db.get(login);
        return Optional.ofNullable(agent);
    }

}
