# Spring Boot Excel Upload Project

This Spring Boot project demonstrates how to upload an Excel sheet containing student details and store them in an in-memory database. It provides a simple API endpoint to upload the Excel file and process the data.

## Prerequisites

Before running the application, make sure you have the following installed:

- Java Development Kit (JDK) 11 or higher
- Maven

## Getting Started

1. Clone the repository to your local machine:

```bash
git clone [<repository-url>](https://github.com/maheshchary14/excel-project-springboot)

Navigate to the project directory: cd spring-boot-excel-upload
Build the project using Maven: mvn clean install
Run the Spring Boot application: mvn spring-boot:run

The application will start on http://localhost:8080
The inmemory database is on http://localhost:8080/h2-console

Uploading an Excel Sheet
Verb = POST
URI = /api/upload

Sample Excel Data
Here's a sample structure of the Excel sheet:

Student ID	Name	Age	Grade
1	John Doe	20	A
2	Jane Smith	21	B
Please ensure that the Excel sheet follows this structure for successful processing.

Technologies Used
Spring Boot
Apache POI for Excel processing
Thymeleaf for HTML templating
H2 Database (in-memory) for storing student details
Contributing
Contributions are welcome! Feel free to open an issue or submit a pull request for any improvements or new features you'd like to see.
