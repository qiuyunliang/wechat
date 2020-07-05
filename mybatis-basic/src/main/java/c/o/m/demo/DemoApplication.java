package c.o.m.demo;

import c.o.m.demo.dao.EmployeeMapper;
import c.o.m.demo.entity.Employee;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    private EmployeeMapper employeeMapper;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Employee e1 = employeeMapper.selectOne(1);
        logger.info("select without education info: {}", e1);
        Employee e2 = employeeMapper.joinSelectOne(1);
        logger.info("select with education info: {}", e2);
        List<Employee> list = employeeMapper.selectAll();
        logger.info("select list: {}", list);

        Employee e3;
        Employee queryObject = new Employee();
        e3 = employeeMapper.selectByProperty(queryObject);
        logger.info("select with nothing: {}", e3);
        queryObject.setHireDate(new Date());
        e3 = employeeMapper.selectByProperty(queryObject);
        logger.info("select when hiredate is not null: {}", e3);
        queryObject.setName("OLI");
        e3 = employeeMapper.selectByProperty(queryObject);
        logger.info("select when both are not null: {}", e3);

        Employee employee = new Employee();
        employee.setName("SAN");
        employee.setSalary(Money.of(CurrencyUnit.of("USD"), 150000.0));
        employee.setBirthday(new Date());
        employee.setHireDate(new Date());
        employee.setLevel(20);
        employee.setDepartment("HRBP");
        logger.info("before insert: {}", employee);
        employeeMapper.insertOne(employee);
        logger.info("after insert: {}", employee);

        employee.setName("SI");
        employeeMapper.updateOne(employee);
    }
}