import java.util.Iterator;

public class ForthHomework {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();
        myList.add("Hello");
        myList.add("123");
        myList.add("456");
        myList.add("789");
        //myList.delete("789");
        myList.update(4,"45678");
        if(myList.query("45678")==1){
            System.out.println("查找成功");
        }else System.out.println("查找失败");
    }
}
