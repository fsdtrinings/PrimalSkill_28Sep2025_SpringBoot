
  
  ------------------------------------------------------------------
  
  What is SonarQube and how it works
  
  1) go to sonar folder inside drive and startsonar.bat
  2) open URL  localhost:9000
  3) Create new local project
  		provide valid project name
  		leave other things as it is 
		use global settings & click on create project locally 
  
  5) Now generate token 
  
  after generating the token run below commands on maven in ur STS
  
  ---------------------------------------------------------------
  
  before running commands check POM.xml
  
  1) added the plugin of jacoco & Sonar 
  2) added properties of sonar server
  
  Sonar Qube Commands 

#Step -1
for starting jacoco 

clean org.jacoco:jacoco-maven-plugin:prepare-agent install

#Step-2
it runs the Sonar Scan process
clean install sonar:sonar -Dsonar.login=sqp_f1e7f9af7e48d2e9f9f2db311ee02e1a98e249e3





Maven command from Sonar browser  

mvn clean verify sonar:sonar \
  -Dsonar.projectKey=InfoEdge_UT_Demo \
  -Dsonar.projectName='InfoEdge_UT_Demo' \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.token=sqp_f1e7f9af7e48d2e9f9f2db311ee02e1a98e249e3
  
  		
  	