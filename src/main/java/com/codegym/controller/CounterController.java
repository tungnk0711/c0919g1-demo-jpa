package com.codegym.controller;

import com.codegym.model.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("mycounter")
public class CounterController {

    /* add MyCounter in model attribute */
    @ModelAttribute("mycounter")
    public MyCounter setUpCounter() {
        return new MyCounter();
    }

    @GetMapping("/count")
    public String get(@ModelAttribute("mycounter") MyCounter myCounter, HttpSession httpSession) {

        httpSession.setAttribute("name", "Hoang Nam Khanh");
        httpSession.setAttribute("age", 20);

        myCounter.increment();
        return "/count/index";
    }
}
