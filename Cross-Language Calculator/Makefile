CC = gcc
CXX = g++
CFLAGS = -Wall -Wextra
CXXFLAGS = -Wall -Wextra

.PHONY: all clean

all: calculator_c calculator_cpp

calculator_c: calculator.c
	$(CC) $(CFLAGS) -o $@ $<

calculator_cpp: calculator.cc
	$(CXX) $(CXXFLAGS) -o $@ $<

clean:
	rm -f calculator_c calculator_cpp
