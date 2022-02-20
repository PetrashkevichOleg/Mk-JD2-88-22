package by.it.academy.Mk_JD2_88_22.HomeTask1.service.api.dto;

public class User {
  String login;
  String password;
  String firstName;
  String LastName;



  public   User(String userName, String password, String firstName, String lastName) {
    this.login = userName;
    this.password = password;
    this.firstName = firstName;
    this.LastName = lastName;

  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }



  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return LastName;
  }

  public void setLastName(String lastName) {
    LastName = lastName;
  }

  @Override
  public String toString() {
    return "User{" +
        "userName='" + login + '\'' +
        ", password='" + password + '\'' +
        ", firstName='" + firstName + '\'' +
        ", LastName='" + LastName + '\'' +
        '}';
  }
}
