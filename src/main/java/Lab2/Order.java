package Lab2;

import static java.util.Objects.isNull;

public class Order {

    private Hotel chosenHotel;
    private Room chosenRoom;
    private int numberOfNights;
    private int numberOfPeople;
    public double totalCost = 0;

    public Order() {
    }

    public Order(Hotel chosenHotel, Room chosenRoom, int numberOfNights, int numberOfPeople) {
        validateHotel(chosenHotel);
        validateRoom(chosenRoom);
        validateNumberOfNights(numberOfNights);
        validateNumberOfPeople(numberOfPeople);
        this.chosenHotel = chosenHotel;
        this.chosenRoom = chosenRoom;
        this.numberOfNights = numberOfNights;
        this.numberOfPeople = numberOfPeople;
        setTotalCost();
    }

    private void setTotalCost() {
        totalCost = chosenRoom.getPricePerNightPerPerson() * numberOfNights * numberOfPeople;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setChosenHotel(Hotel chosenHotel) {
        this.chosenHotel = chosenHotel;
    }

    public Hotel getChosenHotel() {
        return chosenHotel;
    }

    public void setChosenRoom(Room chosenRoom) {
        this.chosenRoom = chosenRoom;
    }

    public Room getChosenRoom() {
        return chosenRoom;
    }

    public void setNumberOfNights(int numberOfNights) {
        validateNumberOfNights(numberOfNights);
        this.numberOfNights = numberOfNights;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        validateNumberOfPeople(numberOfPeople);
        this.numberOfPeople = numberOfPeople;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    private void validateHotel(Hotel hotel) {
        if (isNull(hotel)) {
            throw new IllegalArgumentException("Hotel cannot be null!");
        }
    }

    private void validateRoom(Room room) {
        if (isNull(room)) {
            throw new IllegalArgumentException("Room cannot be null!");
        }
    }

    private void validateNumberOfNights(int numberOfNights) {
        if (numberOfNights <= 0) {
            throw new IllegalArgumentException("Number of nights cannot be less than 1!");
        }
    }

    private void validateNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException("Number of people cannot be less than 1!");
        }
    }
}
