#Sky Product Selection

This is a maven project that uses Spark to handle HTTP requests. It has been developed using techniques like TDD, BDD and SOLID principles

## How to run application
- The main class is located at **com.sky.Application**
- Run this file from your IDE
- Visit [http://localhost:4567/products](http://localhost:4567/products)

## How to run acceptance test
- Make sure the application is running
- Copy the **chromedriver** file to an Absolute path of your choice *i.e. (/Applications/chromedriver) for Mac users*
- Update your file path in **ProductSelectionPageAcceptanceTest** to match the location of Absolute path of the **chromedriver** if required
- Run the test and watch selenium test the webpage