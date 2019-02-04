package com.vholovin.employee.domain;

import com.vholovin.employee.repositories.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeTest {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    public void printTree_hp() {
        //given
        Employee employee = employeeRepository.getOne(3);
        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newPrintStream = new PrintStream(outputStream);
        System.setOut(newPrintStream);

        String output1 = "Employee{id=3, name='Cupasa'}";
        String output2 = "Employee{id=4, name='Dmytro'}";
        String output3 = "Employee{id=7, name='Frank'}";
        String output4 = "Employee{id=8, name='Amanda'}";
        String output5 = "Employee{id=6, name='Bogdan'}";
        String output6 = "Employee{id=5, name='Evhen'}";

        //do
        employee.printTree();

        //verify
        assertTrue(outputStream.toString().contains(output1));
        assertTrue(outputStream.toString().contains(output2));
        assertTrue(outputStream.toString().contains(output3));
        assertTrue(outputStream.toString().contains(output4));
        assertTrue(outputStream.toString().contains(output5));
        assertTrue(outputStream.toString().contains(output6));

        System.setOut(console);
    }
}