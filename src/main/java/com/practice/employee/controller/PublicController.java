package com.practice.employee.controller;

import com.practice.employee.entity.PublicHolidays;
import com.practice.employee.model.PublicHolidaysModel;
import com.practice.employee.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private PublicService publicService;

    @PostMapping("/add/Public")
    public PublicHolidays add(@RequestBody PublicHolidaysModel publicHolidaysModel){
        return publicService.addPublicHolidays(publicHolidaysModel);
    }
    @GetMapping("/get/public")
    public List<PublicHolidaysModel> getPublicHolidays(){
        return publicService.getPublicHoliday();
    }
}
