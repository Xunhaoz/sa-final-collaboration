package com.example.front.app;

import com.example.front.app.Helper;
import org.json.JSONObject;

public class User {
    private int id;
    private String firstName, lastName, email, password, salt;
    private Boolean identity;

    private Helper helper = Helper.getHelper();

    public User(int id) {
        this.id = id;
        this.copy(helper.selectUserById(this.id));
    }

    public User(String firstName, String lastName, String email, String password, Boolean identity, String salt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.identity = identity;
        this.salt = salt;
        helper.createUser(this);
    }

    public User(int id, String firstName, String lastName, String email, String password, Boolean identity, String salt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.identity = identity;
        this.salt = salt;
    }

    public User(int id, String firstName, String lastName, String email, String password, Boolean identity) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.identity = identity;
        helper.updateUser(this);
    }

    public User(int id, String firstName, String lastName, String email, Boolean identity) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.identity = identity;
        helper.updateUserWithoutPassword(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIdentity() {
        return identity;
    }

    public void setIdentity(Boolean identity) {
        this.identity = identity;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public JSONObject getObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", getId());
        jsonObject.put("email", getEmail());
        jsonObject.put("firstName", getFirstName());
        jsonObject.put("lastName", getLastName());
        jsonObject.put("password", getPassword());
        jsonObject.put("identity", getIdentity());
        return jsonObject;
    }

    private void copy(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.salt = user.getSalt();
        this.identity = user.getIdentity();
    }

    @Override
    public String toString() {
        return "User{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", password='" + password + '\'' + ", salt='" + salt + '\'' + ", identity=" + identity + '}';
    }
}
