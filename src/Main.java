package Word_of_the_day;

/**
 * Created by Liuda on 8/5/2017.
 */

//import
public class Main {
    public static void main(String[] args){
        System.out.println("hello world");
        String page = RequestHTTP.getHTML("http://dexonline.ro");
        System.out.println(page);
    }
}
