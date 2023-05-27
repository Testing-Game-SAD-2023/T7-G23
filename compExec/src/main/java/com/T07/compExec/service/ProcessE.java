package com.T07.compExec.service;

import com.T07.compExec.api.model.CompExecResults;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProcessE {

    public CompExecResults Process(String path_to_res) {
        CompExecResults res = new CompExecResults();

        try {
            String content = new String(Files.readAllBytes(Paths.get(path_to_res)));
            res.setResMessage(content);

            boolean notError = content.contains("T E S T S");

            if (notError) {
                res.setIdResult(0);
            } else {
                res.setIdResult(2);
            }

        } catch (IOException e) {
            System.err.println("errore nell'apertura del file");
        }

        return res;
    }
}
