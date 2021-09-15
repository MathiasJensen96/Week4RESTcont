package facades;

import entities.Employee;
import static facades.Populator.ef;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mathiasjensen
 */
public class EmployeeFacadeTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityManager em = emf.createEntityManager();
/*
    public EmployeeFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {

        EmployeeFacadeTest.populateEmployeesTest();
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }
     
    
    @Test
    public void testCreateEmployee() {
        String name = "Mathias";
        String address = "Jordbærgade";
        int salary = 10000;
        EmployeeFacade instance = EmployeeFacade.getEmployeeFacade(emf);
        Employee expResult = new Employee("Mathias", "Jordbærgade", 10000);
        Employee result = instance.createEmployee(name, address, salary);
        assertEquals(expResult.getName(), result.getName());
    }


    @Test
    public void testGetEmployeeByID() {
        long id = 2;
        EmployeeFacade instance = EmployeeFacade.getEmployeeFacade(emf);
        Employee expResult = new Employee("August", "Pæregade", 20000);
        Employee result = instance.getEmployeeByID(id);
        assertEquals(expResult.getName(), result.getName());
    }


    @Test
    public void testGetEmployeeByName() {
        String name = "Thias";
        EmployeeFacade instance = EmployeeFacade.getEmployeeFacade(emf);
        Employee expResult = new Employee("Thias", "Æblegade", 5000);
        Employee result = instance.getEmployeeByName(name);
        assertEquals(expResult.getName(), result.getName());
    }

    @Test
    public void testGetAllEmployees() {
        EmployeeFacade instance = EmployeeFacade.getEmployeeFacade(emf);
        List<Employee> expResult = new ArrayList<>();
        expResult.add(new Employee("Mathias", "Jordbærgade", 10000));
        expResult.add(new Employee("August", "Pæregade", 20000));
        expResult.add(new Employee("Thias", "Æblegade", 5000));
        List<Employee> result = instance.getAllEmployees();
        assertEquals(expResult.get(1).getName(), result.get(1).getName());
    }

    @Test
    public void testGetEmployeesWithHighestSalary() {
        EmployeeFacade instance = EmployeeFacade.getEmployeeFacade(emf);
        List<Employee> expResult = new ArrayList<>();
        expResult.add(new Employee("August", "Pæregade", 20000));
        List<Employee> result = instance.getEmployeesWithHighestSalary();
        assertEquals(expResult.get(0).getSalary(), result.get(0).getSalary());
    }

    public static void populateEmployeesTest() {
        ef.createEmployee("Mathias", "Jordbærgade", 10000);
        ef.createEmployee("August", "Pæregade", 20000);
        ef.createEmployee("Thias", "Æblegade", 5000);

    }
    */
}
