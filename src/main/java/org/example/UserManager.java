package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class UserManager {
    public ArrayList<User> users = new ArrayList<User>();

    public String getNameOldestUser() {
        return users.stream().findFirst().get().name;
    }
}
