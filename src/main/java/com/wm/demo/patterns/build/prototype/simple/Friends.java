package com.wm.demo.patterns.build.prototype.simple;

import java.util.ArrayList;
import java.util.List;

public class Friends implements PrototypeCloneable {

    private List<People> friends = null;
    
    public List<People> getFriends() {
        return friends;
    }
    
    public void setFriends(List<People> friends) {
        this.friends = friends;
    }
    
    public void addFriend(People people) {
        if (this.friends == null) {
            friends = new ArrayList<>();
        }
        this.friends.add(people);
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    @Override
    public String toString() {
        return friends.toString();
    }
}