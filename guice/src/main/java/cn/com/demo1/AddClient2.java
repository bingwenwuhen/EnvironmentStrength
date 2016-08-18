package cn.com.demo1;


import com.google.inject.Inject;

/**
 * Created by xiaxuan on 16/8/18.
 */
public class AddClient2 {

    @Inject
    private Add add;

    public void addNumber() {
        System.out.println(add.add(3, 4));
    }

    public static void main(String[] args) {
        new AddClient2().addNumber();
    }
}
