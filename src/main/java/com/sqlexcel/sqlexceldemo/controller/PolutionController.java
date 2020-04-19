package com.sqlexcel.sqlexceldemo.controller;


import com.alibaba.excel.EasyExcel;
import com.sqlexcel.sqlexceldemo.entity.Gas;
import com.sqlexcel.sqlexceldemo.entity.GasContam;
import com.sqlexcel.sqlexceldemo.entity.GasJoinContam;
import com.sqlexcel.sqlexceldemo.repository.GasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class PolutionController {
    @Autowired
    private GasRepository gasRepository;
    /**
     * 获取所有学生列表
     *
     * @return*/
    @GetMapping(value = "/gasinfo")
    public List<List> getAllGasInfo(){

//        Iterable iterable = studentRepository.findAll();
//        Iterator iterator = iterable.iterator();
//        List<Student> students = new ArrayList<Student>();
//        while(iterator.hasNext()){
//            students.add((Student) iterator.next());
//        }
//
//        return students;

        return gasRepository.selectGas();
        /*
        for(Map<String,Object> m:list){
            for(Object s:m.keySet()){
                System.out.println(s);
            }
            break;
        }
        return  list;
        */
    }
    //读取head头信息
//    private List<List<String>> head(List<Map<String, Object>> resultlist) {
//        List<List<String>> list = new ArrayList<List<String>>();
//
//        for (Map<String, Object> m : resultlist) {
//            for (String s : m.keySet()) {
//                List<String> head0 = new ArrayList<String>();
//                head0.add(s);
//                list.add(head0);
//            }
//            break;
//        }
//        return list;
//    }

    @RequestMapping("/polutiondownload")
    public void SimpleDownload(HttpServletResponse response) throws IOException {


        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        String fileName = URLEncoder.encode("测试"+System.currentTimeMillis(), "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");


        EasyExcel.write(response.getOutputStream(),GasJoinContam.class).sheet(fileName).doWrite(gasRepository.selectGas());
    }

}
