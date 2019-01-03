# Lab: Bootstrap an Employee tracking application

**Lab Duration: 45-60 minutes**

### Learning Objectives

- Consolidate how to bootstrap a new Spring Application
- Be able to annotate a class for persistence to the database
- Be able to create a repository for doing database operations
- Be able to inject the repository into the controller

## Brief

In this lab please use what you've already learned about Spring to create an entirely new Spring application that allows you to get the details of an employee.

Start from scratch using the [ Spring Boot Initializr](https://start.spring.io/).

### MVP

Create a Spring Boot application for recording employee data that has:
- An Employee class that conforms to POJO and is annotated with fields `name`, `age`, `employeeNumber` and `email`.
- A repostory for doing database operations
- A RestController with one route for getting a JSON list of all Employees.

## Planning

Make a list/diagram of the files that will make up your program and note down their responsibilities.
