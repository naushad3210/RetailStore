# RetailStore

Retails store is a module that calculates the net payble amount for a given bill. It is responsible for calculating the applicable discount on the items and then calculate the final bill amount.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

```
1) Maven should be installed.
2) SonarQube should be installed for code quality analysis.
3) Apache Tomcat is required to deploy the project.
```

### Installing

Script to Build Project:
```
1) Open command propmt, then switch to directory {dir}/RetailStore. Please verify that the pom.xml is present in this directory.
2) Run the command "mvn clean install"
3) Check the target folder for the generated war file named "RetailStore.war"
4) Place the RetailStore.war file to tomcat/webapps  folder
5) Start Tomcat.
```

### APIs Details
```
Generate Bill  
	endPoint: http://{host}:{port}/RetailStore/bill  
	requestType: POST  
	headers: Content-Type:application/json  
	requestBody: [userId: STRING, billAmount: DOUBLE, itemType: STRING of ItemType,userType: STRING of UserType]  
```

## Running Test Cases

```
1) Open command propmt. Then switch the directory to {localPath}/RetailStore. Please verify that the pom.xml is present in this directory.  
2) To run the entire unit test, issue this command :  
	mvn test  
3) To run single test (eg. TestClassName), issue this command :  
	mvn -Dtest=TestClassName test  
 ```
 
All the test classes in the application are:  
BillControllerTest, BillDaoTest, BillServiceTest, DiscountStrategyFactoryTest
  
## Code Coverage Report  
This section explains how the code coverage report can be generated using JaCoCo plugin.

```
1) Open command propmt. Then switch the directory to {localPath}/RetailStore. Please verify that the pom.xml is present in this directory.  
2) Issue command  
	mvn clean verify  
3) Readable code coverage reports for the execution of the above test cases is generated in several formats – e.g. HTML, CSV, and XML. in the directory "{}\RetailStore\target\site\jacoco"  
4) The binary format in the target directory – target/jacoco.exec. can also be sent to Sonar Qube for generating the coverage report.
```

## SonarQube Analysis
This section explains how the code quality analysis report can be generated using SonarQube. For SonarQuabe analysis, SonarQube should be accessible(installed)
```
1) Set the attributes in the pom.xml  
	<sonar.jacoco.reportPaths> - path to dir where jacoco.exec is saved.
	<sonar.host.url> - url where SonarQube is running.

2) On command prompt, issue the following command from the project base directory  
	mvn clean install sonar:sonar  
   this command will run the tests, build the war file and trigger the sonar analysis.
3) Quality report can be viewed by accessing the <sonar.host.url>
```

