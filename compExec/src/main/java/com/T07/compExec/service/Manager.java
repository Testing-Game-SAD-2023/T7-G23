package com.T07.compExec.service;

import com.T07.compExec.api.model.CompExecResults;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Manager {

    private final String pathMVNProject = "/projectUT/";
    private final String pathMVNProject_class = "/projectUT/src/main/java/TestPackage/";
    private final String pathMVNProject_testclass = "/projectUT/src/test/java/TestPackage/";

    public CompExecResults CompileRun(String urlClasse, String urlClassetest) {

        // codice giusto per recuperare file da server e metterlo in una cartella

        try {

            if (urlClasse.contains("http://") || urlClasse.contains("https://")) {

                InputStream inClass = new URL(urlClasse).openStream();
                String filenameClass = Paths.get(new URI(urlClasse).getPath()).getFileName().toString();
                Files.copy(inClass, Paths.get(pathMVNProject_class+filenameClass), StandardCopyOption.REPLACE_EXISTING);

                InputStream inTestClass = new URL(urlClassetest).openStream();
                String filenameTestClass = Paths.get(new URI(urlClassetest).getPath()).getFileName().toString();
                Files.copy(inTestClass, Paths.get(pathMVNProject_testclass+filenameTestClass), StandardCopyOption.REPLACE_EXISTING);

            } else {

                Path sourceClass = Paths.get(urlClasse);
                String filenameClass = Paths.get(new URI(urlClasse).getPath()).getFileName().toString();
                Files.copy(sourceClass, Paths.get(pathMVNProject_class+filenameClass), StandardCopyOption.REPLACE_EXISTING);

                Path sourceTestClass = Paths.get(urlClassetest);
                String filenameTestClass = Paths.get(new URI(urlClassetest).getPath()).getFileName().toString();
                Files.copy(sourceTestClass, Paths.get(pathMVNProject_testclass+filenameTestClass), StandardCopyOption.REPLACE_EXISTING);

            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
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
        exRes.setPathCoverage(pathMVNProject+"target/site/jacoco/");
        return exRes;
    }

}
