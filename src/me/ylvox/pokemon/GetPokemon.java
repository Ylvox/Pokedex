package me.ylvox.pokemon;

import java.util.Scanner;

public class GetPokemon {
    
    public static String pokemonUrl;
    private static String pokemon;

    public static void getPokemon(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome do pokemon: ");
        pokemon = scanner.next();
        getPokeUrl();
    }

    private static void getPokeUrl(){

        pokemonUrl = "https://pokeapi.co/api/v2/pokemon/" + pokemon;

    }

}