* First of all, To change the browser which will be executed the automation project, you need to save your browser drivers on the path: --> C://chromedriver.exe o C://geckodriver.exe. If you want to change the path, you need to go to "serenity.properties" file located on the automation project, In that file, there are the variables to change it.
* Yo have to install Maven with its JDK version 8 on the computer to be able to execute the project.
* To execute the project, you need to open CMD or propmt, go to the path which contains the automation project and write the following sentence: mvn clean verify.
* After the execution, when it's completed all the steps and it's passed you can get the report file to see, in a better way, the screenshots and the steps which were executed. To get that report you need to go to the automation project and open the this path:target\site\serenity and open the file:"index.html".
* In the folder:  src/test/resources/features/Flights.features you can get the scenario which contains all the requerimients of the assessment
* The projetc was made with Mavenm Serenity BDD, cucumber and page object pattern. El proyecto se hizo con MAVEN, serenity BDD, cucumber y page object pattern.


