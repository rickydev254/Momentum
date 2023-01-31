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
        
