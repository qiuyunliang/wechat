package c.o.m.demo;

import c.o.m.demo.dao.EmployeeMapper;
import c.o.m.demo.entity.Employee;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.cache.decorators.TransactionalCache;
import org.apache.ibatis.cache.impl.PerpetualCache;
import org.apache.ibatis.executor.Executor;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.HashMap;
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
        Employee first = employeeMapper.selectOne(15);
        logger.info("first query: {}", first);
        Employee second = employeeMapper.selectOne(15);
        logger.info("second query: {}", second);
    }

//    // 一级缓存查询、更新和删除操作对一级缓存的影响
//    @Transactional
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        Employee first = employeeMapper.selectOne(15);
//        logger.info("first query: {}", first);
//
//        first.setName("LIU");
//        employeeMapper.updateOne(first);
//
//        Employee second = employeeMapper.selectOne(15);
//        logger.info("second query: {}", second);
//        Employee third = employeeMapper.selectOne(15);
//        logger.info("third query: {}", third);
//
//        employeeMapper.deleteOne(15);
//        Employee fourth = employeeMapper.selectOne(15);
//        logger.info("fourth query: {}", fourth);
//    }
}