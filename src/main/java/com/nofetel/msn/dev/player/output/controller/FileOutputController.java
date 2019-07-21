package com.nofetel.msn.dev.player.output.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/play")
public class FileOutputController {

    @GetMapping(value = "/mp4/{name}")
    public void chooseMp4(@PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response){
        System.out.println(name);
    }

}
