public class Main {
    public static void main(String args[]) {
        BackendServerRPN backend = new BackendServerRPN(9876);
        backend.startServer();

        // Manual fast test RPN
        //
        // String infix = "12+21";
        // RPN rpn = new RPN();
        // String postfix = rpn.toPostfix(infix);
        // System.out.println(postfix);
        // double res = rpn.doMath(postfix);
        // System.out.println(res);
    }
}
