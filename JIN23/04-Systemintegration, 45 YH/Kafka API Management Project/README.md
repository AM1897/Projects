# Kafka API Management Project

This project is a continuation of Project 1 and provides functionalities to interact with a web API that manages users via Kafka.

## Prerequisites

- Project 1 must be up and running for Project 2 to function correctly.
- Java 19 (based on the maven settings)
- Apache Maven

## Installation
1. Klona projektet till ditt lokala system:
2. https://github.com/AM1897/RootProject
3. Bygg projektet med Maven:
4. `mvn clean install`


## Features

Here are some of the key features of the project:

1. **Create a New User**: Users can create a new user by providing the user's ID, first name, and last name.
2. **Update an Existing User**: Users can update the information of an existing user.
3. **Delete a User**: Users can delete a user based on their ID.
4. **View a User's Information**: Users can view the details of a specific user based on their ID.

## How to Run the Program

1. Ensure all dependencies specified in `pom.xml` are available.
2. Compile and run the `Main` class.

## Dependencies

Here are some of the main dependencies the project utilizes:

- **Spring Kafka**: For managing Kafka-related functionalities.
- **Apache Kafka Clients**: For interacting with Kafka.
- **HttpComponents HttpClient**: For sending HTTP requests.
- **JSON-simple**: For handling JSON payloads.

## Key Files

- **WebAPIManager**: Manages the interaction with the web API.
- **Menu**: User interface to interact with the program.
- **Main**: Contains the `main` method and serves as the entry point of the program.

## Testing

Run the tests using Maven:

For testing purposes, the project uses JUnit 5 (`junit-jupiter-api` version 5.10.0).

## Contributions

All contributions are appreciated. Submit a pull request on GitHub. See `CONTRIBUTING.md` for more details.

## License

Licensed under the MIT license. See `LICENSE` for more details.
