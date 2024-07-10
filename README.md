# Spring Boot Application

## Table of Contents
- [CRUD Operations](#crud_app)
- [JWT Implementation](#jwt_imp)

# [CRUD Operations] <a name = "crud_app"></a>

A SpringBoot Application to perform all CRUD operations including PUT, POST, GET, GET ALL, DELETE and PATCH. It consists of an inventory system with different product fields which is stored in MYSQL database.

## Operations

### 1. Add Products
- Method : POST
- Endpoint : /addProducts
- Screenshot :
<img width="1440" alt="4-AddMultipleProduct" src="https://github.com/saurabh-consultadd/SpringBoot-CRUD/assets/174772884/6da88dba-31c3-40ac-812c-88bff051abe8">

<br/>

### 2. Get all Products
- Method : GET
- Endpoint : /products
- Screenshot :
<img width="1440" alt="6-GetAllProduct" src="https://github.com/saurabh-consultadd/SpringBoot-CRUD/assets/174772884/c06cb0f0-9226-4d71-8804-6e371f7f7e6d">

<br/>

### 3. Get Specific Product
- Method : GET
- Endpoint : /productById/{id}
- Screenshot :
<img width="1440" alt="7-GetProductById" src="https://github.com/saurabh-consultadd/SpringBoot-CRUD/assets/174772884/0cbc17ea-e98c-4148-8a6d-c635a69d1ce2">

<br/>

### 4. Delete Product
- Method : DELETE
- Endpoint : /delete/{id}
- Screenshot :
<img width="1440" alt="9-DeleteProductById" src="https://github.com/saurabh-consultadd/SpringBoot-CRUD/assets/174772884/7508b650-c5b9-4494-82f5-954f7372e352">

<br/>

### 5. Update Product
- Method : PUT
- Endpoint : /update
- Screenshot :
<img width="1440" alt="11-PutReqToUpdatePrice" src="https://github.com/saurabh-consultadd/SpringBoot-CRUD/assets/174772884/177192d8-0522-442c-9fd1-a4ec4bd98850">

<br/>

### 6. Update Specific Product
- Method : PATCH
- Endpoint : /patch/{id}
- Screenshot :
<img width="1440" alt="13-PatchReqUpdate" src="https://github.com/saurabh-consultadd/SpringBoot-CRUD/assets/174772884/b2c50223-3fbf-43a3-aae7-ced9ce300948">

<br/><br/>
# [JWT Implementation] <a name = "jwt_app"></a>

JWT(JSON Web Token) is used for securely transmitting information between parties as a JSON object. It consist of following three parts:
- Header -> The header typically consists of two parts: the type of the token, which is JWT, and the signing algorithm being used, such as HMAC SHA256 or RSA.
- Payload -> The second part of the token is the payload, which contains the claims. Claims are statements about an entity (typically, the user) and additional data.
- Signature -> To create the signature part we have to take the encoded header, the encoded payload, a secret, the algorithm specified in the header, and sign that. 

## Project build :
<img width="1373" alt="Screenshot 2024-07-10 at 10 14 47 AM" src="https://github.com/saurabh-consultadd/SpringBoot-CRUD/assets/174772884/fd5d5c0f-67de-42a4-9e5c-65c381a9c81e">

<br/>

### 1. Admin Registration
- Method : POST
- Endpoint : /register/user
- Screenshot :
<img width="1440" alt="adminregister" src="https://github.com/saurabh-consultadd/SpringBoot-CRUD/assets/174772884/35f1ea95-0ebb-4a91-99fb-395b67d408f1">

<br/>

### 2. User Registration
- Method : POST
- Endpoint : /register/user
- Screenshot :
<img width="1440" alt="userregister" src="https://github.com/saurabh-consultadd/SpringBoot-CRUD/assets/174772884/1c7ca5ab-3160-4aad-b3ad-3ad7a28ccf02">

<br/>

### 3. Authentication(Token Generation)
- Method : POST
- Endpoint : /authenticate
- Screenshot :
<img width="1440" alt="authenticate(token generation)" src="https://github.com/saurabh-consultadd/SpringBoot-CRUD/assets/174772884/ae877ddd-46af-45be-ac49-4a96dd09bf76">

<br/>

### 4. Authorization
1. Valid User :
- Method : GET
- Endpoint : /admin/showProduct
- Screenshot :
<img width="1440" alt="authorization" src="https://github.com/saurabh-consultadd/SpringBoot-CRUD/assets/174772884/35d0790e-6155-4aa2-a263-99c2b028e70b">

<br/><br/>
2. Invalid User :
- Method : GET
- Endpoint : /user/showProduct
- Screenshot :
<img width="1440" alt="Screenshot 2024-07-10 at 10 18 02 AM" src="https://github.com/saurabh-consultadd/SpringBoot-CRUD/assets/174772884/703694c8-cd78-493e-88b2-4b5c979279ce">

<br/>

## Users Database :
<img width="471" alt="useraccessdb" src="https://github.com/saurabh-consultadd/SpringBoot-CRUD/assets/174772884/d5a489b7-5594-493e-be21-987512a2fe27">
