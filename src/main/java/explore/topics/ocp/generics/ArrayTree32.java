package explore.topics.ocp.generics;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class ArrayTree32 {
    public static void main(String[] args) {


        Set<MySetPojo> setExamplePojo = new TreeSet<>();
        MySetPojo pj1 = new MySetPojo("V", 3);
        MySetPojo pj2 = new MySetPojo("A", 4);
        MySetPojo pj3 = new MySetPojo("S", 2);
        MySetPojo pj4 = new MySetPojo("E", 1);
        setExamplePojo.add(pj1);
        setExamplePojo.add(pj2);
        setExamplePojo.add(pj3);
        setExamplePojo.add(pj4);
        setExamplePojo.stream().forEach(System.out::println);
    }


}

class MySetPojo {
    private String pojoName;
    private Integer pojoType;

    public MySetPojo(String pojoName, Integer pojoType) {
        this.pojoName = pojoName;
        this.pojoType = pojoType;
    }

    @Override
    public String toString() {
        return "MySetPojo{" +
                "pojoName='" + pojoName + '\'' +
                ", pojoType=" + pojoType +
                '}';
    }

}
