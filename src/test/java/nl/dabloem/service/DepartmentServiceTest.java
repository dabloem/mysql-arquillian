/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dabloem.service;

import javax.inject.Inject;
import nl.dabloem.model.Department;
import nl.dabloem.model.Employee;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author duncan
 */
@RunWith(Arquillian.class)
public class DepartmentServiceTest {
    

    @Inject
    DepartmentService departmentService;
    
    @Deployment
    public static Archive<?> createDeployment() {
        WebArchive war = ShrinkWrap
                .create(WebArchive.class)
                .addClass(DepartmentService.class)
                .addClasses(Department.class, Employee.class)
                .addAsWebInfResource("META-INF/persistence.xml", "classes/META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
        return war;
    }
    
    /**
     * Test of createDepartment method, of class DepartmentService.
     */
    @Test
    @ShouldMatchDataSet("create-department.xml")
    public void testCreateDepartment() throws Exception {
        System.out.println("createDepartment");
        Department department = new Department();
        department.setName("Marketing");
        
        Employee employee = new Employee();
        employee.setName("dabloem");
        employee.setDepartment(department);
        
        departmentService.createDepartment(department, employee);
    }

    @Test
    @UsingDataSet("department.xml")
    public void testGetDepartment() throws Exception {
        System.out.println("createDepartment");
        Department department = new Department();
        department.setName("Marketing");
        
        Employee employee = new Employee();
        employee.setName("dabloem");
        employee.setDepartment(department);
        
        departmentService.createDepartment(department, employee);
    }
}