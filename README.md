# Operation Backend App

This project consists of three microservices following a containerized architecture. I provided a diagram file (NTD test.jpg in the root directory) that illustrates the communication between services and the responsibilities of each one, as described below:
## Microservices Overview

### 1. **UserService**
- **Responsibilities:**
   - Manages user authentication, user data, and balance information.
   - Acts as a gateway and backend-for-frontend (BFF) for the frontend.
   - Accesses the `userinfo` database schema.
- **Database Tables:**
   - `tb_user`: Stores user data such as login and password.
   - `tb_balance`: Stores the current balance of the user.
   - `tb_balance_history`: An audit table that logs all balance transactions.

### 2. **RecordService**
- **Responsibilities:**
   - Manages user operation actions.
   - Stores every operation performed along with user information, balance, and operation details.
   - Accesses the `record` database schema.
- **Database Tables:**
   - `tb_record`: Stores the operations performed and user details at the time of the operation.

### 3. **OperationService**
- **Responsibilities:**
   - Executes operations and manages operation costs.
   - Accesses the `operation` database schema.
- **Database Tables:**
   - `tb_operation`: Stores the operation name and costs.

## Service Structure

Each microservice includes the following modules:
- **Input-boundary**: Registers internal interfaces (controllers, use cases, entities).
- **Output-boundary**: Registers external dependencies (repositories, external APIs).
- **Controller**: Defines the service endpoints.
- **Usecase**: Contains the business rules and logic. (the only module who can se both input and output boundary)
- **Repository**: Manages the connection to the database.

## Running the Application Locally

To run the application locally, follow these steps:

1. Clone this repository.
2. Navigate to the root directory.
3. Run the following command to start all microservices:

   ```bash
   docker compose up

This command will start the three microservices, which will be accessible at the following URLs:

- **UserService**: [http://localhost:8081](http://localhost:8081)
- **OperationService**: [http://localhost:8082](http://localhost:8082)
- **RecordService**: [http://localhost:8083](http://localhost:8083)

The services are connected with the production database.
## Live Version

The live version is deployed on a free server, which may have some limitations. After a few minutes of inactivity, the services may enter a sleep state. The **first request** after this can take up to **5 minutes** to respond.

### Live URLs:
- **UserService**: [https://userservice-3hst.onrender.com](https://userservice-3hst.onrender.com)
- **OperationService**: [https://operationservice.onrender.com](https://operationservice.onrender.com)
- **RecordService**: [https://recordservice-c0d4.onrender.com](https://recordservice-c0d4.onrender.com)
