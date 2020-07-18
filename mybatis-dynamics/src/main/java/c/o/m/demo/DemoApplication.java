package c.o.m.demo;

import c.o.m.demo.dao.EmployeeMapper;
import c.o.m.demo.entity.Employee;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@MapperScan("c.o.m.demo.dao")
@SpringBootApplication
public class DemoApplication implements ApplicationRunner {

    @Autowired
    private EmployeeMapper employeeMapper;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Employee employee = new Employee();
        employee.setName("SAN");
        employee.setSalary(Money.of(CurrencyUnit.of("USD"), 150000.0));
        employee.setBirthday(new Date());
        employee.setHireDate(new Date());
        employee.setLevel(20);
        employee.setDepartment("HRBP");
        employeeMapper.insertOne(employee);

        employee.setName("SI");
        employeeMapper.updateOne(employee);

        Employee e = employeeMapper.selectOne(1);

        List<Employee> list = employeeMapper.selectAll();
    }
}