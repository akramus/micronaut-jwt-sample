package fr.demo.tutorial.auth.security;

import fr.demo.tutorial.auth.domain.HelpDeskAgent;
import fr.demo.tutorial.auth.domain.HelpDeskAgentDetails;
import fr.demo.tutorial.auth.mock.HelpDeskAgents;
import io.micronaut.security.authentication.AuthenticationFailed;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.reactivex.Flowable;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;
import java.util.Optional;

@Singleton
@RequiredArgsConstructor
public class AuthProvider implements AuthenticationProvider {

    private final HelpDeskAgents helpDeskAgents;

    @Override
    public Publisher<AuthenticationResponse> authenticate(AuthenticationRequest request) {
        Optional<HelpDeskAgent> agent = helpDeskAgents.findByLogin((String) request.getIdentity());

        if (agent.isPresent() && agent.get().passwordMatches((String) request.getSecret())) {
            return Flowable.just(createUserDetails(agent.get()));
        }

        return Flowable.just(new AuthenticationFailed());
    }

    private HelpDeskAgentDetails createUserDetails(HelpDeskAgent agent) {
        return new HelpDeskAgentDetails(agent.getLogin(), agent.getAvatar(), agent.getAvailableProducts());
    }
}
