#include <iostream>

using namespace std;

int main() {
    double num1, num2;
    char oper;

    cout << "Enter an operator (+, -, *, /): ";
    cin >> oper;

    cout << "Enter two operands: ";
    cin >> num1 >> num2;

    switch (oper) {
        case '+':
            cout << num1 << " + " << num2 << " = " << num1 + num2;
            break;
        case '-':
            cout << num1 << " - " << num2 << " = " << num1 - num2;
            break;
        case '*':
            cout << num1 << " * " << num2 << " = " << num1 * num2;
            break;
        case '/':
            if (num2 == 0) {
                cout << "Error! Dividing by zero is not allowed.";
            } else {
                cout << num1 << " / " << num2 << " = " << num1 / num2;
            }
            break;
        default:
            // If the operator is other than +, -, * or /, error message is shown
            cout << "Error! Invalid operator. Please enter '+', '-', '*' or '/'.\n";
            break;
    }

    return 0;
}