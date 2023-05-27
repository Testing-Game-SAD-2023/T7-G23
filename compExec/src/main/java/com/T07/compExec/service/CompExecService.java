package com.T07.compExec.service;

import com.T07.compExec.api.model.CompExecResults;
import org.springframework.stereotype.Service;

@Service
public class CompExecService {

    private CompExecResults res;

    public CompExecResults getCompExecResults (String pathClass, String pathTestClass) {
        Manager m = new Manager();

        CompExecResults res = m.CompileRun(pathClass, pathTestClass);

        return res;
    }

}
