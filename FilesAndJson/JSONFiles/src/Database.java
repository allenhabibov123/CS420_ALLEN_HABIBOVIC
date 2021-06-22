import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

public class Database {
    /* TODO 
Declare a member variable that can 
be EASILY set from the constructor. */
    private JsonObject data;

    public Database(JsonObject data){
        /* TODO 
set the memebr variable declared above.*/
        this.setData(data);
    }

    public void setData(JsonObject data) {
        this.data = data;
    }

    public JsonObject getRestaurant(String name){
        /* TODO 
Complete this method as specified. */
        JsonObject result = null;
        JsonArray restaurants = (JsonArray) this.data.get("restaurants");

        for(int i = 0; i < restaurants.size(); i++){
            JsonObject curr_restaurant = (JsonObject) restaurants.get(i);
            String curr_restaurant_name = (String) curr_restaurant.get("name");

            if(curr_restaurant_name.equals(name)) {
                result = (JsonObject) restaurants.get(i);
            }
        }
        return result;
    }

    public double getAvgReviews(String name){
        /* TODO 
Complete this method as specified.
 The previous method may be of help. 
*/
        JsonObject restaurant = this.getRestaurant(name);
        double avg_review = 0.0;

        JsonArray reviews = (JsonArray) restaurant.get("reviews");
        Integer rating_total = 0;
        for(int i = 0; i < reviews.size(); i++) {
            JsonObject curr_review = (JsonObject) reviews.get(i);
            rating_total += Integer.parseInt(curr_review.get("rating").toString());
        }
        double ratings = (double)rating_total;
        avg_review = ratings/((double)reviews.size());
        return avg_review;
    }
}
