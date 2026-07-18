#!/bin/bash

# Compile all Java files
javac -cp "lib/postgresql-42.7.13.jar" -d bin $(find src -name "*.java")

# Stop if compilation failed
if [ $? -ne 0 ]; then
    echo "Compilation failed."
    exit 1
fi

# Run the application
java -cp "bin:lib/postgresql-42.7.13.jar" BankAccountSystem.Main