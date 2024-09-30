public class Model{
  private Viewer viewer;
  private String temp;
  private char action;
  private MyStack stack;
  public Model(Viewer viewer){
    this.viewer = viewer;
    temp = "";
    action = '';
  }
  public void doAction(String command){
    System.out.println(command);
  }
}
