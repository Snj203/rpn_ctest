public class Model{
  private Viewer viewer;
  private String toRPN;
  private char action;
  private String result;
  private String temp;
  private ClientForBackendServerRPN client;
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
        break;
      case ("One"):
        toRPN = toRPN + "1";
        break;
      case ("Two"):
        toRPN = toRPN + "2";
        break;
      case ("Three"):
        toRPN = toRPN + "3";
        break;
      case ("Four"):
        toRPN = toRPN + "4";
        break;
      case ("Five"):
        toRPN = toRPN + "5";
        break;
      case ("Six"):
        toRPN = toRPN + "6";
        break;
      case ("Seven"):
        toRPN = toRPN + "7";
        break;
      case ("Eight"):
        toRPN = toRPN + "8";
        break;
      case ("Nine"):
        toRPN = toRPN + "9";
        break;
      case ("Plus"):
        toRPN = toRPN + "+";
        temp = "";
        break;
      case ("Minus"):
        toRPN = toRPN + "-";
        temp = "-";
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
        break;
      case ("OpenBracket"):
        toRPN = toRPN + "(";
        break;
      case ("CloseBracket"):
        toRPN = toRPN + ")";
        break;
      case ("ChangeSign"):
        System.out.println(toRPN);
        toRPN = changeSign(toRPN);
        System.out.println(toRPN);
        break;
      case ("DeleteLeft"):
        if(toRPN.length() >= 1){
          toRPN = toRPN.substring(0,toRPN.length() - 1);
        }
        else{
          toRPN = "0";
        }
        break;
      case ("Clear"):
        action = '@';
        toRPN = "";
        result = "";
        break;
      case ("Equal"):
        result = client.doRPN(toRPN);
        System.out.println(" [" + result + "] MODEL");
        result = formatResult(result);
        System.out.println(result);
      }
      viewer.update(toRPN,result);
  }
  private static String changeSign(String s){
    for(int i = s.length() - 1;i >= 0; i--){
      if(!Character.isDigit(s.charAt(i))) {
        if(s.charAt(i) == '-'){
          String temp = s.substring(0,i) + "+" + s.substring(i + 1, s.length());
          s = temp;
          return temp;
        } else if(s.charAt(i) == '+'){
          String temp = s.substring(0,i) + "-" + s.substring(i + 1, s.length());
          s = temp;
          return temp;
        }
      }
      else{
        System.out.println("Nothing to change");
      }
    }
    return s;
  }
  private String formatResult(String s){
    char c1,c2;
    c1 = s.charAt(s.length() - 1);
    c2 = s.charAt(s.length() - 2);
    if(c1 == '0' && c2 == '.'){
      s = s.substring(0,s.indexOf('.'));
    }
    return s;
  }
}
