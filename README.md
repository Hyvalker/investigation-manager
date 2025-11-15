# Investigation Manager 🔍

## 📖 Overview
Investigation Manager is a simulation system for managing investigation records.  
It allows detectives to:
- Register cases
- Add suspects
- Record clues
- Document evidence
- Assign investigators to each case

The goal is to provide a structured way to organize investigation data, simulating how detectives track and manage their work.

---

## 🚀 Features
- **Case Management**: Create and update cases with title, description, and status (ongoing, solved, archived).
- **Suspect Register**: Add suspects with personal details and background information.
- **Clue Register**: Record clues with unique IDs, dates, and descriptions.
- **Evidence Register**: Document evidence linked to cases.
- **Detective Assignment**: Associate detectives with specific cases.
- **Persistence with JSON**: Save and load all data using Jackson, ensuring information is preserved between sessions.

---

## 🛠️ Technologies
- **Java 24**
- **Jackson** (for JSON serialization/deserialization)
- **Collections API** (`List`, `ArrayList`)
- **Scanner** (for user input)

---

## 📂 Project Structure
src/ 
├── model/ # Core entities (Case, Suspect, Clue, Evidence, Detective, Status) 
├── services/ # Registers and managers (CaseRegister, SuspectRegister, etc.) 
├── data/ # Persistence with JSON (DataManager)
└── app/ # Entry point of the application (Detective App)

---

## ▶️ How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/Hyvalker/investigation-manager.git
2. Compile the project:
   javac -d bin src/**/*.java
3. Run the application:
   java -cp bin Main

📌 Next Steps
Add unit tests for core functionalities.

Improve user interface (possibly with a GUI).

Enhance search and filtering of cases.

Expand persistence to a single JSON file containing all registers.

🤝 Contributing
Contributions are welcome! Feel free to fork the project, open issues, or submit pull requests.

   
