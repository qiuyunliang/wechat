package c.o.m.demo.dao;

import c.o.m.demo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface EmployeeMapper {

    Employee selectA(long id, String name);
    Employee selectB(long id, String name);
    Employee selectC(long id, String name);
    Employee selectD(long id, String name);
}