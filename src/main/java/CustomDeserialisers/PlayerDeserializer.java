package CustomDeserialisers;

import Entities.Area;
import Entities.Command;
import Entities.Player;
import Entities.Stat;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PlayerDeserializer implements JsonDeserializer<Player> {

    @Override
    public Player deserialize(JsonElement json,
                            Type typeOfT,
                            JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        Stat stat = new Stat(
                jsonObject.get("stat").getAsJsonObject().get("name").getAsString(),
                jsonObject.get("stat").getAsJsonObject().get("value").getAsInt()
        );

        return new Player(
                jsonObject.get("type").getAsString(),
                jsonObject.get("name").getAsString(),
                jsonObject.get("description").getAsString(),
                createArray(jsonObject.get("inventory").getAsJsonArray()),
                jsonObject.get("active").getAsBoolean(),
                jsonObject.get("currentLocation").getAsString(),
                stat,
                createCommandArray(jsonObject.get("commands").getAsJsonArray())

        );
    }

    private ArrayList<String> createArray(JsonArray jArray) {
        ArrayList<String> arrayList = new ArrayList<>();

        if (jArray != null) {
            for (JsonElement e : jArray) {
                arrayList.add(e.getAsString());
            }
        }

        return arrayList;
    }

    private ArrayList<Command> createCommandArray(JsonArray jArray) {
        ArrayList<Command> arrayList = new ArrayList<>();

        if (jArray != null) {
            for (JsonElement e : jArray) {
                arrayList.add(createObject(e.getAsJsonObject()));
            }
        }

        return arrayList;
    }

    private Command createObject(JsonObject jObject) {
        return new Command(
                jObject.get("name").getAsString(),
                jObject.get("function").getAsString(),
                createArray(jObject.get("params").getAsJsonArray())
        );
    }
}