# westWing
This is an Maven Project which would run on Windows machines as I have used ChromeDriver for Windows in config file.
Framwork used is  Page Object model .
System requirements:

JDK 1.8 
Windows OS
ChromeBrowser Version 91.0.4472.77


To execute test cases from command line:

mvn clean test -DsuiteXMLFile=searchTestNG.xml


Project Structure:

src/main/java/com/Utility/base :It contains TestBase.java and WrapperFunctions.java

westWingTestProj\src\test\java\com\westwing\configs :It contains ChromeDriver.exe and config.properties

westWingTestProj\src\test\java\com\westwing\testcases :It contains one test case
src\test\resources\searchTestNG.xml :It is the TestNG 

Output will be default TestNG report.
