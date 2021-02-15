package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String Hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http에서 header와 body영역에 있는 body에 아래 내용을 직접 입력
    public String helloString(@RequestParam("name") String name){
            return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    //@ResponseBody 어노테이션이 붙어 있을 경우, 입력 받은 내용 그대로 body로 넘김
    //근데 객체인 경우, 기본 default json방식으로 만들어서 반환하는게 기본 정책
    //위처럼 문자로 오면 StringConverter, 객체로 오게 되면 JsonConverter (json 변환은 Jackson 기본 라이브러리)
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }


    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}

