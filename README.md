"# Attendance System" 
----------------------

This project is an attendance management system. It consists of a Spring Boot backend with JWT-based authentication and a simple HTML/JavaScript frontend for user login and home page functionality.

Project Overview
----------------
The system allows users to log in with credentials stored in a users.txt file, authenticate via a REST API using JWT, and access a home page. Key features include:

Backend: Spring Boot application with JWT authentication, serving a POST /api/v1/users/login endpoint.
Frontend: HTML/JavaScript client for login, logout, and navigation with validation and redirects.
Authentication: Users are authenticated using credentials from users.txt, with JWT tokens stored in localStorage.

Project Structure
------------------
```
attendance-system/
├── client/                   # Frontend (HTML, JavaScript)
│   ├── login.html            # Login page
│   ├── home.html             # Home page
│   └── script.js             # Client-side logic
├── server/                   # Backend (Spring Boot)
│   ├── src/main/java/com/juliyad/assesmentTrial/
│   ├── src/main/resources/
│   │   ├── application.properties
│   │   └── users.txt         # User credentials
│   └── pom.xml
├── docs/                     # Documentation and screenshots
│   ├── task4-login.png       # Login page screenshot
│   └── task5-home.png        # Home page screenshot
└── ReadMe.md                 # Project documentation
```

Prerequisites
--------------

Java 17: For running the Spring Boot backend.
Maven 3.8+: For building the backend.
Python 3.6+: For serving the frontend (uses http.server).
Git: For cloning the repository.
Web Browser: Chrome, Firefox, or Edge for testing the frontend.

Setup Instructions
-------------------
1. Clone the Repository
- git clone https://github.com/S-N-JuliyadDinosan/Attendance-System.git
- cd attendance-system

2. Set Up the Backend
1)  Navigate to the server directory:
- cd server
2) Verify users.txt:
- Located at server/src/main/resources/users.txt.
- Contains:admin:Admin@123 , 
           student:pass@123

3) Build the project:
- mvn clean install

4) Run the backend:
- mvn spring-boot:run
- The backend runs on http://localhost:8080.
- The login API is available at http://localhost:8080/api/v1/users/login.

3. Set Up the Frontend

1) Navigate to the client directory:
- cd ../client

2) Serve the frontend:
- python -m http.server 8000
- The frontend is accessible at http://localhost:8000/login.html.

4. Test the Application

1) Open the login page:
- Navigate to http://localhost:8000/login.html in your browser.

2) Log in with test credentials:
 - Admin :: 
Username: admin
Password: Admin@123

 - Student ::
Username: student
Password: pass@123

Expected behavior
-----------------

- Login: Enter valid credentials → Redirect to home.html with a welcome message.

- Validation: Empty fields → “Please enter username and password.”

- Invalid credentials: Wrong username/password → “Invalid email or password.”

- Logout: Click Logout on home.html → Redirect to login.html.

- Redirects:
Access home.html without login → Redirect to login.html & 
Access login.html when logged in → Redirect to home.html.

Testing Credentials
--------------------
The following credentials are available in server/src/main/resources/users.txt for testing:

- Username

- Password

admin :: 
Admin@123

student ::
pass@123


Screenshots
-----------

- Login Page: docs/#4 Login_page.png ::
Shows the login form with validation errors.

- Home Page: docs/#4 Home_Page.png ::
Displays the welcome message and logout button after successful login.

Notes
------

- CORS: The backend is configured to allow requests from http://localhost:8000.

- Security: JWT tokens are stored in localStorage for simplicity. In production, consider secure alternatives.

- Package: The backend uses com._axislabs.attendance_system.

- Dependencies: Ensure Maven dependencies (e.g., jjwt, spring-security) are resolved via pom.xml.

Troubleshooting
---------------

1) Backend fails to start:

- Run mvn clean install to resolve dependency issues.

- Check users.txt exists and is readable.

2) CORS errors:

- Verify SecurityConfig.java allows http://localhost:8000.

3) Frontend not loading:

- Ensure python -m http.server 8000 is running in the client directory.

4) Login fails:

- Test API with Postman ::
POST http://localhost:8080/api/v1/users/login & Body: { "username": "admin", "password": "Admin@123" }

- Check browser Console (F12) for errors.

Future Improvements
--------------------

- Add more frontend features (e.g., attendance tracking).

- Enhance security (e.g., secure token storage, password hashing).

