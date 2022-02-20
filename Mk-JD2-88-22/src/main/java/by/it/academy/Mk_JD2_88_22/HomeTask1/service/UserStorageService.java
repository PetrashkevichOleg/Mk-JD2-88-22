package by.it.academy.Mk_JD2_88_22.HomeTask1.service;

//import RegistrationForm.service.api.IUserService;
//import RegistrationForm.dto.User;

import by.it.academy.Mk_JD2_88_22.HomeTask1.service.api.dto.User;
import by.it.academy.Mk_JD2_88_22.HomeTask1.service.api.IUserService;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UserStorageService implements IUserService {


    private  final Map<String, User> userStorage;
    private static final UserStorageService instanceUser= new UserStorageService();

    private UserStorageService() {
        this.userStorage=new HashMap<>();
    }
    @Override
    public void addUser(User newUser) {
    userStorage.put(newUser.getLogin(), newUser);
    }

    @Override
    public User getUser(String login) {
        return userStorage.getOrDefault(login,null);
    }

    @Override
    public Map<String, User> getUserStorage() {
        return  Collections.unmodifiableMap(userStorage);
    }

    public static UserStorageService getInstanceUser(){
        return instanceUser;
    }


}
