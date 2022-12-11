package com.example.sprinngkipproductservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firm;            // наименование организации
    private String address;         // адрес
    private String email;           // центральная рабочая почта
    private String telephone;       // телефон приемной
    private String leaderManager;   // директор

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "firm", orphanRemoval = true)
    private Set<Employee> employees = new HashSet<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setFirm(this);
    }
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        employee.setFirm(null);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firm='" + firm + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", leaderManager='" + leaderManager + '\'' +
                ", employees=" + employees +
                '}';
    }
}
