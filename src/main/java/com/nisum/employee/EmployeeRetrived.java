package com.nisum.employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRetrived implements RowMapper<Employee> {

	private static Logger logger = LoggerFactory.getLogger(EmployeeRetrived.class);
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		logger.info("BEGIN :: EmployeeRetrived :: mapRow "+rowNum);
		Employee e = new Employee();
		e.setEid(rs.getInt(1));
		e.setEname(rs.getString(2));
		e.setEsal(rs.getFloat(3));
		return e;
	}

}
