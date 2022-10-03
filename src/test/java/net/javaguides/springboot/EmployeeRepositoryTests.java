package net.javaguides.springboot;


import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.jdbc.core.JdbcTemplate;

import lombok.Builder;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;


@DataJpaTest
public class EmployeeRepositoryTests {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	// 
	 	@Test
	    @Order(1)
	    @Rollback(value = false)
	    public void saveEmployeeTest(){

	        Employee employee = Employee.builder()
	                .firstName("herby")
	                .lastName("nerilus")
	                .email("h@gmail.com")
	                .build();

	        employeeRepository.save(employee);

	        Assertions.assertThat(employee.getId()).isGreaterThan(0);
	    }
	
	@Test
	@Order(2)
	public void getEmployeeTest() {
		Employee employee = employeeRepository.findById(1L).get();
		
		Assertions.assertThat(employee.getId()).isEqualTo(1L);
	}
	
	
	@Test
	@Order(3)
	public void getListOfEmployeesTest() {
		List<Employee> employees = employeeRepository.findAll();
		
		Assertions.assertThat(employees.size()).isGreaterThan(0);
	}
	@Test
	@Order(4)
	@Rollback(value = false)
	
	public void updateEmployeeTest() {
		
		Employee employee = employeeRepository.findById(1L).get();
		
		employee.setEmail("nerilus.h@gmail.Com");
		
		Employee employeeUpdated = employeeRepository.saveEmployee(employee);
		
		Assertions.assertThat(employeeUpdated.getEmail()).isEqualTo("nerilus.h@gmail.com");
	}
	 @Test
	    @Order(5)
	    @Rollback(value = false)
	    public void deleteEmployeeTest(){

	        Employee employee = employeeRepository.findById(1L).get();

	        employeeRepository.delete(employee);

	        //employeeRepository.deleteById(1L);

	        Employee employee1 = null;

	        Optional<Employee> optionalEmployee = employeeRepository.findByEmail("nerilus@gmail.com");

	        if(optionalEmployee.isPresent()){
	            employee1 = optionalEmployee.get();
	        }

	        Assertions.assertThat(employee1).isNull();
	    }

}
