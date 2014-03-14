import java.util.*;

/**
 * Created by szhu on 2014-03-03.
 */
public class EvaluateReversedPolishNotation {
    public static void main(String []args){
        String []notation = {"2","3", "+", "3", "*"};
        EvaluateReversedPolishNotation evaluateReversedPolishNotation = new EvaluateReversedPolishNotation();

        System.out.println(evaluateReversedPolishNotation.evalRPN(notation));

    }
    public int evalRPN(String[] tokens) {
        HashSet<String> operations = new HashSet<String>();
        String [] operators ={"+", "-", "*", "/"};
        operations.addAll(new ArrayList(Arrays.asList(operators)));
        Stack<String> stack = new Stack<String>();
        for(int i = tokens.length - 1; i >= 0; i--){
            String a = tokens[i];
            while(!operations.contains(a) && !stack.isEmpty()&& !operations.contains(stack.peek())){
                int b = Integer.parseInt(stack.pop());
                switch (stack.pop().toCharArray()[0]){
                    case '+': a = String.valueOf(Integer.parseInt(a) + b);
                        break;
                    case '-': a = String.valueOf(Integer.parseInt(a) - b);
                        break;
                    case '*': a = String.valueOf(Integer.parseInt(a) * b);
                        break;
                    case '/': a = String.valueOf(Integer.parseInt(a) / b);
                        break;
                }
            }
            stack.push(String.valueOf(a));
        }
        return Integer.parseInt(stack.pop());
    }
}
