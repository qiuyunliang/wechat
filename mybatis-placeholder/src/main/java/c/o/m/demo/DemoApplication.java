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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Employee e1 = null, e2 = null, e3 = null, e4 = null, e5 = null;
        e1 = employeeMapper.selectA(1, "'M' OR '1'='1'");
        logger.info("selectA: {}\n", e1);
        try {
            e2 = employeeMapper.selectB(1, "'M' OR '1'='1'");
        } catch (Exception e) {
            logger.info("selectB: {}", e.getMessage());
        }
        logger.info("selectB: {}\n", e2);

        try {
            e3 = employeeMapper.selectC(1, "M");
            e4 = employeeMapper.selectD(1, "M");
        } catch (Exception e) {
            logger.info("selectC/D: {}", e.getMessage());
        }
        logger.info("selectC: {}\n", e3);
        logger.info("selectD: {}\n", e4);

        e5 = employeeMapper.selectA(1, "M OR '1'='1'");
        logger.info("selectA: {}\n", e5);
    }
}