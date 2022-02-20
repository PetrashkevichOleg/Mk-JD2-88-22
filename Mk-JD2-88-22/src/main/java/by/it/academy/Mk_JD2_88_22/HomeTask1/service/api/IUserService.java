package by.it.academy.Mk_JD2_88_22.HomeTask1.service.api;

//import RegistrationForm.dto.User;

import by.it.academy.Mk_JD2_88_22.HomeTask1.service.api.dto.User;
import java.util.Map;

public interface IUserService {
    void addUser(User user);

    User getUser(String login);
    Map<String,User> getUserStorage();
}
