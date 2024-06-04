# AddressBookApp

A Java console application for managing contacts using serialization for data persistence.

## Features

- View all contacts
- Add a new contact
- Search for a contact by name
- Edit a contact by name
- Delete a contact by name
- Exit the application

## Contact Details

Each contact includes the following details:
- Full Name
- Phone Number
- Address
- Email
- Date of Birth

## Getting Started

### Prerequisites

Before you begin, ensure you have met the following requirements:
- Java Development Kit (JDK)
- IntelliJ IDEA or any other Java IDE

### Installation

1. Clone the repository:
   \`\`\`sh
   git clone https://github.com/your_username/AddressBookApp.git
   \`\`\`

2. Open the project in IntelliJ IDEA:
   - Go to `File > Open` and select the project directory.

3. Build the project:
   - Go to `Build > Build Project`.

4. Run the `Main` class to start the application:
   - Navigate to `src/com/company/Main.java`.
   - Right-click on the `Main` class and select `Run 'Main'`.

### Usage

Upon running the application, you will be presented with a menu to manage your contacts. The available options are:
1. View all contacts
2. Add a new contact
3. Search for a contact by name
4. Edit a contact by name
5. Delete a contact by name
6. Exit the application

Example of adding a new contact:
\`\`\`
Enter your choice: 2
Enter full name: John Papanikolas
Enter phone number: 123-456-7890
Enter address: 123 Main St
Enter email: john@example.com
Enter date of birth (YYYY-MM-DD): 1980-01-01
Contact added successfully!
\`\`\`

### Project Structure

\`\`\`
AddressBookApp/
├── src/
│   └── com/
│       └── company/
│           ├── AddressContact.ser   # Serialized data file
│           ├── Contact.java         # Contact class
│           ├── CreateInitialContacts.java # Class to create initial contacts
│           ├── Main.java            # Main class with the application entry point
│           └── SerializationUtil.java # Utility class for serialization
├── .gitignore
├── README.md
└── LICENSE
\`\`\`

### Serialization

The application uses Java's serialization mechanism to save and load contact data to and from a file named `AddressContact.ser`. This ensures that all contact information is preserved between sessions.

### Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

### License

This project is licensed under the MIT License. See the `LICENSE` file for more information.
