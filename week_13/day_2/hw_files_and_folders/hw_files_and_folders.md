# Homework: Annotating One-to-Many and Many-to-One Relationships

### Learning Objectives

- Understand the relationships, one to many and many to many
- Be able to use Spring Data REST to create the RESTful routes for a set of resources
- Use insomia to GET, POST, PUT and DELETE records


## Brief

Create a one-to-many Spring application using annotations as you've done before.

 Your application should have the following models: `Folders`, `Files` and `Users`. Users should have many folders, and folders should have many files.

Note: you don't need **any** controllers - Spring Data Rest should handle all of these.

### MVP

- Create a system to track files and folders:
  - A `File` should have:
     - a name
     - extension (e.g. txt, rb, java, ppt)
     - size
     - folder
  - A `User` should have:
     - name
     - a list of folders
  - A `Folder` should have:
     - a title
     - list of files
     - a user
     
- Creata a seeding file `DataLoader` component to pre-seed the database.
- Test with unit tests and manually inspecting postgres
- Enable Spring Data REST to create the RESTful routes to GET, POST, PUT, and DELETE

## Planning

Draw a diagram detail the relationships between models.
