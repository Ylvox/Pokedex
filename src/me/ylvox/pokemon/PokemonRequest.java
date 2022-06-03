package me.ylvox.pokemon;

import org.json.JSONArray;
import org.json.JSONObject;
import me.ylvox.network.HTTPRequest;

public class PokemonRequest {

    GetPokemon getpokeImg = new GetPokemon();
    public static String pokeImgUrl;
    private String pokeAscii;
    
    public void getPokeJson() throws Exception{

        JSONObject object = new HTTPRequest().requestGetMethod(GetPokemon.pokemonUrl);
        pokeImgUrl = object.getJSONObject("sprites").getJSONObject("other").getJSONObject("official-artwork").getString("front_default");
        getpokeImg.getPokeImgUrl();

        //Montando estrutura de informacoes do pokemon
        String pokeName = object.getString("name");
        int pokeHeight = object.getInt("height");
        int pokeWeight = object.getInt("weight");
        int baseExp = object.getInt("base_experience");
        JSONArray abilitiesArray = object.getJSONArray("abilities");
        JSONArray movesArray = object.getJSONArray("moves");
        JSONArray statsArray = object.getJSONArray("stats");
        JSONArray typesArray = object.getJSONArray("types");

        //Printando informacoes
        System.out.println("-----------------------------------");
        System.out.println("Nome: " + pokeName);
        System.out.println("Altura: " + pokeHeight);
        System.out.println("Peso: " + pokeWeight);
        System.out.println("Experiencia base: " + baseExp);
        System.out.println("------------HABILIDADES------------");
        for(int i = 0; i < abilitiesArray.length(); i++){

            JSONObject pokeObject = abilitiesArray.getJSONObject(i);
            String pokeAbilityName = pokeObject.getJSONObject("ability").getString("name");
            System.out.println(i+1 + " - " + pokeAbilityName);

        }
        System.out.println("-------------MOVIMENTOS-------------");
        for(int i = 0; i < movesArray.length(); i++){

            JSONObject pokeObject = movesArray.getJSONObject(i);
            String pokeMoveName = pokeObject.getJSONObject("move").getString("name");
            System.out.println(i+1 + " - " + pokeMoveName);

        }
        System.out.println("------------ESTATISTICAS------------");
        for(int i = 0; i < statsArray.length(); i++){

            JSONObject pokeObject = statsArray.getJSONObject(i);
            int baseStat = pokeObject.getInt("base_stat");
            int effortValue = pokeObject.getInt("effort");
            String statName = pokeObject.getJSONObject("stat").getString("name");
            System.out.println(i+1 + " - " + statName + " Status base: " + baseStat + " Esforco base: " + effortValue);

        }
        System.out.println("------------TIPOS------------");
        for(int i = 0; i < typesArray.length(); i++){

            JSONObject pokeObject = typesArray.getJSONObject(i);
            String typeName = pokeObject.getJSONObject("type").getString("name");
            System.out.println(i+1 + ": " + typeName);

        }
        System.out.println("------------IMAGEM------------");

        pokeAscii = new HTTPRequest().requestGetMethodImg(getpokeImg.pokemonImgUrl).replaceAll("<br>", "\n").replaceAll("\\<.*?>", "");
        System.out.println(pokeAscii);

        System.out.println("-----------------------------------");

        // https://process.filestackapi.com/AP2z0mphR56Dq0yTmJPIDz/ascii=size:80,reverse:true/URL-IMAGE
    }

}