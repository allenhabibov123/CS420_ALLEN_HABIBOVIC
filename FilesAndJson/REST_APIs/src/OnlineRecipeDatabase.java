import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class OnlineRecipeDatabase {

    String baseUrl = "http://www.recipepuppy.com/api/?";

    public JsonObject getRecipesByIngredients(String ingredients) throws Exception
    {
        //Getting the things ready to connect to the web
        URL url = new URL(baseUrl+"i="+ingredients);
/* TODO 
You have to use the url to retrieve the contents of the website. 
This will be a String, but in JSON format. */
        String contents = "";
        try {
            Scanner urlScanner = new Scanner(url.openStream());
            while(urlScanner.hasNextLine()){
                contents += urlScanner.nextLine();
            }
            urlScanner.close();
        }catch(IOException e){
            System.out.println("Could not read the webpage: " + e.toString());
        }
        JsonObject document = (JsonObject)Jsoner.deserialize(contents, new JsonObject());
        System.out.println(document.toString());
        return document;/* TODO
Remember to return a JSON object.*/
    }

    public JsonObject getRecipesByDish(String dish) throws Exception
    {
        //Getting the things ready to connect to the web
        /* TODO 
Fill in this data type (Object) */ URL url = new URL(baseUrl+"q="+dish);/* TODO
Fill in this datatype (Object) */

       /* TODO
Read the information coming from the web
 */
        String contents = "";
        try {
            Scanner urlScanner = new Scanner(url.openStream());
            while(urlScanner.hasNextLine()){
                contents += urlScanner.nextLine();
            }
            urlScanner.close();
        }catch(IOException e){
            System.out.println("Could not read the webpage: " + e.toString());
        }
        JsonObject document = (JsonObject)Jsoner.deserialize(contents, new JsonObject());
        return document;
    }


    public String formatRecipeAsString(JsonObject doc){
        String results = "";
        /* TODO 
This should return a String with each recipe in three lines:
Title:the title of the recipe
Link:the link to the recipe
Ingredients:The ingredients of teh recipe.*/
        JsonArray results_json = (JsonArray) doc.get("results");

        for(int i = 0; i < results_json.size(); i++) {
            JsonObject curr_result = (JsonObject) results_json.get(i);
            String title = (String) curr_result.get("title");
            results += title + "\n";
            String link = (String) curr_result.get("href");
            results += link + "\n";
            String ingredients = (String) curr_result.get("ingredients");
            results += ingredients + "\n";
        }

        return results;
    }

    public void saveRecipes(String text, String outfile){
        /* TODO
Given a String with some text in it, write that text to a file. 
The name of the file is given in outfile */
        try (FileOutputStream fout = new FileOutputStream(outfile)){
            fout.write(text.getBytes());
        }catch(IOException e) {
            e.printStackTrace();
        }

    }

}
