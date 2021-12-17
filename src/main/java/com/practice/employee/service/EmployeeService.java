package com.practice.employee.service;

import com.practice.employee.entity.Admin;
import com.practice.employee.entity.Employee;
import com.practice.employee.entity.Holiday;
import com.practice.employee.model.AdminModel;
import com.practice.employee.model.EmployeeModel;
import com.practice.employee.model.HolidayModel;
import com.practice.employee.repository.AdminRepository;
import com.practice.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AdminRepository adminRepository;

    public Employee addEmployee( EmployeeModel emp) {

        Employee employee = new Employee();

        List<Holiday> holidays = new ArrayList<>();
            emp.getHolidayModels().forEach(h ->{
            Holiday holiday = new Holiday();

            holiday.setHolidayId(h.getHolidayId());
 //           holiday.setEmployeeId(h.getEmployeeId());
            holiday.setFromDate(h.getFromDate());
            holiday.setToDate(h.getToDate());
            long days = ChronoUnit.DAYS.between(h.getFromDate(),h.getToDate());
            holiday.setDays(days);
            holiday.setDescription(h.getDescription());
            holiday.setEmployee(employee);
            holidays.add(holiday);
        });

        Admin admin = new Admin();

        List<Employee> employees = new ArrayList<>();

//        admin.setAdminId(emp.getAdminModel().getAdminId());
//        admin.setAdminName(emp.getAdminModel().getAdminName());
//        admin.setStatus(emp.getAdminModel().isStatus());

        employee.setEmployeeId(emp.getEmployeeId());
        employee.setAdminId(emp.getAdminId());
        employee.setName(emp.getName());
        employee.setEmail(emp.getEmail());
        employee.setPhoneNo(emp.getPhoneNo());
        employee.setDesignation(emp.getDesignation());
        employee.setSalary(emp.getSalary());
        employee.setRemainingHolidays(emp.getRemainingHolidays());
//        employee.setAdmin(admin);
        employee.setHolidays(holidays);
        employees.add(employee);
//        admin.setEmployeesList(employees);
        return employeeRepository.save(employee);
    }

    public EmployeeModel getEmployeeModel(Employee employee){

        List<HolidayModel> holidayModels = new ArrayList<>();
        employee.getHolidays().forEach(h -> {

            HolidayModel holidayModel = new HolidayModel();
            holidayModel.setHolidayId(h.getHolidayId());
//            holidayModel.setEmployeeId(h.getEmployeeId());
            holidayModel.setFromDate(h.getFromDate());
            holidayModel.setToDate(h.getToDate());
            holidayModel.setDays(h.getDays());
            long[] sum = {0};
            employee.getHolidays().forEach(x-> {
                sum[0] = sum[0] +x.getDays();});
            holidayModel.setSumOfHolidays(sum);
            holidayModel.setDescription(h.getDescription());
            holidayModels.add(holidayModel);

        });

//        AdminModel adminModel = new AdminModel();
//        adminModel.setAdminId(employee.getAdmin().getAdminId());
//        adminModel.setAdminName(employee.getAdmin().getAdminName());
//        adminModel.setStatus(employee.getAdmin().isStatus());


        EmployeeModel employeeModel = new EmployeeModel();

        employeeModel.setEmployeeId(employee.getEmployeeId());
        employeeModel.setAdminId(employee.getAdminId());
        employeeModel.setName(employee.getName());
        employeeModel.setEmail(employee.getEmail());
        employeeModel.setPhoneNo(employee.getPhoneNo());
        employeeModel.setDesignation(employee.getDesignation());
        employeeModel.setSalary(employee.getSalary());
        employeeModel.setRemainingHolidays(employee.getRemainingHolidays());
//        employeeModel.setAdminModel(adminModel);
        employeeModel.setHolidayModels(holidayModels);

        return employeeModel;
    }
    public EmployeeModel getById(String id){
       Optional<Employee> employee = employeeRepository.findById(id);
       if (employee.isPresent()){
           return getEmployeeModel(employee.get());
       }
       return null;
    }
    public List<EmployeeModel> getEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(e -> getEmployeeModel(e)).collect(Collectors.toList());
    }

//    public List<EmployeeModel> getByEmail(String email){
//        List<Employee> employees = employeeRepository.findAll();
//        return employees.stream().filter(m->m.getEmail().equals(email)).
//                map(m->getEmployeeModel(m)).collect(Collectors.toList());
//    }

//    public List<EmployeeModel> getRemainingHolidays(){
//        List<Employee> employees = employeeRepository.findAll();
//        employees.forEach(e -> {
//            e.getHolidays().stream().filter(h -> {
//                e.getRemainingHolidays()
//            });
//        }); }

//    }

}
