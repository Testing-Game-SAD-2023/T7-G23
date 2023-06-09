# SAD-Project-T7 G23

# Introduction

Within this repository we implement a software module which takes care of compiling and executing Java test cases. The module should be included in an educational game that will aim to teach testing to players according to the ENACTEST project (European iNnovation AllianCe for TESting educaTion).

# Module Design

## Diagrams

To clarify the responsibilities and the architecture of our software, we made some diagrams.

### Sequence Diagram 

Our module plans to carry out compilation and execution in sequence. Below is the sequence diagram describing the function calls of CompileAndRunTests.

<p align="center" width="100%">
<img src="https://github.com/Testing-Game-SAD-2023/T7-G23/blob/main/ds_CompileAndRunTests.png" width="100%">
</p>

### Component Diagram

We decided to use a layered architecture for our software module, below is the component diagram.

<p align="center" width="100%">
<img src="https://github.com/Testing-Game-SAD-2023/T7-G23/blob/main/dc_Component%20Diagram.png" width="100%">
</p>

## Technologies

- OpenJDK (17)
- Maven (3.8.3)
- Junit (4 or 5)
- Jacoco (0.8.6)
- Spring Boot (3.1.0) - Spring Web

## Interface

We implemented REST API using the Spring Boot framework, with Spring Web as dependency. Below is the endpoint provided to request compilation and test execution by providing class to test and test class.

~/CompExec  
**GET**  
**params:** *String* urlClassUT, *String* urlTestClass  
**response:** *json* {"idResult" : int, "resMessage" : String, "pathCoverage" : String}  
**description:** Requires test cases to be compiled and executed by passing the url of the class to be tested and the url of the test class.  
**example:** http://localhost:8080/compexec?urlClass=urltoclass&urlTestClass=urltotestclass
