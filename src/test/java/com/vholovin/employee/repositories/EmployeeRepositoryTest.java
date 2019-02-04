package com.vholovin.employee.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void findEmployeesWithBosses_hp() {
        //given
        Map<String, String> expected = new HashMap<>();
        Map<String, String> result = new HashMap<>();

        expected.put("Alex", null);
        expected.put("Boris", "Alex");
        expected.put("Cupasa", "Alex");
        expected.put("Dmytro", "Cupasa");
        expected.put("Evhen", "Cupasa");
        expected.put("Bogdan", "Cupasa");
        expected.put("Frank", "Dmytro");
        expected.put("Amanda", "Dmytro");

        //do
        List<Object[]> employeesWithBosses = employeeRepository.findEmployeesWithBosses();

        employeesWithBosses.forEach(row -> result.put(String.class.cast(row[0]), String.class.cast(row[1])));

        //verify
        assertEquals(expected, result);


    }
}