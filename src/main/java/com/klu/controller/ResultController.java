package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.klu.model.Result;
import com.klu.service.ResultService;

@RestController
@CrossOrigin("*")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @PostMapping("/saveResult")
    public Result saveResult(@RequestBody Result result) {
        return resultService.saveResult(result);
    }

    @GetMapping("/results/{email}")
    public List<Result> getResults(@PathVariable String email) {
        return resultService.getResults(email);
    }
}