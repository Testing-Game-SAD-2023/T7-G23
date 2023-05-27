package com.T07.compExec.service;

import com.T07.compExec.api.model.CompExecResults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Manager {

    final private String pathMVNProject = "D:/IntelliJ/Projects/project_under_test/";
    final private String pathMVNProject_class = "D:/IntelliJ/Projects/project_under_test/src/main/java/pacchetto/";
    final private String pathMVNProject_testclass = "D:/IntelliJ/Projects/project_under_test/src/test/java/pacchetto/";

    public CompExecResults doCompExec(String pathClass, String pathTestClassth) {

        CompExecResults res = new CompExecResults(0, pathClass+pathTestClassth);

        return res;
    }

    public CompExecResults CompileRun(String url_classe, String url_classetest) {

        try {

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseClass = restTemplate.getForEntity(url_classe, String.class);
            ResponseEntity<String> responseTestClass = restTemplate.getForEntity(url_classetest, String.class);

            if (responseClass.getStatusCode() != HttpStatus.OK || responseTestClass.getStatusCode() != HttpStatus.OK) {
                throw new IOException("Classe o Classe di test non trovata");
            }

            String bodyClass = responseClass.getBody();
            String bodyTestClass = responseTestClass.getBody();

            File fileClass = new File(pathMVNProject_class+ "classe.java");
            File fileTestClass = new File(pathMVNProject_testclass+ "testclass.java");

            FileWriter myWriter_class = new FileWriter(fileClass);
            myWriter_class.write(bodyClass);
            myWriter_class.close();
            FileWriter myWriter_testclass = new FileWriter(fileTestClass);
            myWriter_testclass.write(bodyTestClass);
            myWriter_testclass.close();

        } catch (IOException e) {
            System.err.println("errore:" + e.getMessage());
        }

        //chiamo il compilatore
        CompExecResults compRes = Compile(pathMVNProject);
        if (compRes.getIdResult() == 0) {
            CompExecResults exRes = RunTests(pathMVNProject);
            return exRes;
        } else {
            return compRes;
        }
    }

    private CompExecResults Compile(String pathMVNProject) {
        Compiler c = new Compiler();
        CompExecResults compRes = c.Compile(pathMVNProject);
        return compRes;
    }

    private CompExecResults RunTests(String pathMVNProject) {
        TestRunner t = new TestRunner();
        CompExecResults exRes = t.RunTest(pathMVNProject);
        return exRes;
    }

}
