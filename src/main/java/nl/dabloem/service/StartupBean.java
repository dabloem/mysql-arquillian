/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dabloem.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.inject.Inject;
import nl.dabloem.model.Department;
import nl.dabloem.model.Employee;

/**
 *
 * @author duncan
 */
@Singleton
@Startup
public class StartupBean {
    
    @Inject
    DepartmentService departmentService;

    @PostConstruct
    public void init(){
        Department department = new Department();
        department.setName("Marketing");
        
        Employee employee = new Employee();
        employee.setName("dabloem");
        employee.setDepartment(department);
        
        departmentService.createDepartment(department, employee);
    }

}
