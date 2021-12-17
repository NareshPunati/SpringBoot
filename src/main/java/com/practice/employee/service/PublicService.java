package com.practice.employee.service;

import com.practice.employee.entity.PublicHolidays;
import com.practice.employee.model.PublicHolidaysModel;
import com.practice.employee.repository.PublicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicService {

    @Autowired
    private PublicRepository publicRepository;

    public PublicHolidays addPublicHolidays(PublicHolidaysModel publicHolidaysModel){

        PublicHolidays publicHolidays = new PublicHolidays();
        publicHolidays.setId(publicHolidaysModel.getId());
        publicHolidays.setDate(publicHolidaysModel.getDate());
        publicHolidays.setDescription(publicHolidaysModel.getDescription());
//        publicHolidays.setHolidayFinancialYear(publicHolidaysModel.getHolidayFinancialYear());

        return publicRepository.save(publicHolidays);
    }

    public PublicHolidaysModel getPublicHolidaysModel(PublicHolidays publicHolidays){

        PublicHolidaysModel publicHolidaysModel = new PublicHolidaysModel();
        publicHolidaysModel.setId(publicHolidays.getId());
        publicHolidaysModel.setDate(publicHolidays.getDate());
        publicHolidaysModel.setDescription(publicHolidays.getDescription());
//        publicHolidaysModel.setHolidayFinancialYear(publicHolidays.getHolidayFinancialYear());

        return publicHolidaysModel;
    }

    public List<PublicHolidaysModel> getPublicHoliday(){
        List<PublicHolidays> holidays = publicRepository.findAll();
        return holidays.stream().map(holiday -> getPublicHolidaysModel(holiday)).
                collect(Collectors.toList());
    }
}
