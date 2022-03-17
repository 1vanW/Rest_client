package com.ivan.project;


import com.ivan.project.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class MyCommunication {
    //Задаем поле RestTemplate
    @Autowired
    private RestTemplate restTemplate;
    //URl c которым будем работать
    private final String URL = "http://localhost:8080/spring_course_rest/api/employees";

    //метод для показа всех работников
    public List<Employee> showAllEmployees(){

        ResponseEntity<List<Employee>> responceEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
                });
            List<Employee> allEmployees = responceEntity.getBody();
            return allEmployees;


    }
    // получаем одного работника по ID
    public Employee getEmployee(int id ){

        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);
        return employee;

    }
    //сохраняем работника или обновляем при это надо будет через сеттер указывать id
    public void saveEmployee(Employee employee){

        int id = employee.getId();

        if(id == 0){
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee,String.class);

            System.out.println("You`re add new Employee");
            System.out.println(responseEntity.getBody());
        }
        else {
            restTemplate.put(URL,employee);
            System.out.println("Employee with Id " + id + " was updated");
        }

    }
    // удаляем работника
    public void deleteEmployee(int id){

        restTemplate.delete(URL + "/" + id );

        System.out.println("Employee with id " + id + " was deleted");

    }
}
