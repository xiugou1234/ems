package com.dai.springboot03web.controller;

import com.dai.springboot03web.dao.DepartmentDao;
import com.dai.springboot03web.dao.EmployeeDao;
import com.dai.springboot03web.pojo.Department;
import com.dai.springboot03web.pojo.Employee;
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
   DepartmentDao departmentDao;

    @Autowired
    EmployeeDao employeeDao;



    @RequestMapping("/emps")
    public String list(Model model){
      Collection<Employee> employees= employeeDao.getAllEmployees();
     model.addAttribute("empss",employees);
     return "emp/list";//返回到list页面
    }
    @GetMapping("/emp")
    public String Add(Model model) {
        //查出部门的所有信息

        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments", departments);
        return "emp/add";
    }
    @PostMapping("/add")
    public String addEmp(Employee employee) {
        employeeDao.addEmployee(employee);//添加一个员工
        return "redirect:/emps";//重定向到/emps,刷新列表,返回到list页面
    }
    //restful风格接收参数
    @RequestMapping("/update/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        //查询指定id的员工,添加到empByID中,用于前端接收
        Employee employeeByID = employeeDao.getEmployeeByID(id);
        model.addAttribute("empByID", employeeByID);
        //查出所有的部门信息,添加到departments中,用于前端接收
        Collection<Department> departments =departmentDao.getDepartment();
        model.addAttribute("departments", departments);
        return "/emp/update";//返回到编辑员工页面
    }
    @PostMapping("/update")
    public String EditEmp(Employee employee) {
        employeeDao.addEmployee(employee);//添加一个员工
        return "redirect:/emps";//添加完成重定向到/emps,刷新列表
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.deleteEmployeeByID(id);
        return "redirect:/emps";
    }





}








