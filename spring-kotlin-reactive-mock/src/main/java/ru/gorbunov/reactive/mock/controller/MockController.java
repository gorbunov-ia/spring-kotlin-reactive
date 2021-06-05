package ru.gorbunov.reactive.mock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class MockController {

    @GetMapping("test")
    public String getTest(@RequestParam Integer delay) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(delay);
        return UUID.randomUUID().toString();
    }

}
