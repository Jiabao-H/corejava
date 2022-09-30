package Homework1;

import java.io.Serializable;

/**
 * Problems: Define a “Employee” POJO class and make it serializable
 */
public class Employee implements Serializable {
    // private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    transient private int salary;

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
