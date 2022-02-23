# Course-Registration-System
The copy of my original Course Registration System code in CSCI-UA 102 Data Structure class. This is a Java project that allows building a Course Registration System for college students and the school admin to login and manage courses. Students can register/withdraw from a course. Admin can create, update and edit the courses, and register students. Basic functions like sorting courses are included.

I also implemented Java to read and edit student information and course information from/into CSV files. Currently supported NYU CS department csv data and courses as this is a homework from my Data Structure Class.

Submitted by: **Ashley Luo**

Time spent: **24** hours spent in total



## User Stories
The following **Topics** are covered:

Classes, Objects, Inheritance, Polymorphism, Interfaces, Abstract Classes, Method Overriding, File I/O, ArrayLists, Serialization and more on Object-Oriented Paradigm


The following **Learning Objectives** are covered:

-Practicing design and engineer a software solution using the Object-Oriented Programming Paradigm (OOP) 

-Practicing Abstraction, Encapsulation, Inheritance, Method Overriding, Method Overloading and Polymorphism.

-Practicing Sorting of Objects 

-Practicing Abstraction (Abstract Data Types, the ArrayList class, Lists…) 

-Practicing File/IO in Java 

-Practicing Serialization and Binary Files in Java

In this project, I applied **Requirements Gathering and Analysis** methodology. The overall project would be structured into several small parts. 

The following **Blueprints** are implemented:

* [x] Req 01: The school shall store the following information about each course: Course name, course id, maximum number of students registered in the course, current number of registered students, a list of names of students being registered in the given course, course instructor, course section number, course location.
* [x] Req 02: The system shall allow two types of users: Admin and Student
* [x] Req 03: The system shall allow the Admin to perform the following tasks: (these are the options that will be in their menu that will be displayed your program when the administrator logs in)
    Courses Management

        1.Create a new course

        2.Delete a course

        3.Edit a course (this will allow the admin to edit any information on the course except for course ID and name)

        4.Display information for a given course (by course ID)

        5.Register a student (this option will allow the admin to add a student without assigning to a course check Req 11 for student’s information – Hint: You might need to have an ArrayList of Students where you store Student objects)

        6.Exit








## Notes



## License

    Copyright [2021] [Ashley]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

