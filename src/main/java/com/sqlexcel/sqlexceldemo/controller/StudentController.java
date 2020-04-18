package com.sqlexcel.sqlexceldemo.controller;


import com.alibaba.excel.EasyExcel;
import com.sqlexcel.sqlexceldemo.entity.Student;
import com.sqlexcel.sqlexceldemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    /**
     * 获取所有学生列表
     * */
    @GetMapping(value = "/getinfo")
    public List<Student> getAllStudentInfo(){

//        Iterable iterable = studentRepository.findAll();
//        Iterator iterator = iterable.iterator();
//        List<Student> students = new ArrayList<Student>();
//        while(iterator.hasNext()){
//            students.add((Student) iterator.next());
//        }
//
//        return students;
        return studentRepository.findAll();

    }
    @GetMapping(value = "/getbyidTest")
    public Optional<Student> testfindByid(){
        return studentRepository.findById(1);
    }

    @RequestMapping("/studownload")
    public void SimpleDownload(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        String fileName = URLEncoder.encode("测试"+System.currentTimeMillis(), "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Student.class).sheet("模板").doWrite(studentRepository.findAll());
    }

}
