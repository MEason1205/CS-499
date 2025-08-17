# Software Design and Engineering

## 📄 Artifact Description

This artifact comes from my CS-410 Reverse Software Engineering project. Originally developed as a C++ console application, it simulates basic user interaction and access control. Users log in with credentials, view a text-based menu, and perform placeholder actions like viewing a welcome message or exiting. In its original form, the authentication was hardcoded, there was no database or hashing, and the application lacked modular structure or strong error handling.

## 🎯 Justification for Inclusion

I selected this project to demonstrate my ability to refactor legacy code into modular, secure, and scalable components. Through this artifact, I showcase secure authentication techniques, modular class design, and error handling strategies—all aligned with modern software development best practices. Enhancements like password hashing, user input validation, and structured logging highlight my attention to software security and design principles.

## 🎓 Course Outcomes Reflection

This artifact supports several CS-499 course outcomes:
- **Security mindset:** Implementing SHA-256 password hashing and removing plaintext credentials.
- **Designing computing solutions:** Refactoring large functions into classes like `UserAuthenticator` and `MenuHandler`.
- **Software engineering best practices:** Applying SOLID principles and improving maintainability.
- **Communicating professionally:** Including structured documentation and logging.

## 🔁 Process Reflection

This enhancement taught me the practical value of modular design and secure development. Replacing hardcoded logic with secure login workflows required careful integration of cryptographic libraries and thoughtful class design. Creating unit tests for authentication logic also improved reliability. This process deepened my understanding of balancing usability, security, and maintainability—essential skills for my career.
