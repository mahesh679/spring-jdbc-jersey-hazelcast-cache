package com.nisum.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nisum.dao.EmployeeDao;
import com.nisum.employee.Employee;

@Controller
@Path("employee")
public class EmployeeController {
	
	private static Logger logger=LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeDao edao;

	@Path("addemployee")
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Employee addEmployee(Employee e) {
		logger.info("BEGIN :: EmployeeController :: addEmployee");
		Employee employee = edao.saveEmployee(e);
		logger.info("END :: EmployeeController :: addEmployee :: Response "+employee);
		return employee;
	}
	
	@Path("updateemployee")
	@PUT
	public Employee updateEmployee(Employee e) {
		logger.info("BEGIN :: EmployeeController :: updateEmployee");
		Employee employee = edao.updateEmployee(e);
		logger.info("END :: EmployeeController :: updateEmployee :: Response "+employee);
		return employee;
	}
	
	
	@Path("getEmployee/{eid}")
	@GET
	@Produces({MediaType.APPLICATION_JSON/*,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN*/})
	public Employee getEmployeeByEid(@PathParam("eid") Integer eid) {
		logger.info("BEGIN :: EmployeeController :: getEmployeeByEid :: Employee Id "+eid);
		return edao.getByEid(eid);
	}
	
	@Path("removeemployee/{eid}")
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN})
	public String deleteEmployee(@PathParam("eid") Integer eid) {
		logger.info("BEGIN :: EmployeeController :: deleteEmployee :: Employee Id "+eid);
		return edao.deleteEmployee(eid);
	}
	
	@GET
	@Path("getAllEmployees")
	@Produces({/*MediaType.APPLICATION_XML,*/MediaType.APPLICATION_JSON})
	public List<Employee> getAllEmployees() {
		logger.info("BEGIN :: EmployeeController :: getAllEmployees");
		List<Employee> list = edao.getAllEmployee();
		list.forEach(p->p.toString());
		logger.info("END :: EmployeeController :: getAllEmployees :: No-of Objects "+ list.size());
		return list;
	}
}
