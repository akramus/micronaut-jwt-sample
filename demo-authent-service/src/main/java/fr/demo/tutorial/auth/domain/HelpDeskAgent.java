package fr.demo.tutorial.auth.domain;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HelpDeskAgent {

    private String login;
    private String password;
    private String avatar;
    private List<String> availableProducts;

    public HelpDeskAgent(String login, String password, String avatar, List<String> availableProducts) {
        this.login = login;
        this.password = password;
        this.avatar = avatar;
        this.availableProducts = availableProducts;
    }

    public boolean passwordMatches(String passwordToTest) {
        return this.password.equals(passwordToTest);
    }
}
