# poc-api

### a. chosen language
Java

### b. how we can run your code

### Installing
* Clone this repository: git clone git@bitbucket.org:neeleshchavan/anagramassignment.git

### intellij IDEA ###
* Open the project in intellij IDEA and clean and build the project

### Command Line - Building & Running project using gradle wrapper - https://spring.io/guides/gs/gradle/
- Install Gradle if not already installed - brew install gradle
- Build your project with Gradle Wrapper
- gradle wrapper --gradle-version 6.7
- ./gradlew build
- ./gradlew run

### Notes ###
* App is only for Demo purpose and it contains hard coded tests data as specified in the problem statement
* App if run will only show result for the product 001, 002 & 003.
* Please check CheckoutTest for all the test scenarios mentioned in the test file
* To test any other test scenario will need to add test within CheckoutTest

### assumptions ###
* Total price has default currency added as '£'

### Thinking behind decisions ###
* ProductDiscounts will be applied first - we can add more products discounts to the PromotionalRules.run.
* CartDiscounts will be applied at the end on the total price. We can even add more discount rules to the Cart.
* Single responsibility principal - Classes are following single responsibility principal
* Separate interfaces for Products and Cart so they can be extended further.
* Open Closed Principal - Open for extension we can add more products by creating new classes and extending it but we will not modify the previous classes.
* Cart has a id added as every order will have a new card id and within production we can use cardId to check the transactions for card and also for troubleshooting purpose

### c. Big O analysis ###
* products (n) - O(n)
* products promotions (m) - O(m)
* card discounts (o) - O(o)

### d. reasons behind data structures chosen ###
Set - sets do not allow duplicate values - productDiscounts will not have duplicate values so we will not have same product promotions
HashMap - As the insertion and access is O(1)
