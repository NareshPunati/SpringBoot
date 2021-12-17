package com.practice.employee.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String employeeId;
    @Column
    private String adminId;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private Long phoneNo;
    @Column
    private String designation;
    @Column
    private Float salary;
    @Column
    private int remainingHolidays;

//    @JsonManagedReference
//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn(referencedColumnName = "adminId")
//    private Admin admin;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "employee")
    private List<Holiday> holidays;

}
