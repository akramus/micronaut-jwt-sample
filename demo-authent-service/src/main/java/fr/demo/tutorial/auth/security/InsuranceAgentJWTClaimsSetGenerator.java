package fr.demo.tutorial.auth.security;

import com.nimbusds.jwt.JWTClaimsSet;
import fr.demo.tutorial.auth.domain.HelpDeskAgentDetails;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.runtime.ApplicationConfiguration;
import io.micronaut.security.authentication.UserDetails;
import io.micronaut.security.token.config.TokenConfiguration;
import io.micronaut.security.token.jwt.generator.claims.ClaimsAudienceProvider;
import io.micronaut.security.token.jwt.generator.claims.JWTClaimsSetGenerator;
import io.micronaut.security.token.jwt.generator.claims.JwtIdGenerator;

import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
@Replaces(bean = JWTClaimsSetGenerator.class)
public class InsuranceAgentJWTClaimsSetGenerator extends JWTClaimsSetGenerator {

    public InsuranceAgentJWTClaimsSetGenerator(TokenConfiguration tokenConfiguration,
                                               @Nullable JwtIdGenerator jwtIdGenerator,
                                               @Nullable ClaimsAudienceProvider claimsAudienceProvider,
                                               @Nullable ApplicationConfiguration applicationConfiguration) {
        super(tokenConfiguration, jwtIdGenerator, claimsAudienceProvider, applicationConfiguration);
    }

    @Override
    protected void populateWithUserDetails(JWTClaimsSet.Builder builder, UserDetails userDetails) {
        super.populateWithUserDetails(builder, userDetails);
        if (userDetails instanceof HelpDeskAgentDetails) {
            builder.claim("avatar", ((HelpDeskAgentDetails) userDetails).getAvatarUrl());
        }
    }
}
