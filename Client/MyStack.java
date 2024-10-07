import java.util.EmptyStackException;
public class MyStack{
  private String [] items;
  private int top;
  public MyStack(){
    items = new String [10];
    top = -1;
  }
  public void push(String item){
    if(top == items.length - 1){
      resize();
    }
    items[++top] = item;
  }
  public String pop(){
    if(isEmpty()){
      throw new EmptyStackException();
    }
    String item = items[top];
    items[top--] = null;
    return item;
  }
  public String peek(){
    if(isEmpty()){
      throw new EmptyStackException();
    }
    return items[top];
  }
  private void resize(){
    String [] newItems = new String [items.length + 10];
    System.arraycopy(items,0,newItems,0,items.length);
    items = newItems;
  }
  public void clear(){
    for(int i = 0; i < items.length;i++){
      items[i] = null;
    }
    top = -1;
  }
  public void toConsole(){
    for(int i = 0; i < items.length;i++){
      System.out.println(items[i]);
    }
  }
  public boolean isEmpty(){
    return top == -1;
  }
}
