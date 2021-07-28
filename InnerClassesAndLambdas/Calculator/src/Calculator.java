public class Calculator {
    public DoMath toOperation(String op){
        DoMath res;
        switch (op) {
            case "+": res = (a, b) -> a + b;/* TODO */
//Use a lambda expression to set "res" to the correct function.
                break;
            case "-": res = (a, b) -> a - b;/* TODO */
//Use a lambda expression to set "res" to the correct function.-x2;
                break;
            case "*": res = (a, b) -> a * b;/* TODO */
//Use a lambda expression to set "res" to the correct function.->x1*x2;
                break;
            case "/": res = (a, b) -> b == 0? Double.POSITIVE_INFINITY : a/b;
                /* TODO */
//Use a lambda expression to set "res" to the correct function. You must account for divisions by zero as specified in the instructions.INITY:x1/x2;
                break;
            default:
                res = (a, b) -> Double.MIN_VALUE;
          /* TODO */
//In the default value, the res function should return the minimun possible value.ouble.MIN_VALUE;
        }
        return res;
    }

    public Double compute(Double n1, Double n2, String op){
      /* TODO */
//set calc to the correct function calling the method above.toOperation(op);/* TODO */
        DoMath calc = toOperation(op);
        return calc.compute(n1, n2);//the result of calc.compute with the numbers given..compute(n1,n2);
    }
}
