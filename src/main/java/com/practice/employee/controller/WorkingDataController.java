package com.practice.employee.controller;

import com.practice.employee.entity.WorkingData;
import com.practice.employee.model.WorkingDataModel;
import com.practice.employee.service.WorkingDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Data")
public class WorkingDataController {

    private WorkingDataService workingDataService;

    @PostMapping("/add")
    public WorkingData add(@RequestBody WorkingDataModel workingDataModel){
        return workingDataService.addWorkingData(workingDataModel);
    }
    @GetMapping("/get")
    public List<WorkingDataModel> getData(){
        return workingDataService.getWorkingData();
    }
}
