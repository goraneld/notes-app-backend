# Notes Application

## Backend Setup (Java Spring Boot)

### Prerequisites
- **Java Development Kit (JDK)**: Version 17 or higher
- **Apache Maven**: Version 3.6 or higher
- **MongoDB**: Installed and running locally or hosted (e.g., MongoDB Atlas)
- **Postman** (optional): For testing the API endpoints

### Steps to Run the Backend

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd <repository-backend-folder>
   ```

2. **Configure MongoDB**
    - Open `src/main/resources/application.yml` (or `application.properties`) and configure the MongoDB connection details:
      ```yaml
      spring:
        data:
          mongodb:
            uri: mongodb://localhost:27017/notes_app
      ```
      Replace `mongodb://localhost:27017/notes_app` with your MongoDB URI if hosted.

3. **Build the Project**
   ```bash
   mvn clean install
   ```

4. **Run the Application**
   ```bash
   mvn spring-boot:run
   ```

5. **Verify the Application**
    - The backend server will start on `http://localhost:8080` by default.
    - Use Postman or your browser to test the following endpoints:
        - `POST /api/notes` to create a note
        - `GET /api/notes` to fetch all notes
        - `GET /api/notes/{id}` to fetch a note by ID
        - `PUT /api/notes/{id}` to update a note
        - `DELETE /api/notes/{id}` to delete a note

---

## Prerequisites Summary

### Backend:
- JDK 17+
- Maven 3.6+
- MongoDB (local or hosted)

### Frontend:
- Node.js 18+
- Angular CLI
