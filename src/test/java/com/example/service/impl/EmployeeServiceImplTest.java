/*
 * package com.example.service.impl;
 * 
 * import static org.junit.Assert.assertEquals;
 * 
 * import java.util.Arrays;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import org.mockito.Mockito;
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.test.context.TestPropertySource; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.example.dao.EmployeeDaoImpl; import com.example.model.Employee;
 * import com.example.service.EmployeeServiceImpl;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @TestPropertySource(locations =
 * {"classpath:application.properties","classpath:limits-service.properties"})
 * 
 * @SpringBootTest public class EmployeeServiceImplTest {
 * 
 * @InjectMocks
 * 
 * @Autowired EmployeeServiceImpl employeeServiceImpl;
 * 
 * @Mock EmployeeDaoImpl employeeDaoImpl;
 * 
 * @Test public void testGetEmployee() {
 * Mockito.when(employeeDaoImpl.getAllEmployees()).thenReturn(Arrays.asList(new
 * Employee[]{ new Employee("manzer", "cse")})); assertEquals("manzer",
 * employeeDaoImpl.getAllEmployees().get(1));
 * 
 * } }
 */