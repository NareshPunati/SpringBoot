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
public class AdminModel {

    private String adminId;
    private String adminName;
//    private String employeeId;
    private boolean status;

}
