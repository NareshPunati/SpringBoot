package com.practice.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

    private String employeeId;
    private String adminId;
    private String name;
    private String email;
    private Long phoneNo;
    private String designation;
    private Float salary;
    private int remainingHolidays;
//    private AdminModel adminModel;
    private List<HolidayModel> holidayModels;

}
