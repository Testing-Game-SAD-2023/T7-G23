package com.T07.compExec.service;

import com.T07.compExec.api.model.CompExecResults;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProcessC {

    public CompExecResults Process(String path_to_res) {
        CompExecResults res = new CompExecResults();

        try {
            String content = new String(Files.readAllBytes(Paths.get(path_to_res)));
            res.setResMessage(content);

            boolean error = content.contains("COMPILATION ERROR");

            if (error) {
                res.setIdResult(1);
            } else {
                res.setIdResult(0);
            }

        } catch (IOException e) {
            System.err.println("errore nell'apertura del file");
        }

        return res;
    }

}
