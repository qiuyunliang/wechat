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
    Employee selectById(long id);
    Employee selectByOtherName(long record);
    Employee selectByMap(Map<String, Object> params);
    Employee selectByMultiName(long cow, String name, int clazz);
    Employee selectByMultiSameName(long cow, String name, int clazz);
    Employee selectByIndex(long row, String name, int clazz);
    Employee selectByParam(long row, String name, int clazz);
    void insertOne(Employee employee);


    Employee selectByIdAnnotation(@Param("id") long id);
    Employee selectByCowAnnotation(@Param("id") long id);
    Employee selectByIdParamAnnotation(@Param("id") long id);
    Employee selectByMultiNameAnnotation(@Param("id") long id, @Param("name") String name);
    Employee selectByMultiNameParamAnnotation(@Param("id") long id, @Param("name") String name);
}