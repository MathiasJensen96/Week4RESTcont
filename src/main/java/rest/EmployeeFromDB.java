package rest;

import com.google.gson.Gson;
import dtos.EmployeeDTO;
import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author mathiasjensen
 */
@Path("employee")
public class EmployeeFromDB {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    @Context
    private UriInfo context;

    public EmployeeFromDB() {
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<EmployeeDTO> query = em.createQuery("SELECT e FROM Employee e", EmployeeDTO.class);
            List<EmployeeDTO> employees = query.getResultList();
            return new Gson().toJson(employees);
        } finally {
            em.close();
        }
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployeeByID(@PathParam("id") int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Employee employee = em.find(Employee.class, (long) id);
            return new Gson().toJson(employee);
        } finally {
            em.close();
        }
    }

    @Path("/highestpaid")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHighestPaidEmployee() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<EmployeeDTO> query = em.createQuery("SELECT e FROM Employee e WHERE e.salary = (SELECT MAX(e.salary) FROM Employee e)", EmployeeDTO.class);
            List<EmployeeDTO> employees = query.getResultList();
            return new Gson().toJson(employees);
        } finally {
            em.close();
        }
    }
    
    @Path("name/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployeeByName(@PathParam("name") String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.name =:name", Employee.class);
            query.setParameter("name", name);
            Employee employee = query.getSingleResult();
            return new Gson().toJson(employee);
        } finally {
            em.close();
        }
    }
}
