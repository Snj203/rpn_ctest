public class MyStack{
  private Character [] items;
  private int top;
  public MyStack(){
    items = new Character[10];
    top = -1;
  }
  public void push(char item){
    if(top == items.length - 1){
      resize();
    }
    items[++top] = item;
  }
  public Character pop(){
    if(top == 0){
      throw new RuntimeException();
    }
    Character item = items[top];
    items[top] = null;
    top--;
    return item;
  }
  private void resize(){
    Character [] newItems = new Character [items.length * 3 / 2];
    System.arraycopy(items,0,newItems,0,newItems.length);
    items = newItems;
  }
  public void clear(){
    for(int i = 0; i < items.length;i++){
      items[i] = null;
    }
    top = -1;
  }
  public void toConsole(){
    for(Character e : items){
      if(e == null){
        break;
      }
      System.out.print( e + " ");
    }
  }
}
