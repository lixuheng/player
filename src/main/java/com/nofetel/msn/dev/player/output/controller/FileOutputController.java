package com.nofetel.msn.dev.player.output.controller;


import com.nofetel.msn.dev.player.output.service.FileOutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/play")
public class FileOutputController {

    @Autowired
    private FileOutputService fileOutputService;

    @GetMapping(value = "/mp4/{name}")
    public void chooseMp4(@PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response){
        OutputStream content = null;
        response.setHeader("Content-Type", "video/mp4");
        try {
            content= response.getOutputStream();
            fileOutputService.output(name,0L, 102400L, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
