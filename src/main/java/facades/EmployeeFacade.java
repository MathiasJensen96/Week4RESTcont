package facades;

import dtos.RenameMeDTO;
import entities.Employee;
import entities.RenameMe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author mathiasjensen
 */
public class EmployeeFacade {
    
    private static EmployeeFacade instance;
    private static EntityManagerFactory emf;

    public EmployeeFacade() {
    }
    
    public static EmployeeFacade getEmployeeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Employee createEmployee(String name, String address, int salary){
        Employee e = new Employee(name, address, salary);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
            return e;
        } finally {
            em.close();
        }
    }
    
    public Employee getEmployeeByID(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Employee e = em.find(Employee.class, id);
            return e;
        } finally {
            em.close();
        }
    }
    
    public Employee getEmployeeByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.name =:name", Employee.class);
            query.setParameter("name", name);
            Employee e = query.getSingleResult();
            return e;
        } finally {
            em.close();
        }
    }
    
    public List<Employee> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
            List<Employee> employees = query.getResultList();
            return employees;
        } finally {
            em.close();
        }
    }
    
    public List<Employee> getEmployeesWithHighestSalary() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.salary = (SELECT MAX(e.salary) FROM Employee e)", Employee.class);
            List<Employee> high = query.getResultList();
            return high;
        } finally {
            em.close();
        }
    }
}
