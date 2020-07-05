package c.o.m.demo.dao;

import c.o.m.demo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {

    Employee selectOne(long id);

    Employee joinSelectOne(long id);

    Employee selectByProperty(Employee employee);

    List<Employee> selectAll();

    void insertOne(Employee employee);

    void deleteOne(long id);

    void updateOne(Employee employee);
}