package pl.sda.poznan;

import pl.sda.poznan.collections.array.ArrayListCustom;
import pl.sda.poznan.collections.array.MyList;

public class Application {
    public static void main(String[] args) {
        MyList stringList = new ArrayListCustom(3);

        //add
        stringList.add("aaa");
        stringList.add("bbb");
        stringList.add("ccc");

        System.out.println(stringList.get(0));
        System.out.println(stringList.get(1));
        System.out.println(stringList.get(2));

        stringList.add("ddd");
        System.out.println(stringList.get(3));

        //clear
        //stringList.clear();

        // get
        try{
            stringList.get(9);
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Nie ma elementu o takim indeksie");
        }

        //removeFromEnd
        stringList.removeFromEnd();
        System.out.println(stringList.get(3));


    }
}
