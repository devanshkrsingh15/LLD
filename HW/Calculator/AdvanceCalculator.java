import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class AdvanceCalculator {
    public static void main(String[] args) {
        CalculatorGui myCalculator = new CalculatorGui();
        myCalculator.calculate("(110 - 90) / 2", Save.Yes);
        myCalculator.calculate("((30 + 3) / 3 + 7 + 10)*10", Save.Yes);
        myCalculator.load();

    }
}

enum Save {
    Yes, No
}

class CalculatorGui {
    private ArrayList<String> calculationsDoneTillNow;
    private Stack<Character> operators;
    private Stack<Integer> operands;
    private HashMap<Character, Integer> precedence;

    CalculatorGui() {
        calculationsDoneTillNow = new ArrayList<>();
        operators = new Stack<>();
        operands = new Stack<>();
        precedence = new HashMap<>();

        fillPrecedence();
    }

    private void fillPrecedence() {
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('(', -(int) 1e9);
    }

    void calculate(String expression, Save s) {
        int ans = evaluate(expression.trim());
        if (s == Save.Yes) {
            calculationsDoneTillNow.add(expression + " = " + ans);
        }
    }

    private int evaluate(String expression) {
        int len = expression.length();

        int i = 0;
        while (i < len) {
            char ch = expression.charAt(i);
            if (ch == ' ') {
                i++;
                continue;
            }
            if (ch == '(') {
                operators.push(ch);
                i++;
            } else if (ch == ')') {
                while (operators.size() != 0 && operators.peek() != '(') {
                    int b = operands.pop();
                    int a = operands.pop();
                    char op = operators.pop();
                    doArithmetic(a, b, op);
                }
                operators.pop();
                i++;
            } else if (isAnOperator(ch)) {
                if (operators.size() != 0 && precedence.get(operators.peek()) >= precedence.get(ch)) {
                    int b = operands.pop();
                    int a = operands.pop();
                    char op = operators.pop();
                    doArithmetic(a, b, op);
                }
                operators.push(ch);
                i++;
            } else if (isDigit(ch)) {
                int temp = ch - '0';
                i++;
                while (i < len && isDigit(expression.charAt(i))) {
                    temp *= 10;
                    temp += (int) (expression.charAt(i) - '0');
                    i++;
                }
                operands.push(temp);
            }
        }

        while (operators.size() != 0) {
            int b = operands.pop();
            int a = operands.pop();
            char op = operators.pop();
            doArithmetic(a, b, op);
        }

        return operands.peek();
    }

    private void doArithmetic(int a, int b, char op) {
        IOperation mathOperation = IOperation.OperationFactory(op);
        int temp = mathOperation.eval(a, b);
        operands.push(temp);
    }

    private boolean isAnOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    void load() {
        if(calculationsDoneTillNow.size()==0){
            System.out.println("Please do some calculations");
            return;
        }
        for (String s : calculationsDoneTillNow) {
            System.out.println(s);
        }
    }
}

interface IOperation {
    int eval(int a, int b);

    public static IOperation OperationFactory(char op) {
        switch (op) {
            case '+':
                return new Addition();
            case '-':
                return new Subtraction();
            case '/':
                return new Division();
            case '*':
                return new Multiplication();
            default:
                return null;
        }
    }
}

class Addition implements IOperation {

    @Override
    public int eval(int a, int b) {
        return a + b;
    }

}

class Subtraction implements IOperation {
    @Override
    public int eval(int a, int b) {
        return a - b;
    }

}

class Multiplication implements IOperation {
    @Override
    public int eval(int a, int b) {
        return a * b;
    }
}

class Division implements IOperation {
    @Override
    public int eval(int a, int b) {
        return a / b;
    }
}