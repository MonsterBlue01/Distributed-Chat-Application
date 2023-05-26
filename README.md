# PastryAggr

PastryAggr is a Java project that utilizes FreePastry to implement a system with N nodes. The system subscribes to a topic called "SimpleAggr" and performs regular updates within the network. This project aims to achieve the following tasks:

- Print the tree structure of the system.
- Log events related to publishing messages, delivering messages, and updating messages.
- Output all node IDs in a stable manner after several rounds of updates.
```
├── lib/
│   └── pastry.jar
├── src/
│   ├── main/
│   │    ├── Java/
│   │    │    ├── Main.java
│   │    │    ├── MessageLogger.java
│   │    │    ├── Node.java
│   │    │    └── TreePrinter.java
│   │    └── Resources/
│   └── test/
│        └── Java/
│             ├── IntegrationTest.java
│             ├── NodeTest.java
│             └── MessageLoggerTest.java
├── README.md
├── .gitignore
├── pom.xml
└── NOTE.txt
```
- `lib/`: Directory that holds the necessary library file(s). Currently, it contains `pastry.jar`, which is the FreePastry library.
- `src/main/java/`: Directory containing the main Java source code files.
  - `Main.java`: Entry point of the application.
  - `MessageLogger.java`: Utility class for logging message-related events.
  - `Node.java`: Class representing a node in the system.
  - `TreePrinter.java`: Utility class for printing the tree structure.
- `src/main/resources/`: Directory for project resources (if any).
- `src/test/java/`: Directory for test files.
  - `IntegrationTest.java`: Integration test class for verifying project functionality.
- `README.md`: This file, providing an overview of the project and its file structure.

## Usage

To use PastryAggr, follow these steps:

1. Ensure you have Java Development Kit (JDK) installed on your system.
2. Clone or download this project to your local machine.
3. Place the `pastry.jar` library file in the `lib/` directory.
4. Build and compile the project using your preferred build system or IDE.
5. Run the `Main` class to execute the PastryAggr system.
6. Monitor the console output for the tree structure, log messages, and the final output of all node IDs.

## Requirements

- Java Development Kit (JDK)
- FreePastry library (included as `pastry.jar` in the `lib/` directory)

## License

This project is licensed under the [MIT License](LICENSE).

Feel free to modify and extend the project to meet your specific needs.