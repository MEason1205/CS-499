# Database Design and Security

## 📄 Artifact Description

This artifact is the database-backed version of the Contact Management System developed during my CS-320 course. It includes a MySQL backend and Java interface for storing and managing contact data. Initially, the system relied on hardcoded SQL strings and offered limited protections for sensitive data.

## 🎯 Justification for Inclusion

I selected this artifact to demonstrate my skills in secure and normalized database design. Enhancements included:
- Replacing raw SQL strings with parameterized queries to prevent SQL injection.
- Implementing role-based access control (RBAC).
- Normalizing the schema to reduce redundancy.
- Adding encryption for sensitive fields.
These changes significantly improved the application’s security, maintainability, and efficiency.

## 🎓 Course Outcomes Reflection

This artifact supports several CS-499 outcomes:
- **Security mindset:** Introduced RBAC and encrypted sensitive data.
- **Efficient database solutions:** Normalized the schema and improved query indexing.
- **Innovative tools and techniques:** Used prepared statements and Java connectors effectively.
- **Professional documentation:** Documented schema changes and database access methods.

## 🔁 Process Reflection

Refactoring the codebase to support parameterized queries required separating business logic from SQL execution. Troubleshooting schema normalization issues and role logic helped me gain deeper insight into secure, scalable database design. These experiences are vital as I pursue a career in secure software and backend systems.
