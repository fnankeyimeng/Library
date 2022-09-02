package com.neu.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
@Controller
@RequestMapping(value="upload")
public class UploadController {
    @RequestMapping(value="/upload")
    @ResponseBody
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        //定义文件名
        String fileName="";
        if(!file.isEmpty()){
            //获取文件名
            fileName =file.getOriginalFilename();
            //获取跟目录的路径
            String path=request.getServletContext().getRealPath("/image");
            //将文件名和绝对路径拼起来
            File filePath=new File(path,fileName);
            file.transferTo(filePath);

        }
        return fileName;
    }
}
