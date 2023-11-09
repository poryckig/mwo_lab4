package Lab2;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class HotelTest {

    private Hotel hotel;

    @Before
    public void setup() {
        hotel = new Hotel();
    }

    @Test
    public void should_CorrectlyCreateHotel_WhenDataAreAppropriate() {
        // arrange
        String name = "Dream Place";
        int amountOfStars = 5;
        Room room1 = new Room();
        Room room2 = new Room();
        ArrayList<Room> listOfRooms = new ArrayList<>();
        listOfRooms.add(room1);
        listOfRooms.add(room2);

        // act
        hotel = new Hotel(name, amountOfStars, listOfRooms);

        // assert
        assertThat(hotel.getName()).isEqualTo("Dream Place");
        assertThat(hotel.getAmountOfStars()).isEqualTo(5);
        assertThat(hotel.getListOfRooms()).isEqualTo(listOfRooms);
    }

    @Test
    public void should_ThrowException_WhenCreatingHotelWithNullName() {
        // arrange
        String name = null;
        int amountOfStars = 5;
        Room room1 = new Room();
        Room room2 = new Room();
        ArrayList<Room> listOfRooms = new ArrayList<>();
        listOfRooms.add(room1);
        listOfRooms.add(room2);

        // act
        Throwable exceptionCaught = catchThrowable(() -> {
            hotel = new Hotel(name, amountOfStars, listOfRooms);
        });

        // assert
        String message = "Hotel's name cannot be null!";

        Assertions.assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void should_ThrowException_WhenCreatingHotelWithWrongAmountOfStars() {
        // arrange
        String name = "Dream Place";
        int amountOfStars = -1;
        Room room1 = new Room();
        Room room2 = new Room();
        ArrayList<Room> listOfRooms = new ArrayList<>();
        listOfRooms.add(room1);
        listOfRooms.add(room2);

        // act
        Throwable exceptionCaught = catchThrowable(() -> {
            hotel = new Hotel(name, amountOfStars, listOfRooms);
        });

        // assert
        String message = "Hotel's amount of stars cannot be less than 0!";

        Assertions.assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void should_ThrowException_WhenCreatingHotelWithNullListOfRooms() {
        // arrange
        String name = "Dream Place";
        int amountOfStars = 4;
        ArrayList<Room> listOfRooms = null;

        // act
        Throwable exceptionCaught = catchThrowable(() -> {
            hotel = new Hotel(name, amountOfStars, listOfRooms);
        });

        // assert
        String message = "List of rooms cannot be null!";

        Assertions.assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void should_NotThrowException_WhenCreatingHotelWithAmountOfStarsVarious(int amountOfStars) {
        // arrange
        String name = "Dream Place";
        Room room1 = new Room();
        Room room2 = new Room();
        ArrayList<Room> listOfRooms = new ArrayList<>();
        listOfRooms.add(room1);
        listOfRooms.add(room2);

        // act
        hotel = new Hotel(name, amountOfStars, listOfRooms);

        // then
        assert true;
    }

    @Test
    public void should_CorrectlyAddRoom() {
        // arrange
        String name = "Dream Place";
        int amountOfStars = 5;
        ArrayList<Room> listOfRooms = new ArrayList<>();

        // act
        hotel = new Hotel(name, amountOfStars, listOfRooms);

        int numberOfRoomsBeforeAddition = hotel.numberOfRoomsInHotel();
        Room room1 = new Room();
        hotel.addRoom(room1);
        int numberOfRoomsAfterAddition = hotel.numberOfRoomsInHotel();

        // assert
        assertThat(numberOfRoomsBeforeAddition).isEqualTo(0);
        assertThat(numberOfRoomsAfterAddition).isEqualTo(1);
    }

    @Test
    public void should_CorrectlyDeleteRoom() {
        // arrange
        String name = "Dream Place";
        int amountOfStars = 5;
        ArrayList<Room> listOfRooms = new ArrayList<>();

        Room room = new Room();
        listOfRooms.add(room);

        // act
        hotel = new Hotel(name, amountOfStars, listOfRooms);

        int numberOfRoomsBeforeDeletion = hotel.numberOfRoomsInHotel();
        hotel.deleteRoom(room);
        int numberOfRoomsAfterDeletion = hotel.numberOfRoomsInHotel();

        // assert
        assertThat(numberOfRoomsBeforeDeletion).isEqualTo(1);
        assertThat(numberOfRoomsAfterDeletion).isEqualTo(0);
    }

    @Test
    public void should_ThrowException_WhenDeleteionWrongRoom() {
        // arrange
        String name = "Dream Place";
        int amountOfStars = 5;
        ArrayList<Room> listOfRooms = new ArrayList<>();

        Room room1 = new Room();
        listOfRooms.add(room1);
        hotel = new Hotel(name, amountOfStars, listOfRooms);

        // act
        Room room2 = new Room();

        Throwable exceptionCaught = catchThrowable(() -> {
            hotel.deleteRoom(room2);
        });

        // assert
        String message = "Cannot delete a room which doesn't exist in hotel!";

        Assertions.assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void should_Correctly_ReturnNumberOfRoomsInHotel() {
        // arrange
        String name = "Dream Place";
        int amountOfStars = 5;
        Room room1 = new Room();
        Room room2 = new Room();
        ArrayList<Room> listOfRooms = new ArrayList<>();
        listOfRooms.add(room1);
        listOfRooms.add(room2);

        hotel = new Hotel(name, amountOfStars, listOfRooms);

        // act
        int numberOfRoomsInHotel = hotel.numberOfRoomsInHotel();

        // assert
        assertThat(numberOfRoomsInHotel).isEqualTo(2);
    }

    @Test
    public void should_CorrectlySetName_WhenNameIsGiven() {
        // arrange
        String name = "Dream Place";

        // act
        hotel.setName(name);

        // assert
        assertThat(hotel.getName()).isEqualTo("Dream Place");
    }

    @Test
    public void should_CorrectlySetAmountOfStars_WhenAmountOfStarsGiven() {
        // arrange
        int amountOfStars = 4;

        // act
        hotel.setAmountOfStars(amountOfStars);

        // assert
        assertThat(hotel.getAmountOfStars()).isEqualTo(4);
    }

    @Test
    public void should_CorrectlySetListOfRooms_WhenListOfRoomsIsGiven() {
        // arrange
        Room room1 = new Room();
        Room room2 = new Room();
        ArrayList<Room> listOfRooms = new ArrayList<>();
        listOfRooms.add(room1);
        listOfRooms.add(room2);

        // act
        hotel.setListOfRooms(listOfRooms);

        // assert
        assertThat(hotel.getListOfRooms()).isEqualTo(listOfRooms);
    }

    @Test
    public void should_CorrectlyGetName() {
        // arrange
        String name = "Dream Place";
        hotel.setName(name);

        // act
        String returnedName = hotel.getName();

        // assert
        assertThat(returnedName).isEqualTo("Dream Place");
    }

    @Test
    public void should_CorrectlyGetAmountOfStars() {
        // arrange
        int amountOfStars = 1;
        hotel.setAmountOfStars(amountOfStars);

        // act
        int returnedAmountOfStars = hotel.getAmountOfStars();

        // assert
        assertThat(returnedAmountOfStars).isEqualTo(1);
    }

    @Test
    public void should_CorrectlyGetListOfRooms() {
        // arrange
        Room room1 = new Room();
        Room room2 = new Room();
        ArrayList<Room> listOfRooms = new ArrayList<>();
        listOfRooms.add(room1);
        listOfRooms.add(room2);

        hotel.setListOfRooms(listOfRooms);

        // act
        ArrayList<Room> returnedListOfRooms = hotel.getListOfRooms();

        // assert
        assertThat(returnedListOfRooms).isEqualTo(listOfRooms);
    }
}
