package com.T07.compExec.api.controller;

import com.T07.compExec.api.model.CompExecResults;
import com.T07.compExec.service.CompExecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompExecController {

    private CompExecService compExecService;

    @Autowired
    public CompExecController (CompExecService compExecService) {
        this.compExecService = compExecService;
    }

    @GetMapping("/compexec")
    public CompExecResults getCompExec(@RequestParam String pathClass, @RequestParam String pathTestClass) {
        return compExecService.getCompExecResults(pathClass, pathTestClass);
    }
}
