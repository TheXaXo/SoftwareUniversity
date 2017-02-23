package Google;

import java.util.ArrayList;

public class Person {
    private String name;
    private Company company;
    private ArrayList<Pokemon> pokemons;
    private ArrayList<Relative> parents;
    private ArrayList<Relative> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ArrayList<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public ArrayList<Relative> getParents() {
        return this.parents;
    }

    public void addParent(Relative parent) {
        this.parents.add(parent);
    }

    public ArrayList<Relative> getChildren() {
        return this.children;
    }

    public void addChild(Relative child) {
        this.children.add(child);
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        out.append(this.getName()).append("\r\n");

        out.append("Company:").append("\r\n");
        if (this.company != null) {
            out.append(String.format("%s %s %.2f%n",
                    this.getCompany().getName(), this.company.getDepartment(), this.company.getSalary()));
        }

        out.append("Car:").append("\r\n");
        if (this.car != null) {
            out.append(String.format("%s %d%n", this.getCar().getModel(), this.getCar().getSpeed()));
        }

        out.append("Pokemon:").append("\r\n");
        for (Pokemon pokemon : this.getPokemons()) {
            out.append(String.format("%s %s%n", pokemon.getName(), pokemon.getType()));
        }

        out.append("Parents:").append("\r\n");
        for (Relative parent : this.getParents()) {
            out.append(String.format("%s %s%n", parent.getName(), parent.getBirthday()));
        }

        out.append("Children:").append("\r\n");
        for (Relative child : this.getChildren()) {
            out.append(String.format("%s %s%n", child.getName(), child.getBirthday()));
        }

        return out.toString();
    }
}