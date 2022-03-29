package com.sliu.springboot03manasys.controller;

import com.sliu.springboot03manasys.dao.departmentDao;
import com.sliu.springboot03manasys.dao.employeeDao;
import com.sliu.springboot03manasys.pojo.Department;
import com.sliu.springboot03manasys.pojo.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    employeeDao employeedao;

    @Autowired
    departmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeedao.getAllEmployee();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
//        查出所有部门信息
        Collection<Department> departments = departmentDao.getAllDepartment();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
//        添加员工操作
        System.out.println("save==>"+employee);
//        调用底层业务添加员工信息
        employeedao.add(employee);
        return "redirect:/emps";
    }

//    转到员工修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id, Model model){
//        查出原始数据
        Employee employee = employeedao.getEmployeeById(id);
        model.addAttribute("emp", employee);
//        查出所有部门信息
        Collection<Department> departments = departmentDao.getAllDepartment();
        model.addAttribute("departments", departments);
        return "emp/update";
    }

//    员工信息修改
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeedao.add(employee);
        return "redirect:/emps";
    }

//    删除员工信息
    @GetMapping ("/deleEmp/{id}")
    public String deleEmp(@PathVariable("id")int id){
        employeedao.deleteEmp(id);
        return "redirect:/emps";
    }
}
