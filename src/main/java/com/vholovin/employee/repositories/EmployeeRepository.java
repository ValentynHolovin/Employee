package com.vholovin.employee.repositories;

import com.vholovin.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT emp2.name AS employee_name, emp1.name AS boss_name FROM employees emp1 RIGHT JOIN employees emp2 ON emp1.id = emp2.boss_id", nativeQuery = true)
    List<Object[]> findEmployeesWithBosses();
}
