# Makefile for calculator program

# Compiler
CC = gcc

# Compiler flags
CFLAGS = -Wall -g

# Target executable name
TARGET = calculator

all: $(TARGET)

$(TARGET): calculator.o
	$(CC) $(CFLAGS) -o $(TARGET) calculator.o

calculator.o: calculator.c
	$(CC) $(CFLAGS) -c calculator.c

clean:
	rm -f *.o $(TARGET)
