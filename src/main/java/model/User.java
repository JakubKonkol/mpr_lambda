package model;

public class User {
    public User(String name, String password, Person personDetails) {
        this.name = name;
        this.password = password;
        this.personDetails = personDetails;
    }

    public User() {

    }

    private String name;
    private String password;
    private Person personDetails;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Person getPersonDetails() {
        return personDetails;
    }
}