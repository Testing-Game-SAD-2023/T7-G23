package com.T07.compExec.service;

import com.T07.compExec.api.model.CompExecResults;

import java.io.IOException;

public class Compiler {

    public CompExecResults Compile (String path) {

        CompExecResults compRes = new CompExecResults();

        try {
            // Command to execute
            String command = "cd " + path + ";mvn compile --log-file logcomp.txt";

            // Create the process builder
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("bash", "-c", command);

            // Start the process
            Process process = processBuilder.start();

            // Wait for the process to complete
            int exitCode = process.waitFor();

            ProcessC procC = new ProcessC();
            compRes = procC.Process(path+"logcomp.txt");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return compRes;
    }

}
