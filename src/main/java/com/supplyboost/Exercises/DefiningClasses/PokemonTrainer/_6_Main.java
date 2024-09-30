package com.supplyboost.Exercises.DefiningClasses.PokemonTrainer;

import java.util.*;

public class _6_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lines = scanner.nextLine().split("\\s");

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!lines[0].equals("Tournament")){
            String trainerName = lines[0];
            String pokemonName = lines[1];
            String pokemonElement = lines[2];
            int pokemonHealth = Integer.parseInt(lines[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if(!trainers.containsKey(trainerName)){
                trainers.put(trainerName, new Trainer(trainerName));
            }
            trainers.get(trainerName).getPokemons().add(pokemon);

            lines = scanner.nextLine().split("\\s");
        }

        lines = scanner.nextLine().split("\\s");

        List<String> elements = new ArrayList<>();
        while (!lines[0].equals("End")){
            String element = lines[0];
            elements.add(element);
            lines = scanner.nextLine().split("\\s");
        }

        checkTrainersPokemons(elements, trainers);

        Comparator<Trainer> sortEvenToOdd = (trainer1, trainer2) -> {
            if(trainer1.getBadges() > trainer2.getBadges()){
                return -1;
            }else if(trainer1.getBadges() < trainer2.getBadges()){
                return 1;
            }
            return 0;
        };

        List<Trainer> comparedTrainers= new ArrayList<>(trainers.values().stream().sorted(sortEvenToOdd).toList());


        comparedTrainers.forEach(trainer -> System.out.printf("%s %d %d\n", trainer.getName(), trainer.getBadges(), trainer.getPokemons().size()));
    }
    public static void checkTrainersPokemons(List<String> elements, Map<String, Trainer> trainerMap){

        for (Map.Entry<String, Trainer> entry : trainerMap.entrySet()){
            int damage = 0;
            for(String element : elements){
                if(!entry.getValue().checkElement(element)){
                    damage += 10;
                }else{
                    entry.getValue().setBadges(entry.getValue().getBadges() + 1);
                }
            }

            List<Pokemon> deadPokemons = new ArrayList<>();
            for(Pokemon pokemon : entry.getValue().getPokemons()){
                pokemon.setHealth(pokemon.getHealth() - damage);
                if(pokemon.getHealth() <= 0){
                    deadPokemons.add(pokemon);
                }
            }
            deadPokemons.forEach(pokemon -> entry.getValue().getPokemons().remove(pokemon));
        }
    }


}
