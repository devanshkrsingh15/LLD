import java.util.ArrayList;

public class Calculator {
    // Enter Your Methods Here
    public static void main(String[] args) {
        CalculatorGUI calculator = new CalculatorGUI();
        calculator.operate(1,4, Ops.ADD);
        calculator.operate(3,4, Ops.MUL);
        calculator.operate(12,6, Ops.DIV);
        calculator.operate(10,7, Ops.SUB);
        calculator.operate(2,3, Ops.POW);

        calculator.operate(10,3, Ops.POW);


      //  calculator.load();

    }
}

enum Ops {
    ADD, SUB, MUL, DIV, POW
}

interface IOperation {
    public int operate(int a, int b);

    public String expression(int a, int b, int ans);

    public static IOperation createFactory(int a, int b, Ops ops) {
        if (ops == Ops.ADD) {
            return new Addition();
        } else if (ops == Ops.SUB) {
            return new Subtraction();
        } else if (ops == Ops.MUL) {
            return new Multiplication();
        } else if (ops == Ops.DIV) {
            return new Division();
        } else if(ops == Ops.POW){
            return new Power();
        }
        else {
            return null;
        }
    }
}

class Addition implements IOperation {
    public int operate(int a, int b) {
        return a + b;
    };

    public String expression(int a, int b, int ans) {
        return a + " + " + b + " = " + ans;
    };
}

class Subtraction implements IOperation {
    public int operate(int a, int b) {
        return a - b;
    };

    public String expression(int a, int b, int ans) {
        return a + " - " + b + " = " + ans;
    };

}

class Multiplication implements IOperation {
    public int operate(int a, int b) {
        return a * b;
    };

    public String expression(int a, int b, int ans) {
        return a + " * " + b + " = " + ans;
    };

}

class Division implements IOperation {
    public int operate(int a, int b) {
        return a / b;
    };

    public String expression(int a, int b, int ans) {
        return a + " / " + b + " = " + ans;
    };

}

class Power implements IOperation{

    public int operate(int a, int b) {
       return (int)Math.pow(a, b);
    }

    public String expression(int a, int b, int ans) {
       return a + " ^ " +b + " = " + ans;
    }
    
}

class CalculatorGUI {
    ArrayList<String> expressions;

    CalculatorGUI() {
        expressions = new ArrayList<>();
    }

    // operate
    String operate(int a, int b, Ops op) {
        IOperation ops = IOperation.createFactory(a, b, op);
        int ans = ops.operate(a, b);
        String exp = ops.expression(a, b, ans);
        System.out.println(exp);
        expressions.add(exp);
        return exp;

    }

    // load
    void load() {
        for (String s : expressions) {
            System.out.println(s);
        }
    }

}
