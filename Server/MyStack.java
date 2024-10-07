import java.util.EmptyStackException;
public class MyStack<T>{
  private Object [] items;
  private int top;
  public MyStack(){
    items = new Object[10];
    top = -1;
  }
  public void push(T item){
    if(top == items.length - 1){
      resize();
    }
    items[++top] = item;
  }
  public T pop(){
    if(isEmpty()){
      throw new EmptyStackException();
    }
    T item = (T)items[top];
    items[top--] = null;
    return item;
  }
  public T peek(){
    if(isEmpty()){
      throw new EmptyStackException();
    }
    return (T)items[top];
  }
  private void resize(){
    Object [] newItems = new Object [items.length + 10];
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
