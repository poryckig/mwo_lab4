package Lab2;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class OrderTest {

    private Order order;

    @Before
    public void setup() {
        order = new Order();
    }

    @Test
    public void should_CorrectlyCreateOrder_WhenDataAreAppropriate() {
        // arrange
        Hotel chosenHotel = new Hotel();
        Room chosenRoom = new Room();
        int numberOfNights = 4;
        int numberOfPeople = 2;

        // act
        order = new Order(chosenHotel, chosenRoom, numberOfNights, numberOfPeople);

        // assert
        assertThat(order.getChosenHotel()).isEqualTo(chosenHotel);
        assertThat(order.getChosenRoom()).isEqualTo(chosenRoom);
        assertThat(order.getNumberOfNights()).isEqualTo(numberOfNights);
        assertThat(order.getNumberOfPeople()).isEqualTo(numberOfPeople);
    }

    @Test
    public void should_ThrowException_WhenTryingCreateOrderWithNullHotel() {
        // arrange
        Hotel chosenHotel = null;
        Room chosenRoom = new Room();
        int numberOfNights = 4;
        int numberOfPeople = 2;

        // act
        Throwable exceptionCaught = catchThrowable(() -> {
            order = new Order(chosenHotel, chosenRoom, numberOfNights, numberOfPeople);
        });

        // assert
        String message = "Hotel cannot be null!";

        Assertions.assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void should_ThrowException_WhenTryingCreateOrderWithNullRoom() {
        // arrange
        Hotel chosenHotel = new Hotel();
        Room chosenRoom = null;
        int numberOfNights = 4;
        int numberOfPeople = 2;

        // act
        Throwable exceptionCaught = catchThrowable(() -> {
            order = new Order(chosenHotel, chosenRoom, numberOfNights, numberOfPeople);
        });

        // assert
        String message = "Room cannot be null!";

        Assertions.assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void should_CorrectlyCreateOrder_WithWrongNumberOfNights() {
        // arrange
        Hotel chosenHotel = new Hotel();
        Room chosenRoom = new Room();
        int numberOfNights = 0;
        int numberOfPeople = 2;

        // act
        Throwable exceptionCaught = catchThrowable(() -> {
            order = new Order(chosenHotel, chosenRoom, numberOfNights, numberOfPeople);
        });

        // assert
        String message = "Number of nights cannot be less than 1!";

        Assertions.assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void should_CorrectlyCreateOrder_WithWrongNumberOfPeople() {
        // arrange
        Hotel chosenHotel = new Hotel();
        Room chosenRoom = new Room();
        int numberOfNights = 2;
        int numberOfPeople = -1;

        // act
        Throwable exceptionCaught = catchThrowable(() -> {
            order = new Order(chosenHotel, chosenRoom, numberOfNights, numberOfPeople);
        });

        // assert
        String message = "Number of people cannot be less than 1!";

        Assertions.assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 25, 50})
    void should_NotThrowException_WhenCreatingOrderlWithAmountOfNightsVarious(int numberOfNights) {
        Hotel chosenHotel = new Hotel();
        Room chosenRoom = new Room();
        int numberOfPeople = 2;

        // act
        order = new Order(chosenHotel, chosenRoom, numberOfNights, numberOfPeople);

        // then
        assert true;
    }

    @ParameterizedTest
    @ValueSource(ints = {90, 532, 1000})
    void should_NotThrowException_WhenCreatingOrderlWithAmountOfPeopleVarious(int numberOfPeople) {
        Hotel chosenHotel = new Hotel();
        Room chosenRoom = new Room();
        int numberOfNights = 9;

        // act
        order = new Order(chosenHotel, chosenRoom, numberOfNights, numberOfPeople);

        // then
        assert true;
    }

    @Test
    public void should_Correctly_Get_TotalCost() {
        // arrange
        Hotel chosenHotel = new Hotel();
        Room chosenRoom = new Room(2, 1000);
        int numberOfNights = 4;
        int numberOfPeople = 2;

        // act
        order = new Order(chosenHotel, chosenRoom, numberOfNights, numberOfPeople);

        // assert
        assertThat(order.getTotalCost()).isEqualTo(8000);
    }

    @Test
    public void should_CorrectlySetChosenHotel() {
        // arange
        Hotel hotel = new Hotel();

        // act
        order.setChosenHotel(hotel);

        // assert
        assertThat(order.getChosenHotel()).isEqualTo(hotel);
    }

    @Test
    public void should_CorrectlyGetChosenHotel() {
        // arrange
        Hotel chosenHotel = new Hotel();

        // act
        order.setChosenHotel(chosenHotel);

        // assert
        assertThat(order.getChosenHotel()).isEqualTo(chosenHotel);
    }

    @Test
    public void should_CorrectlySetChosenRoom() {
        // arange
        Room room = new Room();

        // act
        order.setChosenRoom(room);

        // assert
        assertThat(order.getChosenRoom()).isEqualTo(room);
    }

    @Test
    public void should_CorrectlyGetChosenRoom() {
        // arrange
        Room chosenRoom = new Room();

        // act
        order.setChosenRoom(chosenRoom);

        // assert
        assertThat(order.getChosenRoom()).isEqualTo(chosenRoom);
    }

    @Test
    public void should_CorrectlySetNumberOfNights() {
        // arange
        int numberOfNights = 1;

        // act
        order.setNumberOfNights(numberOfNights);

        // assert
        assertThat(order.getNumberOfNights()).isEqualTo(numberOfNights);
    }

    @Test
    public void should_CorrectlyGetNumberOfNights() {
        // arrange
        int numberOfNights = 2;

        // act
        order.setNumberOfNights(numberOfNights);

        // assert
        assertThat(order.getNumberOfNights()).isEqualTo(numberOfNights);
    }

    @Test
    public void should_CorrectlySetNumberOfPeople() {
        // arange
        int numberOfPeople = 3;

        // act
        order.setNumberOfPeople(numberOfPeople);

        // assert
        assertThat(order.getNumberOfPeople()).isEqualTo(numberOfPeople);
    }

    @Test
    public void should_CorrectlyGetNumberOfPeople() {
        // arrange
        int numberOfPeople = 1;

        // act
        order.setNumberOfPeople(numberOfPeople);

        // assert
        assertThat(order.getNumberOfPeople()).isEqualTo(numberOfPeople);
    }
}
