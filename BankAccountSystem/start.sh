#!/bin/bash

# Create the bin directory if it doesn't exist
mkdir -p bin

# Compile all Java files with ALL JARs in lib/
javac -cp "lib/*" -d bin $(find src -name "*.java")

# Stop if compilation failed
if [ $? -ne 0 ]; then
    echo "Compilation failed."
    exit 1
fi

# Run the application
java -cp "bin:lib/*" BankAccountSystem.Main