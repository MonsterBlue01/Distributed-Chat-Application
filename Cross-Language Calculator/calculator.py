operator = input('Enter an operator (+, -, *, /): ')
num1 = float(input('Enter the first operands: '))
num2 = float(input('Enter the second operands: '))

if operator == '+':
    print("{:.2f} + {:.2f} = {:.2f}".format(num1, num2, num1 + num2))
elif operator == '-':
    print("{:.2f} - {:.2f} = {:.2f}".format(num1, num2, num1 - num2))
elif operator == '*':
    print("{:.2f} * {:.2f} = {:.2f}".format(num1, num2, num1 * num2))
elif operator == '/':
    if num2 != 0.0:
        print("{:.2f} / {:.2f} = {:.2f}".format(num1, num2, num1 / num2))
    else:
        print('Error! Division by zero is not allowed.')
else:
    print('Error! Invalid operator. Please enter "+", "-", "*" or "/".')