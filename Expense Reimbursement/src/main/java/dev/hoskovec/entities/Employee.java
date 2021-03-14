package dev.hoskovec.entities;

import javax.persistence.*;

@Entity
@Table(name= "employee")
public class Employee {

    //employee fields
    @Column(name= "employee_name")
    private String name;

    @Column(name = "username")
    private String userName;

    @Column(name = "user_password")
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "employee_id")
    private int employeeId;

    //constructors

    public Employee() {
    }

    public Employee(String name, String userName, String password, int employeeId) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.employeeId = employeeId;
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    //employee toString

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }
}
