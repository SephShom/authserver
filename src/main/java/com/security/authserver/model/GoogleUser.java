package com.security.authserver.model;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.oauth2.core.user.OAuth2User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class GoogleUser {
  
  @Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "user_id")
	private UUID id;

  private String email;
  private String name;
  private String givenName;
  private String familyName;
  private String pictureUrl;

  public static GoogleUser fromOauth2User(OAuth2User user){
    GoogleUser googleUser = new GoogleUser();
    googleUser.setEmail(user.getName());
    googleUser.setName(user.getAttributes().get("name").toString());
    googleUser.setGivenName(user.getAttributes().get("given_name").toString());
    googleUser.setFamilyName(user.getAttributes().get("family_name").toString());
    googleUser.setPictureUrl(user.getAttributes().get("picture").toString());              
    return googleUser;
  }

  @Override
  public String toString() {
      return "GoogleUser{" +
              "id=" + id +
              ", email='" + email + '\'' +
              ", name='" + name + '\'' +
              ", givenName='" + givenName + '\'' +
              ", familyName='" + familyName + '\'' +
              ", pictureUrl='" + pictureUrl + '\'' +
              '}';
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public String getPictureUrl() {
    return pictureUrl;
  }

  public void setPictureUrl(String pictureUrl) {
    this.pictureUrl = pictureUrl;
  }
}
