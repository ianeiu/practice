package com.wm.demo.patterns.build.prototype.simple;

public class Student extends People implements PrototypeCloneable {

    public Student(String _name) {
        super(_name);
    }

    private Friends friends = null;
    
    public Friends getFriends() {
        return friends;
    }

    public void setFriends(Friends friends) {
        this.friends = friends;
    }
    
    public void addFriend(People people) {
        if (friends == null) {
            friends = new Friends();
        }
        friends.addFriend(people);
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.friends = (Friends) this.friends.clone();
        return student;
    }
    
}