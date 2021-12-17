package com.practice.employee.service;

import com.practice.employee.entity.WorkingData;
import com.practice.employee.model.WorkingDataModel;
import com.practice.employee.repository.WorkingDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkingDataService {

    private WorkingDataRepository workingDataRepository;

    public WorkingData addWorkingData(WorkingDataModel workingDataModel){

        WorkingData workingData = new WorkingData();
        workingData.setId(workingDataModel.getId());
        workingData.setWorkingHours(workingDataModel.getWorkingHours());
        workingData.setNoOfHolidays(workingDataModel.getNoOfHolidays());

        return workingDataRepository.save(workingData);
    }
    public WorkingDataModel getWorkingDataModel(WorkingData workingData){

        WorkingDataModel workingDataModel = new WorkingDataModel();
        workingDataModel.setId(workingData.getId());
        workingDataModel.setWorkingHours(workingData.getWorkingHours());
        workingDataModel.setNoOfHolidays(workingData.getNoOfHolidays());

        return workingDataModel;
    }
    public List<WorkingDataModel> getWorkingData(){
        List<WorkingData> data = workingDataRepository.findAll();
        return data.stream().map(c -> getWorkingDataModel(c)).collect(Collectors.toList());
    }
}
