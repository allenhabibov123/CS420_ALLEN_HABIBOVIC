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
        String[] user_ingredients = ingredients.split(",");
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
        JsonArray results_json = (JsonArray) document.get("results");
        JsonArray returns = new JsonArray();
        for(int i = 0; i < results_json.size(); i++) {
            JsonObject curr_result = (JsonObject) results_json.get(i);
            String curr_ingredients_str = (String) curr_result.get("ingredients");

            String[] curr_ingredients = curr_ingredients_str.split(",");
            for(String ing: curr_ingredients){
                for(int j = 0; j < user_ingredients.length; j++) {
                    if(ing.equals(user_ingredients[j])){
                        returns.add(curr_result);
                        break; //avoid multiple adds of same recipe
                    }
                }
            }
        }

        //returns is a JSONArray with all the recipes that contain user input ingredients in their respective ingredients key

        //convert jsonarray returns to a json object w/ key "results": [recipes...,]
        JsonObject jo = new JsonObject();
        jo.put("results", returns);

        return jo;/* TODO
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
        String[] dish_words = dish.split(" "); //assuming dish can be more than 1 word. e.g, apple pie...
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
        JsonArray results_json = (JsonArray) document.get("results");
        JsonArray returns = new JsonArray();
        for(int i = 0; i < results_json.size(); i++) {
            JsonObject curr_result = (JsonObject) results_json.get(i);
            String curr_title_str = (String) curr_result.get("title");

            String[] curr_title_words = curr_title_str.split(" ");
            for(String word: curr_title_words){
                for(int j = 0; j < dish_words.length; j++) {
                    if(word.equals(dish_words[j])){
                        returns.add(curr_result);
                        break;
                    }
                }
            }
        }
        JsonObject jo = new JsonObject();
        jo.put("results", returns);

        return jo;
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
            fout.close();
        }catch(IOException e) {
            System.out.println("Unable to write to file: " + outfile);
            e.printStackTrace();
        }
    }

}
