# Algorithms and Data Structures

## 📄 Artifact Description

This artifact is a contact management system developed in CS-320: Software Testing, Automation, and Quality Assurance. The system was originally implemented using Java `ArrayList` and `LinkedList` collections to store contacts, tasks, and appointments. Basic CRUD operations were supported and validated with unit tests using JUnit.

## 🎯 Justification for Inclusion

I chose this artifact because it allowed me to demonstrate improvements in algorithmic performance and data structure selection. I replaced `ArrayList` storage with `HashMap<String, T>` for faster O(1) lookups and integrated performance benchmarking using `System.nanoTime()` to measure execution time across large datasets. These changes demonstrate my ability to optimize algorithms and quantify real-world efficiency gains.

## 🎓 Course Outcomes Reflection

This artifact supports several CS-499 outcomes:
- **Design and evaluation of computing solutions:** Upgraded from linear to constant-time complexity for CRUD operations.
- **Use of innovative computing techniques:** Integrated lightweight benchmarking to evaluate performance.
- **Managing trade-offs:** Balanced memory usage vs. speed in choosing hash-based structures.
- **Professional-quality documentation:** Provided inline comments and benchmark logs to support analysis.

## 🔁 Process Reflection

I learned how critical it is to choose the right data structure for performance and scalability. Managing hash collisions and JVM variability in benchmarking required me to average runs and separate benchmarking from core logic. These technical challenges improved my understanding of data structure behavior and trade-offs in real-world scenarios.
