package barracksWars.contracts;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType) throws IllegalArgumentException;
}
