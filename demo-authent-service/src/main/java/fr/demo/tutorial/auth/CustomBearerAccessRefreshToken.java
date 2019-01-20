package fr.demo.tutorial.auth;

import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

@NoArgsConstructor
class CustomBearerAccessRefreshToken extends BearerAccessRefreshToken {

    @Getter
    private String avatar;

    CustomBearerAccessRefreshToken(String username,
                                   Collection<String> roles,
                                   Integer expiresIn,
                                   String accessToken,
                                   String refreshToken,
                                   String avatar) {
        super(username, roles, expiresIn, accessToken, refreshToken);
        this.avatar = avatar;

    }
}
