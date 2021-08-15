package com.wr.vo;

import com.wr.bean.Pet;
import com.wr.bean.User;

import java.util.List;


public class UserInfo {
    private User user;
    private List<Pet> pets;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
