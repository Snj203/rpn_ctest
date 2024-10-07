public class RPN{
  private String inf;
  private String postf;
  public RPN(){
    postf = "";
  }
  private static int prec(char c) {
    if (c == '/' || c == '*'){
      return 2;
    } else if (c == '+' || c == '-'){
      return 1;
    } else{
      return -1;
    }
  }
  public static String toPostfix(String s) {
    String postf = "";
    MyStack stack = new MyStack();
    try{
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
          // If an operand
        if (Character.isDigit(c) || c == '.') {
            while (i < s.length() && (Character.isLetterOrDigit(s.charAt(i)) || s.charAt(i) == '.')) {
                postf += s.charAt(i);
                i++;
            }
            i--;
            postf += " ";
        }
        else if (c == '(') {
          stack.push(String.valueOf(c));
        }
        else if (c == ')') {
          while (!stack.isEmpty() && !stack.peek().equals("(")){
            postf += stack.pop() + " ";
          }
            stack.pop();
        }
          // If an operator is scanned
        else {
          if(c == '-'
              && Character.isDigit(s.charAt(i+1))
              && (i == 0 || !Character.isDigit(s.charAt(i-1)) && s.charAt(i - 1) != ')')){
            postf += "-";
          } else{
            while (!stack.isEmpty() && (prec(s.charAt(i)) <= prec(stack.peek().charAt(0)))){
              postf += stack.pop() + " ";
            }
            stack.push(String.valueOf(c));
          }
        }
      }
      while (!stack.isEmpty()) {
        postf += stack.pop();
      }
      return(postf);
    }
    catch(Exception e){
      return("ERR Something gone wrong, clear and retry");
    }
  }
  public static double doMath(String s){
    double operand1,operand2,result;
    result = -1.0;
    String [] arr = s.split(" ");
    MyStack stack = new MyStack();
    for(String e : arr){
      if(e.length() > 1 || (e.length() == 1 && Character.isDigit(e.charAt(0)))){
        operand1 = Double.parseDouble(e);
        stack.push(String.valueOf(operand1));
      }
      else{
        try{
          operand2 = Double.valueOf(stack.pop());
          operand1 = Double.valueOf(stack.pop());
        }
        catch(Exception ee){
          System.out.println("Stack pop gone bad");
          return 0.0;
        }
        try{
          switch(e){
            case("+"):
              result = operand1 + operand2;
              break;
            case("-"):
              result = operand1 - operand2;
              break;
            case("*"):
              result = operand1 * operand2;
              break;
            case("/"):
              result = operand1 / operand2;
              break;
          }
          stack.push(String.valueOf(result));
        }
        catch(Exception exc){
          System.out.println("Something gone bad");
        }
      }
    }
    return result;
  }
}
