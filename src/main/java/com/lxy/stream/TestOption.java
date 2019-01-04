package com.lxy.stream;

import com.abc.lamdba.Employee;
import org.junit.Test;

import java.util.Optional;

public class TestOption {

    @Test
    public void test(){
        Optional<Employee> em = Optional.of(new Employee());
        System.out.println(em.get());

/*        Optional<Employee> emp = Optional.empty();
        System.out.println(emp.get());*/

        Optional<Employee> empl = Optional.ofNullable(new Employee());
        System.out.println(empl.get());

//        Optional<Employee> emp = Optional.ofNullable(new Employee());
        /*Optional<Employee> emp = Optional.ofNullable(null);
        Employee rs = emp.orElse(new Employee(10,"10"));
        System.out.println(rs.getName());*/

        Optional<Employee> emp = Optional.ofNullable(null);
        Employee rs = emp.orElseGet(()->new Employee(10,"10"));
        System.out.println(rs.getName());

        Employee employee = null;
//        Optional<Employee> emp2 = Optional.ofNullable(employee);

        System.out.println(Optional.ofNullable(employee).map(x -> x.getName()).orElse("not supported!"));
    }
}
