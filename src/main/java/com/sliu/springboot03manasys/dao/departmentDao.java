package com.sliu.springboot03manasys.dao;

import com.sliu.springboot03manasys.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class departmentDao {
//    模拟department表数据库信息
    static Map<Integer, Department> departmentMap = null;
    static {
        departmentMap = new HashMap<>();
        departmentMap.put(101, new Department(101, "教学部"));
        departmentMap.put(102, new Department(102, "生活部"));
        departmentMap.put(103, new Department(103, "财务部"));
        departmentMap.put(104, new Department(104, "后勤部"));
        departmentMap.put(105, new Department(105, "保卫部"));
    }
//    获取全部部门信息
    public Collection<Department> getAllDepartment(){
        return departmentMap.values();
    }
//    根据部门id获取部门信息
    public Department getDepartmentById(Integer id){
        return departmentMap.get(id);
    }
}
