

##Brief description of the implementation.

The application uses Quarkus, Jakson, JUnit5

##Features 

It has some flavor of Command pattern

##How to run ?

``mvn compile quarkus:dev``

##How to run tests ?

`` mvn compile quarkus:test``

##Useful URLs:

WINDOWS:

curl.exe --request POST --url http://localhost:8080/policy/calculate `
--header 'Content-Type: application/json' `
--data '{ "policyNumber": "LV20-02-100000-5","policyStatus": "REGISTERED","policyObjects": [{"name": "Car","subObjects": [{            "name": "Boat","sum": 100, "riskType": "FIRE" }, {"name": "TV", "sum": 8,"riskType": "THEFT" }]}]}'.Replace('"','""')

**NIX:

curl --request POST --url http://localhost:8080/policy/calculate \
--header 'Content-Type: application/json' \
--data '{ "policyNumber": "LV20-02-100000-5","policyStatus": "REGISTERED","policyObjects": [{"name": "Car","subObjects": [{            "name": "Boat","sum": 100, "riskType": "FIRE" }, {"name": "TV", "sum": 8,"riskType": "THEFT" }]}]}'


 

