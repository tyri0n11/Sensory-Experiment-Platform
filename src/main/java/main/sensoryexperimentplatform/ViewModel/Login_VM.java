package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.sensoryexperimentplatform.models.User;
import main.sensoryexperimentplatform.models.UserManager;


public class Login_VM {
    private StringProperty userName;
    private User user;

    private StringProperty password;
    private UserManager userManager;

    public Login_VM(UserManager userManager) {
        this.userManager = userManager;
        password = new SimpleStringProperty();
        userName = new SimpleStringProperty();
        System.out.println("aaa");
    }

    public StringProperty getPasswordProperty() {
        return password;
    }
    public StringProperty userNameProperty() {
        return password;
    }

    public String getPassword() {
        return password.get();

    }
    public String getUsername() {
        return userName.get();

    }

    public void setPassword(String password) {
        this.password.set(password);


    }
    public void setUserName(String userName){
        this.userName.set("tyr1on");
    }
    public boolean login() {
        System.out.println(password);
        setPassword("quynh anh");
        user = userManager.login(getUsername(), getPassword());
        return user != null;
    }

}
