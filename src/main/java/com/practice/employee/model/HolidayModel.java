package com.practice.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class HolidayModel {

    private int holidayId;
    private String employeeId;
    private LocalDate fromDate;
    private LocalDate toDate;
//    private Boolean halfDay;
    private String description;
    private Long days;
    private long[] sumOfHolidays;

}
