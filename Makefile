# Makefile

# Variables
JAVAC = javac
JAVA = java
SRC = $(wildcard *.java)
CLASSES = $(SRC:.java=.class)
MAIN = ToDoList

# Declare phony targets
.PHONY: all run clean

# Default target
default: all

# Compile all .java files
all: $(CLASSES)

# Rule to compile .java to .class
%.class: %.java
	$(JAVAC) $<

# Run the program
run: all
	$(JAVA) $(MAIN)

clean:
	rm -f *.class