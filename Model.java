public class Model{
  private Viewer viewer;
  private String toRPN;
  private char action;
  private String result;
  private String temp;
  private RPN rpn;
  public Model(Viewer viewer){
    this.viewer = viewer;
    toRPN = "";
    result = "";
  }
  public void doAction(String command){
    System.out.println(command);
    switch(command){
      case ("Zero"):
        toRPN = toRPN + "0";
        temp = toRPN;
        break;
      case ("One"):
        toRPN = toRPN + "1";
        temp = toRPN;
        break;
      case ("Two"):
        toRPN = toRPN + "2";
        temp = toRPN;
        break;
      case ("Three"):
        toRPN = toRPN + "3";
        temp = toRPN;
        break;
      case ("Four"):
        toRPN = toRPN + "4";
        temp = toRPN;
        break;
      case ("Five"):
        toRPN = toRPN + "5";
        temp = toRPN;
        break;
      case ("Six"):
        toRPN = toRPN + "6";
        temp = toRPN;
        break;
      case ("Seven"):
        toRPN = toRPN + "7";
        temp = toRPN;
        break;
      case ("Eight"):
        toRPN = toRPN + "8";
        temp = toRPN;
        break;
      case ("Nine"):
        toRPN = toRPN + "9";
        temp = toRPN;
        break;
      case ("Plus"):
        toRPN = toRPN + "+";
        temp = "";
        break;
      case ("Minus"):
        toRPN = toRPN + "-";
        temp = "";
        break;
      case ("Multiply"):
        toRPN = toRPN + "*";
        temp = "";
        break;
      case ("Divide"):
        toRPN = toRPN + "/";
        temp = "";
        break;
      case ("Point"):
        toRPN = toRPN + ".";
        temp = toRPN;
        break;
      case ("OpenBracket"):
        toRPN = toRPN + "(";
        temp = toRPN;
        break;
      case ("CloseBracket"):
        toRPN = toRPN + ")";
        temp = toRPN;
        break;
      case ("DeleteLeft"):
        toRPN = toRPN.substring(0,toRPN.length() - 1);
        temp = toRPN;
        break;
      case ("Clear"):
        action = '@';
        toRPN = "";
        temp = "";
        result = "";
        break;
      case ("Equal"): //-1*2/(-3.8+0.8) |
        rpn = new RPN();

        System.out.println(toRPN);
        result = rpn.toPostfix(toRPN);
        System.out.println(result);
        System.out.println("____________");
        double a = rpn.doMath(result);
        result = String.valueOf(a);
        System.out.println(result);
        result = formatResult(result);
        System.out.println(result);
      }
      viewer.update(temp,result);
  }
  private String formatResult(String s){
    char c1,c2;
    c1 = s.charAt(s.length() - 1);
    c2 = s.charAt(s.length() - 2);
    if(c1 == '0' && c2 == '.'){
      s = s.substring(0,s.indexOf('.'));
    }
    else{
      s = s.substring(0,s.indexOf('.')) + s.substring(s.indexOf('.'),s.indexOf('.') + 6);
    }
    return s;
  }
}
