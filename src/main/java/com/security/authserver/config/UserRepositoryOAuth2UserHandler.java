package com.security.authserver.config;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.security.authserver.dao.GoogleUserDao;
import com.security.authserver.model.GoogleUser;

public final class UserRepositoryOAuth2UserHandler implements Consumer<OAuth2User> {

    private final GoogleUserDao googleUserDao;

    @Autowired
    public UserRepositoryOAuth2UserHandler(GoogleUserDao googleUserDao) {
      this.googleUserDao = googleUserDao;
    }

    @Override
    public void accept(OAuth2User user) {
        // Capture user in a local data store on first authentication
        
        if (!googleUserDao.findByEmail(user.getName()).isPresent()) {            
            GoogleUser googleUser = GoogleUser.fromOauth2User(user);
            System.out.println("Saving first-time user: " + googleUser.toString());
            googleUserDao.save(googleUser);
        }
    }

}
