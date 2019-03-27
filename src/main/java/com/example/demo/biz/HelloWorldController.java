package com.example.demo.biz;

import com.alibaba.fastjson.JSON;
import com.example.demo.vo.HelloWorldVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("hello")
public class HelloWorldController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @GetMapping("/handle/{name}")
    @ResponseBody
    public Flux<HelloWorldVO> handle(@PathVariable String name) {
        log.info("HelloWorldController.handle start. name:{}", name);
        HelloWorldVO helloWorldVO = new HelloWorldVO();
        helloWorldVO.setName(name);
        helloWorldVO.setCreated(new Date());

        List<HelloWorldVO> helloWorldVOList = new ArrayList<>();
        helloWorldVOList.add(helloWorldVO);
        log.info("HelloWorldController.handle start. helloWorldVOList:{}", JSON.toJSONString(helloWorldVOList));
        return Flux.fromIterable(helloWorldVOList);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody HelloWorldVO helloWorldVO) {
        // ...
    }
}
