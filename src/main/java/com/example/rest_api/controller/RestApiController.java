package com.example.rest_api.controller;import com.example.rest_api.model.BookQueryparam;import com.fasterxml.jackson.annotation.JsonIgnoreProperties;import com.fasterxml.jackson.databind.annotation.JsonNaming;import org.springframework.web.bind.annotation.*;@RestController // RestApi를 처리하는 컨트롤러@RequestMapping("/api") // api로 시작되는 주소는 여기로 받겠다public class RestApiController {    @GetMapping(path = "/hello") // URI/api/hello 라는 주소    public String hello() {        var html = "<html> <body> <h1>hello spring boot</h1> </body></html>"; //html 태그를 보내서 사용할수 있다.        return html;    }    //http://localhost:8080/api/echo/message    @GetMapping(path= "/echo/{message}/age/{age}/isman/{isman}")    public String echo(            @PathVariable(name = "message") String msg,            @PathVariable int age,            @PathVariable boolean isman            ){        System.out.println("echo message : "+ msg);        System.out.println("echo age : "+ age);        System.out.println("echo isman : "+ isman);        return msg;    }    // http://localhost:8080/api/echo/{message}/age/{age}/isman/{isman}    @GetMapping(path = "/book")    public void queryParam(            @RequestParam String category,            @RequestParam String issuedYear,            @RequestParam(name = "issued-month") String issuedMonth,            @RequestParam String issued_day    ){        System.out.println(category);        System.out.println(issuedYear);        System.out.println(issuedMonth);        System.out.println(issued_day);    }    // http://localhost:8080/api/book?category=IT&issuedYear=2023&issuedmonth=01&issueday=31    @GetMapping(path = "/book2")    public void queryParam2(BookQueryparam bookQueryparam){        System.out.println(bookQueryparam);    }    //TODO 파라미터를 2가지 받는다. int 형태로 받아서 두 수의 덧셈, 곱셈을 리턴하는 URI    //TODO String 타입 boolean타입으로 받아보기    @GetMapping(path = "/book3")    public int queryParam3(            @RequestParam int num1,            @RequestParam int num2    ){        System.out.println(num1);        System.out.println(num2);        return num1+num2;    }}