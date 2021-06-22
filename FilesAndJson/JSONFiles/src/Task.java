import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task {
    public static void main(String[] args){
        Task t = new Task();
        JsonObject doc = t.readJson("./resources/restaurant-data.json");
        Database db = new Database(doc);
        System.out.println(db.getRestaurant("Hometown BBQ"));
        System.out.println(db.getAvgReviews("Casa Enrique"));
    }

    public String readFile(String filename) {
        String contents = "";
        try( BufferedReader br = new BufferedReader(new FileReader(filename));) {
            String s = br.readLine();

            while(s != null) {
                contents += s;
                s = br.readLine();
            }
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }

        return contents;
    }

    public JsonObject readJson(String fi) {
        String json = this.readFile(fi);
        JsonObject document = (JsonObject)Jsoner.deserialize(json, new JsonObject());
        return document;
    }
}