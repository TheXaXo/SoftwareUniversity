package PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        ArrayList<Trainer> trainers = new ArrayList<>();

        while (!command.equals("Tournament")) {
            String[] tokens = command.split(" ");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (trainers.stream().anyMatch(trainer -> trainer.getName().equals(trainerName))) {
                Optional<Trainer> trainerToModify = trainers.stream().filter(trainer -> trainer.getName().equals(trainerName)).findFirst();

                if (trainerToModify.isPresent()) {
                    trainerToModify.get().addPokemon(pokemon);
                }
            } else {
                Trainer trainer = new Trainer(trainerName);

                trainer.addPokemon(pokemon);
                trainers.add(trainer);
            }

            command = reader.readLine();
        }

        command = reader.readLine();

        while (!command.equals("End")) {
            String element = command;

            for (Trainer trainer : trainers) {
                if (trainer.getPokemons().stream().anyMatch(pokemon -> pokemon.getElement().equals(element))) {
                    trainer.addbadge();
                } else {
                    Iterator<Pokemon> pokemonsIter = trainer.getPokemons().iterator();

                    while (pokemonsIter.hasNext()) {
                        Pokemon pokemon = pokemonsIter.next();

                        try {
                            pokemon.decrementHealth();
                        } catch (IllegalStateException ex) {
                            pokemonsIter.remove();
                        }
                    }
                }
            }

            command = reader.readLine();
        }

        trainers.stream()
                .sorted(Comparator.<Trainer>comparingInt(trainer -> trainer.getBadgesCount())
                        .reversed())
                .forEach(trainer -> System.out.printf("%s %d %d%n",
                        trainer.getName(), trainer.getBadgesCount(), trainer.getPokemons().size()));
    }
}