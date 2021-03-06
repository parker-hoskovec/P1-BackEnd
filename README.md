# Reimbursment Request REST API
***
## Project Description
***
A RESTful web API powered by Hibernate and GCP databases.  This service can be used to submit reimbursment requests as an employee and review those requests as a manager.

## Technologies Used
***
* Javalin - 3.13.3
* Gson - 2.8.6
* Mockito - 3.7.7
* Hibernate - 42.2.18
* JWT - 3.12.1

## Features
***
List of features ready and TODOs for future development

* Submit and view reimbursment requests
* Access locked to only signed in users with a valid JWT
* Managers can approve or deny pending reimbursements as well as adding a reason.

To-do list:

* Better layout for the front end
* Fix an issue with reimbursment status upon review.

## Getting Started
***
* Git Clone backend: https://github.com/parker-hoskovec/P1-BackEnd
* Git Clone frontend: https://github.com/parker-hoskovec/P1-FrontEnd
* <br />
Set a environmental variable with the name CONN_DETAILS and the value jdbc:postgresql://35.192.67.100:5432/icaDB?user=parker&password=password then run the App.class file.
Open the login page and use either JPalmer101 and secretPassword to view the employee page or JThunder404 and passwordNotFound to view the manager page.

![image](https://user-images.githubusercontent.com/60248487/113929803-76582280-97be-11eb-838b-0b899668fcf5.png)
![image](https://user-images.githubusercontent.com/60248487/113929892-94258780-97be-11eb-9c05-2fda9cf8d261.png)

## Usage
***
Once in you can add reimbursment requests by filling out the fields or review reimbursement requests if you are logged in as a manager.  Both employees and managers have ID's of 1 and 2 for use when submitting information.
