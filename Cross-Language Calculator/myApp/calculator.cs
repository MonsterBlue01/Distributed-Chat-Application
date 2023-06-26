class program {
    static void Main(string[] args) {
        double num1, num2;
        char oper;

        Console.Write("Enter an operator (+, -, *, /): ");
        oper = Convert.ToChar(Console.ReadLine());

        Console.Write("Enter two operands: ");
        string[] operands = Console.ReadLine().Split(' ');
        num1 = Convert.ToDouble(operands[0]);
        num2 = Convert.ToDouble(operands[1]);

        switch (oper) {
            case '+':
                Console.WriteLine(num1 + " + " + num2 + " = " + (num1 + num2));
                break;
            case '-':
                Console.WriteLine(num1 + " - " + num2 + " = " + (num1 - num2));
                break;
            case '*':
                Console.WriteLine(num1 + " * " + num2 + " = " + (num1 * num2));
                break;
            case '/':
                if (num2 == 0) {
                    Console.WriteLine("Error! Dividing by zero is not allowed.");
                } else {
                    Console.WriteLine(num1 + " / " + num2 + " = " + (num1 / num2));
                }
                break;
            default:
                // If the operator is other than +, -, * or /, error message is shown
                Console.WriteLine("Error! Invalid operator. Please enter '+', '-', '*' or '/'.\n");
                break;
        }
    }
}