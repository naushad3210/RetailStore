# RetailStore

Retails store is a module that calculates the net payble amount for agiven bill. It is responsible for calculating the applicable discounts on the items and then process the final bill amount.

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
3) Check the target folder for the generated war file named "RetailStore-0.0.1-SNAPSHOT.war"
4) Rename the file to RetailStore.war
5) Place the RetailStore.war file to tomcat/webapps  folder
6) Start Tomcat.
```

### APIs Details
```
To create user  
	endPoint: http://{host}:{port}/RetailStore/user  
	requestType: POST  
	headers: Content-Type:application/json  
	requestParameters: [userId: STRING, userName: STRING, userType: STRING of UserType]
```
```
To get user  
	endPoint: http://{host}:{port}/RetailStore/user/{userId}  
	requestType: GET  
	headers: Content-Type:application/json  
	queryParameters: [userId: STRING]  
```
```
Generate Bill  
	endPoint: http://{host}:{port}/RetailStore/bill  
	requestType: POST  
	headers: Content-Type:application/json  
	requestParameters: [userId: STRING, billAmount: DOUBLE, itemType: STRING of ItemType]  
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
        BillControllerTest, BillDaoTest, BillServiceTest, DiscountStrategyFactoryTest, UserControllerTest, UserDaoTest, UserServiceTest
  
## Coverage Report

```
1) Open command propmt. Then switch the directory to {localPath}/RetailStore. Please verify that the pom.xml is present in this directory.  
2) Issue command  
	mvn clean verify  
3) Readable code coverage reports for the execution of the above test cases is generated in several formats – e.g. HTML, CSV, and XML. in the directory "{}\RetailStore\target\site\jacoco"  
4) The binary format in the target directory – target/jacoco.exec. can also be sent to Sonar Qube for generating the coverage report.
```

## Sonar Analysis
For SonarQuabe analysis, SonarQube should be accessible(installed)
```
1) Set the attributes in the pom.xml  
	<sonar.jacoco.reportPaths> - path to dir where jacoco.exec is saved.
	<sonar.host.url> - url where SonarQube is running.

2) On command prompt, issue the following command from the project base directory  
	mvn clean install sonar:sonar  
   this command will run the tests, build the war file and trigger the sonar analysis.
```

