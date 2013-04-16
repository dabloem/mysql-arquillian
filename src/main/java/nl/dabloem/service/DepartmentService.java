/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dabloem.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.dabloem.model.Department;
import nl.dabloem.model.Employee;

/**
 *
 * @author duncan
 */
@Stateless
@LocalBean
public class DepartmentService {

    @PersistenceContext
    EntityManager em;
    
    public void createDepartment(Department department, Employee employee) {
        department.setManager(employee);
        employee.setDepartment(department);
        em.persist(department);
        em.persist(employee);
    }

}
