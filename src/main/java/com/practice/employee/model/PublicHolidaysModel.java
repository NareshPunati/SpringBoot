package com.practice.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicHolidaysModel {

    private int id;
    private String date;
    private String description;
    private String holidayFinancialYear;
}
