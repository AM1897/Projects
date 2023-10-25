[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/MYVtI0hB)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=11363233)
# Project name
Todo-List

## Description


Provide a short description explaining the what, why, and how of your project. Use the following questions as a guide:

- What was your motivation?
  The motivation behind the project was that it is an interesting and useful project that can be applied in many other contexts. By implementing CRUD functionality for a todo list, as well as a registration and login feature, I wanted to create a useful and dynamic solution. The use of a MongoDB database helps manage data storage efficiently and provides flexibility in handling users and their todo lists. The project also gives me the opportunity to enhance my skills in these areas and explore new ways to implement functionality and manage data.
- Why did you build this project?
  The project was built to create a usable and scalable solution for handling CRUD operations and user management. The goal was to create a todo list with functionalities for creating, reading, updating, and deleting tasks, while also enabling registration and login for users. By building this project, I wanted to establish a basic structure and functionality that can be reused and adapted for various types of projects requiring similar functionality. It provides the opportunity to efficiently manage data, interact with users, and establish a solid foundation for future development.
- What problem does it solve?
The project is designed to provide a basic backend solution that can be used as a foundation for building web applications. By implementing CRUD functionality for a todo list and user management, the project offers a robust backend structure that can be integrated with various frontend technologies and used to solve different problems.c
- What did you learn?
  During this short period, I have learned a lot by building this entire backend solution. Being able to create and implement CRUD functionality for todo lists and user management has been a rewarding experience. Now, with the functional backend in place, I have the opportunity to connect it to a frontend and create a complete application.

## Table of Contents (Optional)

If your README is long, add a table of contents to make it easy for users to find what they need.

- [Installation](#installation)
- [Usage](#usage)
- [Credits](#credits)
- [License](#license)

## Installation
To install and run the program, follow these steps:

1. Clone the project from its GitHub repository to your local machine.
2. Ensure that you have the "pom.xml" file in the project's root directory. This is a Maven package description file that contains all the dependencies and build settings for the project.
3. Make sure you have JDK 20 installed on your machine. JDK stands for Java Development Kit and is required to compile and run Java programs.

## Usage

För att utföra testerna i projektet behöver du JUnit 5. Följ dessa steg för att inkludera JUnit 5 i ditt projekt:

Öppna din "pom.xml"-fil.

Leta efter <dependencies>-sektionen och se till att den är närvarande.
 Inuti <dependencies>, lägg till följande kod för att inkludera JUnit 5:
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>5.7.0</version>
      <scope>test</scope>
    </dependency>

Detta lägger till JUnit 5-biblioteket som en beroende för testning.

Spara och stäng "pom.xml"-filen.

Maven kommer nu att ladda ner och inkludera JUnit 5 när du bygger och kör testerna i ditt projekt.

Nu har du JUnit 5 installerat i ditt projekt och kan köra testerna. Se till att skriva dina testfall och testmetoder och kör dem för att verifiera att din kod fungerar som förväntat.

## Credits

List your collaborators, if any, with links to their GitHub profiles.
* [member 1](https://github.com/person1)
* [member 2](https://github.com/person1)

If you used any third-party assets that require attribution, list the creators with links to their primary web presence in this section.
* [junit jupiter 5](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter/5.7.0)

If you followed tutorials, include links to those here as well.

## License

The last section of a high-quality README file is the license. This lets other developers know what they can and cannot do with your project. If you need help choosing a license, refer to [MIT License](https://choosealicense.com/licenses/mit/).

---

🏆 The previous sections are the bare minimum, and your project will ultimately determine the content of this document. You might also want to consider adding the following sections.

## Badges

![badmath](https://img.shields.io/github/languages/top/lernantino/badmath)

Badges aren't necessary, per se, but they demonstrate street cred. Badges let other developers know that you know what you're doing. Check out the badges hosted by [shields.io](https://shields.io/). You may not understand what they all represent now, but you will in time.

## Features

If your project has a lot of features, list them here.

## How to Contribute

If you created an application or package and would like other developers to contribute it, you can include guidelines for how to do so. The [Contributor Covenant](https://www.contributor-covenant.org/) is an industry standard, but you can always write your own if you'd prefer.

## Tests

Go the extra mile and write tests for your application. Then provide examples on how to run them here.
