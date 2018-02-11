package com.nisum.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nisum.employee.Employee;
import com.nisum.employee.EmployeeRetrived;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	private static Logger logger=LoggerFactory.getLogger(EmployeeDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		logger.info("BEGIN :: EmployeeDaoImpl :: setJdbcTemplate");
		this.jdbcTemplate = jdbcTemplate;
	}

	@CachePut(value="employeeCache",key="#e.getEid()")
	public Employee saveEmployee(Employee e) {
		// TODO Auto-generated method stub
		logger.info("BEGIN :: EmployeeDaoImpl :: saveEmployee");
		String query = "insert into Employee values(" + e.getEid() + ",'" + e.getEname() + "'," + e.getEsal() + ")";
		int save = jdbcTemplate.update(query);
		logger.info("STEP1 :: EmployeeDaoImpl :: saveEmployee "+save);
		return e;
		/*if(save>0) {
			logger.info("STEP2 :: EmployeeDaoImpl :: saveEmployee :: success");
			return e;
		}
		else {
			logger.info("STEP2 :: EmployeeDaoImpl :: saveEmployee :: failure");
			return "Sorry ! record not added";
		}*/
		}

	@CachePut(value="employeeCache",key="#e.getEid()")
	public Employee updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		logger.info("BEGIN :: EmployeeDaoImpl :: updateEmployee");
		String query = "update employee set ename='" + e.getEname() + "', esal=" + e.getEsal() + " where eid="
				+ e.getEid();
		int update = jdbcTemplate.update(query);
		logger.info("STEP1 :: EmployeeDaoImpl :: updateEmployee "+update);
		return e;
		/*if(update>0) {
			logger.info("STEP2 :: EmployeeDaoImpl :: updateEmployee :: success");
			return "Record updated Successfully";
		}
		else {
			logger.info("STEP2 :: EmployeeDaoImpl :: updateEmployee :: failure");
			return "Sorry ! record not updated";
		}*/
		}

	@CacheEvict(value="employeeCache",key="#eid")
	public String deleteEmployee(int eid) {
		// TODO Auto-generated method stub
		logger.info("BEGIN :: EmployeeDaoImpl :: deleteEmployee :: Employee Id "+eid);
		String query = "delete from employee where eid=" + eid;
		int delete = jdbcTemplate.update(query);
		logger.info("STEP1 :: EmployeeDaoImpl :: deleteEmployee "+delete);
		if(delete>0) {
			logger.info("STEP2 :: EmployeeDaoImpl :: deleteEmployee :: success");
			return "Record deleted Successfully";
		}
		else {
			logger.info("STEP2 :: EmployeeDaoImpl :: deleteEmployee :: failure");
			return "Sorry ! record not deleted";
		}
	}


	@Cacheable(value="employeeCache")
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		logger.info("BEGIN :: EmployeeDaoImpl :: getAllEmployee");
	/*	List<Employee> list = jdbcTemplate.queryForList("select * from employee",Employee.class);
		return list;*/
		return jdbcTemplate.query("select * from employee", new EmployeeRetrived());
	}


	@Cacheable(value="employeeCache",key="#eid",unless="#result==null")
	public Employee getByEid(Integer eid) {
		// TODO Auto-generated method stub
		logger.info("BEGIN :: EmployeeDaoImpl :: getByEid :: Employee Id "+eid);
		//System.out.println(jdbcTemplate.queryForObject("select * from employee where eid="+eid, Employee.class));
		Employee e = jdbcTemplate.queryForObject("select * from employee where eid="+eid, new EmployeeRetrived());
		
		return e;
		//return jdbcTemplate.query("select * from employee where eid="+eid, new EmployeeRetrived());
	}
}
