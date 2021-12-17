package com.practice.employee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Holidays")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Holiday {

    @Id
    //   @GeneratedValue(strategy = GenerationType.AUTO)
    private int holidayId;
    @Column
    private String employeeId;
    @Column
    private LocalDate fromDate;
    @Column
    private LocalDate toDate;
    //    @Column
//    private Boolean halfDay;
    @Column
    private String description;
    @Column
    private Long days;
    @Column
    private long[] sumOfHolidays;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "employeeId") //, name="id"
    private Employee employee;

}