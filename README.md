# poc-api

# README #

This README would normally document whatever steps are necessary to get your application up and running.

### a. chosen language
Java

### b. how we can run your code

### Installing

* Clone this repository: git clone git@bitbucket.org:neeleshchavan/anagramassignment.git

* IDE *cl
* Open the project in intellij IDEA and clean and build the project clicking Gradle on the right side and then build/build

### Command Line - Building & Running
Building project with gradle wrapper - https://spring.io/guides/gs/gradle/

- cd anagramassignment

- Install Gradle - brew install gradle

Build your project with Gradle Wrapper

- gradle wrapper --gradle-version 6.7

- ./gradlew build

- ./gradlew run

Provide any production filepath as argument and it should run against that file.

- ./gradlew run --args="prod/example.txt"

### c. Big O analysis ###

* Sorting using javas Arrays.sort which is using Quicksort algorithm offers O(n log(n)) to sort the string. So if we have m numbers of Strings then the big O
analysis will be => m *  O(n log(n)) => m*nlog(n)
* We will have to read the file and iterate over each an every element within the file so this iteration is O(n) where is the total number of elements in the file
* Using first HashMap as we will insert the sorted string as key and groups as values in the HashMap -> The reason for using hashmap is because the insertion O(1) and access is O(1).

* Space Complexity:
1. HashMap size O(n) and the List will have O(n-m) number of elements where m is the number of elements without groups.

### d. reasons behind data structures chosen ###
HashMap - As the insertion and access is O(1)

### e. what you would do given more time ###
- Static Code Analysis
- Checkstyles
- Integration tests with much vast amount of data files of different sizes
- We have a log messages for different error scenarios so will set the Cloud alerts based on the error scenarios. Examples: If banking application and receiving empty file
can mean some issue so will raise alerts based on the empty file and notify on Teams/Slack/PagerDuty about it.
- Currently we are throwing the Exceptions for different error scenarios. I would return the valid error messages and status code for different scenarios.
- Add Open API Swagger documentation when the endpoints or routes are created so when we run the app we could be able to view the documentation and see what the API is so that it can be consumed by other services or applications.example
- Spring boot has the actuator services where you can check the application is running and I would add actuator dependency


