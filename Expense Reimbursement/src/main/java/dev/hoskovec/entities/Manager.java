package dev.hoskovec.entities;

import javax.persistence.*;

@Entity
@Table(name = "manager")
public class Manager {

    //manager fields
    @Column(name = "manager_name")
    private String name;

    @Column(name = "username")
    private String userName;

    @Column(name = "manager_password")
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private int managerId;

    //constructors
    public Manager() {
    }

    public Manager(String name, String userName, String password, int managerId) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.managerId = managerId;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    //manager toString

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", employeeId=" + managerId +
                '}';
    }
}
