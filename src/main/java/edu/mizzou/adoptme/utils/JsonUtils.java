package edu.mizzou.adoptme.utils;

import com.google.gson.*;
import edu.mizzou.adoptme.model.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final Gson gson = new GsonBuilder().registerTypeAdapter(Pet.class, new PetDeserializer()).create();

    public static List<Pet> loadPetsFromJson(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            
            List<Pet> pets = new ArrayList<>();
            for (JsonElement element : jsonArray) {
                pets.add(gson.fromJson(element, Pet.class));
            }
            
            return pets;
        } catch (IOException error) {
            error.printStackTrace();
        }
        return null;
    }

    public static List<Pet> loadExoticsFromJson(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            ExoticAnimalDTO[] dtos = gson.fromJson(reader, ExoticAnimalDTO[].class);
            
            List<Pet> pets = new ArrayList<>();
            
            for (ExoticAnimalDTO dto : dtos) {
                pets.add(new ExoticAnimalAdapter(dto));
            }
            
            return pets;
        } catch (IOException error) {
            error.printStackTrace();
        }
        return null;
    }

    public static void savePetsToJson(List<Pet> pets, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
        	
            gson.toJson(pets, writer);
            
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    private static class PetDeserializer implements JsonDeserializer<Pet> {
        @Override
        public Pet deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            JsonObject obj = json.getAsJsonObject();

            String name = obj.get("name").getAsString();
            int age = obj.get("age").getAsInt();
            String species = obj.get("species").getAsString();
            boolean adopted = obj.has("adopted") && obj.get("adopted").getAsBoolean();

            AdoptionStatus status = adopted ? AdoptionStatus.ADOPTED : AdoptionStatus.AVAILABLE;
            return new GenericPetImplementation(name, age, species, status);
        }
    }
}
