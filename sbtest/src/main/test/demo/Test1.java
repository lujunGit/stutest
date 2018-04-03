package demo;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    public static void main(String[] args){
        Map map = new HashMap();
        map.put(null, null);
        System.out.print(map.get(null));
    }
}
