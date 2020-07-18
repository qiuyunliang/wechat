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
        Employee e1 = null;
        try {
            e1 = employeeMapper.selectById(1);
        } catch (Exception e) {
            logger.info("selectById: {}", e.getMessage());
        }
        logger.info("selectById: {}\n", e1);

        Employee e2 = null;
        try {
            e2 = employeeMapper.selectByOtherName(1);
        } catch (Exception e) {
            logger.info("selectByOtherName: {}", e.getMessage());
        }
        logger.info("selectByOtherName: {}\n", e2);

        Map<String, Object> params = new HashMap<>();
        params.put("eId", 1);
        params.put("eName", "M");
        params.put("eLevel", 5);
        Employee e3 = null;
        try {
            e3 = employeeMapper.selectByMap(params);
        } catch (Exception e) {
            logger.info("selectByMap: {}", e.getMessage());
        }
        logger.info("selectByMap: {}\n", e3);

        Employee e4 = null;
        try {
            e4 = employeeMapper.selectByMultiName(1, "M", 5);
        } catch (Exception e) {
            logger.info("selectByMultiName: {}", e.getMessage());
        }
        logger.info("selectByMultiName: {}\n", e4);

        Employee e5 = null;
        try {
            e5 = employeeMapper.selectByMultiSameName(1, "M", 5);
        } catch (Exception e) {
            logger.info("selectByMultiSameName: {}", e.getMessage());
        }
        logger.info("selectByMultiSameName: {}\n", e5);


        Employee e6 = null;
        try {
            e6 = employeeMapper.selectByIndex(2, "N", 4);
        } catch (Exception e) {
            logger.info("selectByIndex: {}", e.getMessage());
        }
        logger.info("selectByIndex: {}\n", e6);
        Employee e7 = null;
        try {
            e7 = employeeMapper.selectByParam(3, "P", 3);
        } catch (Exception e) {
            logger.info("selectByParam: {}", e.getMessage());
        }
        logger.info("selectByParam: {}\n", e7);

        Employee e8 = new Employee();
        e8.setName("SAN");
        e8.setSalary(Money.of(CurrencyUnit.of("USD"), 134.0));
        e8.setBirthday(new Date());
        e8.setHireDate(new Date());
        e8.setLevel(20);
        e8.setDepartment("HRBP");
        employeeMapper.insertOne(e8);
        logger.info("insertOne: {}\n", e8);



        Employee e9 = null;
        try {
            e9 = employeeMapper.selectByIdAnnotation(1);
        } catch (Exception e) {
            logger.info("selectByIdAnnotation: {}", e.getMessage());
        }
        logger.info("selectByIdAnnotation: {}\n", e9);
        Employee e10 = null;
        try {
            e10 = employeeMapper.selectByCowAnnotation(1);
        } catch (Exception e) {
            logger.info("selectByCowAnnotation: {}", e.getMessage());
        }
        logger.info("selectByCowAnnotation: {}\n", e10);
        Employee e11 = null;
        try {
            e11 = employeeMapper.selectByIdParamAnnotation(1);
        } catch (Exception e) {
            logger.info("selectByIdParamAnnotation: {}", e.getMessage());
        }
        logger.info("selectByIdParamAnnotation: {}\n", e11);

        Employee e12 = null;
        try {
            e12 = employeeMapper.selectByMultiNameAnnotation(1, "M");
        } catch (Exception e) {
            logger.info("selectByMultiNameAnnotation: {}", e.getMessage());
        }
        logger.info("selectByMultiNameAnnotation: {}\n", e12);
        Employee e13 = null;
        try {
            e13 = employeeMapper.selectByMultiNameParamAnnotation(1, "M");
        } catch (Exception e) {
            logger.info("selectByMultiNameParamAnnotation: {}", e.getMessage());
        }
        logger.info("selectByMultiNameParamAnnotation: {}\n", e13);
    }
}