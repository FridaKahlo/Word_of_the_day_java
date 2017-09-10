import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class Main {
    public static void main(String[] args){
        System.out.println("hello world");

        try {
            String page = RequestHTTP.getHTML("https://dexonline.ro/cuvantul-zilei");
            System.out.println(page);

            Document doc = Jsoup.parse(page);

            String query_image = "img[class=img-responsive center-block]";
            Elements image_url_node = doc.select(query_image);
            String image_url = image_url_node.attr("src");
            System.out.println(image_url);

        }
        catch(Exception error) {
            System.out.println("An error occurred while retrieving the page\n" + error.toString());
        }
    }
}
