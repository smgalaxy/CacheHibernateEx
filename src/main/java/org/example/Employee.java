package org.example;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import org.hibernate.annotations.Cache;

@NamedQueries(
        {
                @NamedQuery(name = "findEmployeeByName",query="from Employee e where e.name=:name")
        }
)


@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Employee{
    @Id
    private int id;
    private String name;
    private String address;
    private long salary;

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
