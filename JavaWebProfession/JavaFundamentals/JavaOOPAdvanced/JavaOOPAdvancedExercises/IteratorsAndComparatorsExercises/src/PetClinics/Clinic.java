package PetClinics;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Clinic {

    private String name;
    private Pet[] rooms;
    private Deque<Integer> accommodationIndexes;
    private List<Integer> releaseIndexes;

    public Clinic(String name, int roomsCount) {
        this.setName(name);
        this.setRooms(roomsCount);
        this.initializeAccommodationIndexes();
        this.initializeReleaseIndexes();
    }

    public boolean add(Pet pet) {
        if (!accommodationIndexes.isEmpty()) {
            rooms[accommodationIndexes.remove()] = pet;
            return true;
        }
        return false;
    }

    public boolean release() {
        for (int index : this.releaseIndexes) {
            if (this.rooms[index] != null) {
                this.rooms[index] = null;
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        for (Pet pet : this.rooms) {
            if (pet == null) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (Pet pet : this.rooms) {
            if (pet == null) {
                System.out.println("Room empty");
            } else {
                System.out.println(pet);
            }
        }
    }

    public void print(int roomIndex) {
        if (this.rooms[roomIndex] == null) {
            System.out.println("Room empty");
        } else {
            System.out.println(this.rooms[roomIndex]);
        }
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setRooms(int roomsCount) {
        if (roomsCount % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        this.rooms = new Pet[roomsCount];
    }

    private void initializeAccommodationIndexes() {
        this.accommodationIndexes = new ArrayDeque<>();

        int centralRoom = (this.rooms.length - 1) / 2;

        this.accommodationIndexes.add(centralRoom);

        boolean goLeft = true;
        boolean goRight = false;

        int modifier = 1;

        for (int i = 0; i < this.rooms.length - 1; i++) {
            if (goRight) {
                modifier--;
            }

            if (goLeft) {
                goLeft = false;
                goRight = true;

                this.accommodationIndexes.add(centralRoom - modifier);
            } else {
                goLeft = true;
                goRight = false;

                this.accommodationIndexes.add(centralRoom + modifier);
            }
            modifier++;
        }
    }

    private void initializeReleaseIndexes() {
        int centralIndex = (this.rooms.length - 1) / 2;

        this.releaseIndexes = new ArrayList<>();
        this.releaseIndexes.add(centralIndex);

        int nextIndex = centralIndex + 1;

        while (nextIndex <= this.rooms.length - 1) {
            releaseIndexes.add(nextIndex++);
        }

        nextIndex = centralIndex - 1;

        while (nextIndex >= 0) {
            releaseIndexes.add(nextIndex--);
        }
    }
}