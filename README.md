Testing the API using Postman

  Institution
  
  Add an Institution
    http://localhost:8080/api/v1/institution
    
      sample Body
        {
            "name":"Nairobi University",
             "address":"Nairobi",
             "population":"15000"
        }
  List All Institution
        http://localhost:8080/api/v1/institution
        
  Search the List of Institution
        http://localhost:8080/api/v1/institution/search?name=Nairobi
        
          Sample Result
            {
    "content": [
        {
            "id": 1,
            "name": "Nairobi University",
            "address": "Nairobi",
            "population": 15000
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "pageNumber": 0,
        "pageSize": 10,
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 1,
    "totalElements": 1,
    "last": true,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "first": true,
    "size": 10,
    "number": 0,
    "numberOfElements": 1,
    "empty": false
}

  Delete an Institution
  http://localhost:8080/api/v1/institution/{id}
  
  Edit an Institution
    http://localhost:8080/api/v1/institution/{id}
        
Course

List All Courses

http://localhost:8080/api/v1/course

Filter a Course

http://localhost:8080/api/v1/course/search?name=software

Sample Result
  {
    "content": [
        {
            "id": 3,
            "name": "Bachelor of Software Engineering"
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "pageNumber": 0,
        "pageSize": 10,
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 1,
    "totalElements": 1,
    "last": true,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "first": true,
    "size": 10,
    "number": 0,
    "numberOfElements": 1,
    "empty": false
}

Sort By name in Ascending Order
  http://localhost:8080/api/v1/course/search?sortBy=name
  
  Sample Result
  {
    "content": [
        {
            "id": 4,
            "name": "Bachelor of Computer Science"
        },
        {
            "id": 3,
            "name": "Bachelor of Software Engineering"
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "pageNumber": 0,
        "pageSize": 10,
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 1,
    "totalElements": 2,
    "last": true,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "first": true,
    "size": 10,
    "number": 0,
    "numberOfElements": 2,
    "empty": false
}

Add a new Course

http://localhost:8080/api/v1/course

Delete a course

http://localhost:8080/api/v1/course/{id}

Edit the name of a course

http://localhost:8080/api/v1/course/{id}

Student

Add a student

http://localhost:8080/api/v1/student

Edit a Student

http://localhost:8080/api/v1/student/{id}

Delete a Student

http://localhost:8080/api/v1/student{id}

Change the course the student is doing within the same institution

http://localhost:8080/api/v1/student{id}

When listing students, show 10 students at a time
http://localhost:8080/api/v1/student
  Limited all results to 10 in the code
