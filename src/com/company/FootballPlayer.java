package com.company;

public class FootballPlayer {
    private String firstName;
    private String lastName;
    private int age;
    private boolean team;
    private int id;

    public FootballPlayer(String firstName, String lastName, int age, boolean team, int id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.team = team;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%10s %15s %2d %4d",getFirstName(), getLastName(), getAge(), getId());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isTeam() {
        return team;
    }

    public void setTeam(boolean team) {
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
