package com.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

import com.klu.model.Result;
import com.klu.repository.ResultRepository;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepo;

    public Result saveResult(Result result) {
        result.setDate(LocalDateTime.now());
        return resultRepo.save(result);
    }

    public List<Result> getResults(String email) {
        return resultRepo.findByEmail(email);
    }
}