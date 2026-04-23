# Library Inventory System

## Description
This project is a console-based Java application that manages a small library inventory system. It allows users to store and manage books using a HashMap data structure with ISBN numbers as keys.

Each book contains:
- Title
- Author
- ISBN
- Quantity

The program also loads starting data from a CSV file and allows users to interact through a menu system.

## Features
- Display all books
- Add a new book
- Delete a book by ISBN
- Update book quantity
- Search for a book by ISBN
- Check out a book
- Return a book
- Load books from `Books.csv`

## Files
- `Main.java` - Runs the menu-driven program
- `Book.java` - Stores book object data
- `LibrarySystem.java` - Handles HashMap and library functions
- `Books.csv` - Starting inventory data

## How to Run

1. Open the project in IntelliJ IDEA or another Java IDE.
2. Make sure all `.java` files and `Books.csv` are inside the `src` folder.
3. Compile the project.
4. Run `Main.java`

## Data Structure Used
- `HashMap<String, Book>`

This allows efficient lookup, insertion, and deletion using ISBN values.

## Authors
- Lily Le
- Juan Perez Lopez
- Leonard Rosales
