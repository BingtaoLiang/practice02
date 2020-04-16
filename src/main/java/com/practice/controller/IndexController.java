package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "top";
    }

    @GetMapping("/top")
    public String top() {
        return "top";
    }

    @GetMapping("/zixun")
    public String zixun() {
        return "zixun";
    }

    @GetMapping("/xingaokao")
    public String xingaokao() {
        return "xingaokao";
    }

    @GetMapping("/ceshi")
    public String ceshi() {
        return "ceshi";
    }

    @GetMapping("/jiangtang")
    public String jiangtang() {
        return "jiangtang";
    }

    @GetMapping("/ketang")
    public String ketang() {
        return "ketang";
    }

    @GetMapping("/fuwu")
    public String fuwu() {
        return "fuwu";
    }

    @GetMapping("/zixunshi")
    public String zixunshi() {
        return "zixunshi";
    }

    @GetMapping("/xuanke")
    public String xuanke() {
        return "xuanke";
    }

    @GetMapping("/xuanke2")
    public String xuanke2() {
        return "xuanke2";
    }

    @GetMapping("/chaxun")
    public String chaxun() {
        return "chaxun";
    }

    @GetMapping("/zhaozhuanye")
    public String zhaozhuanye() {
        return "zhaozhuanye";
    }

    @GetMapping("/zhaodaxue")
    public String zhaodaxue() {
        return "zhaodaxue";
    }

    @GetMapping("/weici")
    public String weici() {
        return "weici";
    }

    @GetMapping("/fenshuxian")
    public String fenshuxian() {
        return "fenshuxian";
    }

    @GetMapping("/picixian")
    public String picixian() {
        return "picixian";
    }

    @GetMapping("/yijiantianbao")
    public String yijiantianbao() {
        return "yijiantianbao";
    }

    @GetMapping("/1dui1")
    public String oneToone(){
        return "1dui1";
    }

    @GetMapping("/kaoshi")
    public String kaoshi(){
        return "kaoshi";
    }

    @GetMapping("/subject")
    public String subject(){
        return "subject";
    }
}
