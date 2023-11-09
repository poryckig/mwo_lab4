package Lab2;

public class Room {

    private int peopleCapacity;
    private double pricePerNightPerPerson;

    public Room() {
    }

    public Room(int peopleCapacity, double pricePerNightPerPerson) {
        validatePeopleCapacity(peopleCapacity);
        validatePricePerNightPerPerson(pricePerNightPerPerson);
        this.peopleCapacity = peopleCapacity;
        this.pricePerNightPerPerson = pricePerNightPerPerson;
    }

    public void setPeopleCapacity(int peopleCapacity) {
        validatePeopleCapacity(peopleCapacity);
        this.peopleCapacity = peopleCapacity;
    }

    public void setPricePerNightPerPerson(double pricePerNightPerPerson) {
        validatePricePerNightPerPerson(pricePerNightPerPerson);
        this.pricePerNightPerPerson = pricePerNightPerPerson;
    }

    public int getPeopleCapacity() {
        return peopleCapacity;
    }

    public double getPricePerNightPerPerson() {
        return pricePerNightPerPerson;
    }

    private void validatePeopleCapacity(int peopleCapacity) {
        if (peopleCapacity <= 0) {
            throw new IllegalArgumentException("People capacity cannot be less than one!");
        }
    }

    private void validatePricePerNightPerPerson(double pricePerNightPerPerson) {
        if (pricePerNightPerPerson <= 0) {
            throw new IllegalArgumentException("Price per night per person cannot be less than one!");
        }
    }
}
