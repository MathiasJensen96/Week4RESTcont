/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.RenameMeDTO;
import entities.Employee;
import entities.RenameMe;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    public static EmployeeFacade ef = EmployeeFacade.getEmployeeFacade(emf);

    public static void populate() {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        FacadeExample fe = FacadeExample.getFacadeExample(emf);
        fe.create(new RenameMeDTO(new RenameMe("First 1", "Last 1")));
        fe.create(new RenameMeDTO(new RenameMe("First 2", "Last 2")));
        fe.create(new RenameMeDTO(new RenameMe("First 3", "Last 3")));
    }

    public static void populateEmployees() {
        ef.createEmployee("Mathias", "Jordbærgade", 10000);
        ef.createEmployee("August", "Pæregade", 20000);
        ef.createEmployee("Thias", "Æblegade", 5000);

    }

    public static void main(String[] args) {
        populateEmployees();
        Employee e = ef.getEmployeeByID(1);
        System.out.println(e.getName());
        Employee e2 = ef.getEmployeeByName("Thias");
        System.out.println(e2.getAddress());
        List<Employee> employeeList = ef.getAllEmployees();
        for (Employee employee : employeeList) {
            System.out.println(employee.getName());
        }
        List<Employee> highestSalary = ef.getEmployeesWithHighestSalary();
        System.out.println(highestSalary.get(0).getName());
    }
}
