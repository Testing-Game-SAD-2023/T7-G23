# Module to compile and execute Java test cases
Within this repository we implement a software module which takes care of compiling and executing Java test cases. The module should be included in an educational game that will aim to teach testing to players according to the ENACTEST project (European iNnovation AllianCe for TESting educaTion). The project was carried out in collaboration with Antonio Russo e Francescopaolo Lecce.  
The repository, in addition to all the code, contains complete documentation in Italian with also descriptive diagrams of the software.

### Technologies used
The module is build using Java with different framework:
- OpenJDK (17)
- Maven (3.8.3)
- Junit (4 or 5)
- Jacoco (0.8.6)
- Spring Boot (3.1.0) - Spring Web

### Future 
In the future, effective and detailed error handling could be implemented, which at the moment it is handled by Tomcat by default. Furthermore, the response to the requests, in addition to the path of the Jacoco results, could also directly give the percentage of code's coverage.  
Finally, I am thinking about translating the whole documentation in english to make it accesible to more people.

## What do you need to run the module? How to run the module?
The module was isolated in a docker container, so you only need a docker installation to run it.  
To run the module you just need to download the repository, position with the terminal in the repository folder and run the command:
```
docker build . -t -name-
```
you may want to replace *-name-* with a name of your choice. Then you have to run the following command to run che module:
```
docker run -p XXXX:8080 -v /FileSystem/:/FileSystem/ -name-
```
you may want to replace *XXXX* with the port you want the module to run on and *-name-* with the name you chose before.  
All the module's results are gonna be placed in the folder *FileSystem* (which you downloaded with the repository). Alternatively you can place the filesystem folder in any position on your PC, the important thing is to insert that path in the command to run the containter (the string before the colon after -v).

## Module interface
We implemented REST API using the Spring Boot framework. Below is the endpoint provided to request compilation and test execution by providing class to test and test class. The results regarding the coverage must be retrieved by the caller to the path relating to the *FileSystem* folder provided when the container has been executed.

~/compexec -> Retrieve the classes from the local filesystem and then compile and run the tests    
**GET**  
**params:** *String* ClassName, *String* StudentLogin, *String* GameId  
**response:** *json* {"idResult" : int, "resMessage" : String, "pathCoverage" : String}  
**description:** Requires test cases to be compiled and executed by passing the parameters to retrieve the classes from the shared filesystem.  
**example:** http://localhost:8080/compexec?ClassName=AUTCalcolatrice&StudentLogin=1234&GameId=1  

~/compexecurl -> Retrieve the classes from the ulrs and then compile and run the tests    
**POST**  
**params:** *String* ClassName, *String* StudentLogin, *String* GameId  
**body:** *json* {"urlClass" : String, "urlTestClass" : String}  
**response:** *json* {"idResult" : int, "resMessage" : String, "pathCoverage" : String}  
**description:** Requires test cases to be compiled and executed by passing the URLs to retrieve and save the classes into the filesystem.  
**example:** http://localhost:8080/compexecurl?ClassName=AUTCalcolatrice&StudentLogin=1234&GameId=1 + body  
