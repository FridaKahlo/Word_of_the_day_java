/**
 * Created by Liuda on 8/5/2017.
 */

//import
public class Main {
    public static void main(String[] args){
        System.out.println("hello world");

        try {
            String page = RequestHTTP.getHTML("https://dexonline.ro");
            System.out.println(page);
        }
        catch(Exception error) {
            System.out.println("An error occurred while retrieving the page\n" + error.toString());
        }
    }
}
