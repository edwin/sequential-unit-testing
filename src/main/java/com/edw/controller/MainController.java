package com.edw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     com.edw.controller.MainController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 29 Nov 2021 14:13
 */
@RestController
public class MainController {

    @GetMapping("/")
    public Map get() {
        return new HashMap() {{
            put("Get", "World");
        }};
    }

    @PostMapping("/")
    public Map post() {
        return new HashMap() {{
            put("Post", "Hello World");
        }};
    }

    @PutMapping("/")
    public Map put() {
        return new HashMap() {{
            put("Put", "Hello World");
        }};
    }

}
