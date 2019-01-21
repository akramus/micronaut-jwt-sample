package fr.demo.tutorial.auth.security;

import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

@NoArgsConstructor
public class CustomBearerAccessRefreshToken extends BearerAccessRefreshToken {

    @Getter
    private String avatar;

    public CustomBearerAccessRefreshToken(String username,
                                   Collection<String> roles,
                                   Integer expiresIn,
                                   String accessToken,
                                   String refreshToken,
                                   String avatar) {
        super(username, roles, expiresIn, accessToken, refreshToken);
        this.avatar = avatar;

    }
}
