package contracts;

import exeptions.DuplicateModelException;
import models.boats.Boat;

import java.util.List;
import java.util.Map;

public interface Race {
    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    Boolean getAllowsMotorboats();

    void addParticipant(Boat boat) throws DuplicateModelException;

    Repository<Boat> getRegisteredBoatsRepository();

    List<Map.Entry<Boat, Double>> getWinners(int winnersCount);
}