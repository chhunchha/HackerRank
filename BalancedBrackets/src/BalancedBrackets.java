import java.util.Stack;

/**
 * Created by chhunchha on 9/29/16.
 */
public class BalancedBrackets {

    public static boolean isBalanced(String expression) {

        Stack st = new Stack();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                st.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                char poped = st.isEmpty() ? ' ' : (char) st.pop();
                if ((c == ')' && poped != '(') || (c == ']' && poped != '[') || (c == '}' && poped != '{')) {
                    return false;
                }
            }
            System.out.println(st.toString());
        }
        if (st.size() != 0)
            return false;
        else
            return true;
    }

    public static void main(String args[]) {
        String expression = "(a+b+[c*d]+{a-b})";
        System.out.println(isBalanced(expression));

        expression = "(a+b+]c*d]+(a-b})";
        System.out.println(isBalanced(expression));
    }
}
