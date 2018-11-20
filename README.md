"# and-digital" 

1. Run mvn package to create the Spring Boot Jar under \target folder
* Make sure localhost port 8080 is free
2. From \target folder run: java -jar and-digital-0.0.1-SNAPSHOT.jar
3. Use Rest tool (i.e. Postman) to call the API:
- Get all Phone Numbers - (GET) http://localhost:8080/api/phone
- Get customer phone numbers - (GET) http://localhost:8080/api/phone/1
    * there are 3 customers bootstrapped: 1, 2 and 3
- Activate phone - (POST) http://localhost:8080/api/phone/2?phone=123-345-1111
    * The phone number is passed as a param (key = phone)
4. Enjoy Swagger at:  http://localhost:8080/swagger-ui.html

Thanks.
Ofir Germansky.