package me.ylvox.main;

import java.util.Scanner;

import me.ylvox.pokemon.GetPokemon;
import me.ylvox.pokemon.PokemonRequest;

public class App {
    public static void main(String[] args) throws Exception {

        boolean loop = true;
        while(loop){

            PokemonRequest pokeReq = new PokemonRequest();
            //fluxo principal de pesquisa de pokemons
            GetPokemon.getPokemon();
            pokeReq.getPokeJson();
            //Pergunta se quer realizar outra pesquisa
            loop = opContinue();
        }

    }

    public static boolean opContinue(){
        boolean loop = false;
        int op;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Deseja pesquisar outro pokemon?");
        System.out.println("1 - Sim");
        System.out.println("0 - Nao");
        op = scanner.nextInt();
        if(op == 1){
            loop = true;
        }

        return loop;
    }

}