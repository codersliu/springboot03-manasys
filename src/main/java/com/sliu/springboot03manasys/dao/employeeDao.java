package com.sliu.springboot03manasys.dao;

import com.sliu.springboot03manasys.pojo.Department;
import com.sliu.springboot03manasys.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class employeeDao {
//    模拟数据库员工信息表
    static Map<Integer, Employee> employeeMap = null;
    @Autowired
    private departmentDao departmentDao;
    static {
        employeeMap = new HashMap<>();
        employeeMap.put(1001, new Employee(1001, "jacksliu", "19689624@qq.com", 1, new Department(101, "教学部")));
        employeeMap.put(1002, new Employee(1002, "happy", "19689624@qq.com", 0, new Department(102, "生活部")));
        employeeMap.put(1003, new Employee(1003, "hodoow", "19689624@qq.com", 1, new Department(103, "财务部")));
        employeeMap.put(1004, new Employee(1004, "marry", "19689624@qq.com", 0, new Department(104, "后勤部")));
        employeeMap.put(1005, new Employee(1005, "candy", "19689624@qq.com", 1, new Department(105, "保卫部")));
    }

//    添加新员工信息
    private static Integer initId = 1006;
    public void add(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(), employee);
    }

//    获取全部员工信息
    public Collection<Employee> getAllEmployee(){
        return employeeMap.values();
    }

//    通过id获取员工信息
    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);
    }

//    通过id删除员工信息
    public void deleteEmp(Integer id){
        employeeMap.remove(id);
    }
}
