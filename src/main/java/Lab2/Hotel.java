package Lab2;

import java.util.ArrayList;
import static java.util.Objects.isNull;

public class Hotel {

    private String name;
    private int amountOfStars;
    ArrayList<Room> listOfRooms;

    public Hotel() {
    }

    public Hotel(String name, int amountOfStars, ArrayList<Room> listOfRooms) {
        validateName(name);
        validateAmountOfStars(amountOfStars);
        validateListOfRooms(listOfRooms);

        this.name = name;
        this.amountOfStars = amountOfStars;
        this.listOfRooms = listOfRooms;
    }

    public void addRoom(Room room) {
        validateRoom(room);
        listOfRooms.add(room);
    }

    public void deleteRoom(Room room) {
        validateRoom(room);

        if (listOfRooms.contains(room)) {
            listOfRooms.remove(room);
        }
        else {
            throw new IllegalArgumentException("Cannot delete a room which doesn't exist in hotel!");
        }
    }

    public int numberOfRoomsInHotel() {
        return listOfRooms.size();
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public void setAmountOfStars(int amountOfStars) {
        validateAmountOfStars(amountOfStars);
        this.amountOfStars = amountOfStars;
    }

    public void setListOfRooms(ArrayList<Room> listOfRooms) {
        validateListOfRooms(listOfRooms);
        this.listOfRooms = listOfRooms;
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public int getAmountOfStars() {
        return amountOfStars;
    }

    public ArrayList<Room> getListOfRooms() {
        return listOfRooms;
    }

    private void validateName(String name) {
        if (isNull(name)) {
            throw new IllegalArgumentException("Hotel's name cannot be null!");
        }
    }

    private void validateAmountOfStars(int amountOfStars) {
        if (amountOfStars < 0) {
            throw new IllegalArgumentException("Hotel's amount of stars cannot be less than 0!");
        }
    }

    private void validateListOfRooms(ArrayList<Room> listOfRooms) {
        if (isNull(listOfRooms)) {
            throw new IllegalArgumentException("List of rooms cannot be null!");
        }
    }

    private void validateRoom(Room room) {
        if (isNull(room)) {
            throw new IllegalArgumentException("Room cannot be null!");
        }
    }
}
