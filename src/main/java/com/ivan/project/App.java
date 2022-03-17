package com.ivan.project;

import com.ivan.project.configuration.MyConfig;
import com.ivan.project.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Создаем контекст
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MyConfig.class);
        MyCommunication myCommunication =
                annotationConfigApplicationContext.getBean("myCommunication",MyCommunication.class);


//       List<Employee> list =  myCommunication.showAllEmployees();
//
//        System.out.println(list);

//        Employee empById = myCommunication.getEmployee(1);
//        System.out.println(empById );

//        Employee employee = new Employee("Oleg", "Sokolov","IT",800);
//
//        employee.setId(9);
//        myCommunication.saveEmployee(employee);

        myCommunication.deleteEmployee(9);



    }
}
