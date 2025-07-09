# 🧮 Unit Converter (JavaFX)

A modern and lightweight **JavaFX-based unit converter app** with support for various unit types like Length, Area, Volume, Weight, Temperature, Speed, and more. This intuitive and responsive desktop application allows easy switching between unit types and values with real-time conversion.

## ✨ Features

- ⚙️ **9 Unit Categories**:  
  - Length  
  - Area  
  - Volume  
  - Weight  
  - Temperature  
  - Speed  
  - Pressure  
  - Power  
  - Memory

- 🎨 **Sleek UI with Icons**: Clean, intuitive layout using FontAwesome icons via Ikonli.
- 🔁 **Bi-directional Conversion**: Convert values both ways with instant updates.
- 🧠 **Smart Formatting**: Proper case and spacing in unit names.
- 🔧 **Custom Components**: Modular and reusable components (`TypeSelector`, `Convert`, etc.).

## 🧰 Technologies Used

- Java 21
- JavaFX (FXML-free)
- [Ikonli](https://kordamp.org/ikonli/) (FontAwesome5 icon pack)
- Maven (build tool)

## 📦 Build & Run

### ✅ Prerequisites

- Java 17+ (Java 21 recommended)
- Maven

### 🛠 Run

```bash
./Converter/target/ConverterApp/bin/ConverterApp
```

📁 Project Structure
text
Copy
Edit
src/
└── main
    ├── java
    │   ├── com
    │   │   └── hash
    │   │       └── converter
    │   │           ├── components
    │   │           │   ├── convert
    │   │           │   │   ├── Convert.java
    │   │           │   │   └── NumberPadButton.java
    │   │           │   └── typeselector
    │   │           │       ├── TypeSelectorButton.java
    │   │           │       └── TypeSelector.java
    │   │           ├── Globals.java
    │   │           ├── HelloApplication.java
    │   │           └── util
    │   │               ├── Registry.java
    │   │               ├── Types.java
    │   │               ├── Unit.java
    │   │               └── Units.java
    │   └── module-info.java
    └── resources
        ├── com
        │   └── hash
        │       └── converter
        │           └── styles.css
        └── launcher.txt



🎯 Usage
Launch the app.

Click on any unit type (e.g., Length, Area, Speed).

Enter a value in the input field.

Choose units to convert from and to.

The converted value appears instantly.


