# gitCallChatgpt
This is a  SpringBoot  application that interacts with ChatGPT to answer user questions. The application runs inside a Docker container and stores the user questions and answers in a CSV file like [question;answer]

Prerequisites
To run this application, you need to have the following software installed on your system:
-Docker
-Java 17

Getting started
To run the application, follow these steps:

1-Clone the repository to your local machine.
2-you must modify the api key in the env file with your own key generated from the link https://beta.openai.com/account/api-keys
3-Build the Docker image by running the following command from the root directory of the project:
docker build -t [nom_image] .
4-Start the Docker container by running the following command:
docker run -p 8080:8080 [nom_image]
5-Once the container is running, you can access the application at http://localhost:8080.

Architecture
The application is built using the Spring Boot 3 framework. Spring Boot is a solid choice for building web applications, particularly if you are familiar with the Spring ecosystem and want to take advantage of its many features and benefits.
The back-end communicates with ChatGPT using the OpenAI API. The application uses a CSV file to store the user questions and answers.

Notes
To use the OpenAI API, you need to sign up for an API key on the OpenAI website t (https://beta.openai.com/account/api-keys).
The CSV file is stored in the root directory of the application. 

