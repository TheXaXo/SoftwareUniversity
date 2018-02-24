package repositories;

import entities.Kitten;

import java.util.List;

public class KittenRepository extends BaseRepository {
    public void createKitten(Kitten kitten) {
        this.execute(result -> this.entityManager.persist(kitten));
    }

    @SuppressWarnings("unchecked")
    public Kitten[] getAllKittens() {
        Kitten[] allKittens = (Kitten[]) this.execute(actionResult -> {
            List<Kitten> kittens = this.entityManager.createNativeQuery("SELECT * FROM kittens AS k", Kitten.class)
                    .getResultList();

            Kitten[] kittenArray = new Kitten[kittens.size()];

            int i = 0;
            for (Kitten kitten : kittens) {
                kittenArray[i++] = kitten;
            }

            actionResult.setResult(kittenArray);
        }).getResult();

        return allKittens;
    }
}