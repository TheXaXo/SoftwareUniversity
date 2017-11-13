package entities.interfaces;

public interface ChemicalIngredient extends Ingredient {
    String getChemicalFormula();

    void setChemicalFormula(String chemicalFormula);
}