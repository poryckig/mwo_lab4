package Lab2;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RoomTest {

    private Room room;

    @Before
    public void setup() {
        room = new Room();
    }

    @Test
    public void should_CorrectlyCreateRoom_WhenDataAreAppropriate() {
        // arrange
        int peopleCapacity = 4;
        double pricePerNightPerPerson = 1600.5;

        // act
        room = new Room(peopleCapacity, pricePerNightPerPerson);

        // assert
        assertThat(room.getPeopleCapacity()).isEqualTo(4);
        assertThat(room.getPricePerNightPerPerson()).isEqualTo(1600.5);
    }

    @Test
    public void should_ThrowException_WhenTryingCreateRoomWithPeopleCapacityLessThanOne() {
        // arrange
        int peopleCapacity = 0;
        double pricePerNightPerPerson = 2567.5;

        // act
        Throwable exceptionCaught = catchThrowable(() -> {
            room = new Room(peopleCapacity, pricePerNightPerPerson);
        });

        // assert
        String message = "People capacity cannot be less than one!";

        Assertions.assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void should_ThrowException_WhenTryingCreateRoomWithPricePerNightPerPersonLessThanOne() {
        // arrange
        int peopleCapacity = 4;
        double pricePerNightPerPerson = -1;

        // act
        Throwable exceptionCaught = catchThrowable(() -> {
            room = new Room(peopleCapacity, pricePerNightPerPerson);
        });

        // assert
        String message = "Price per night per person cannot be less than one!";

        Assertions.assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 100, 1000})
    void should_NotThrowException_WhenCreatingRoomWithPeopleCapacityBiggerThanOne(int peopleCapacity) {
        // given, when
        double pricePerNightPerPerson = 1600.5;

        room = new Room(peopleCapacity, pricePerNightPerPerson);

        // then
        assert true;
    }

    @ParameterizedTest
    @ValueSource(doubles = {1531.3, 1000.3, 9542.673})
    void should_NotThrowException_WhenCreatingRoomWithPeopleCapacityBiggerThanOne(double pricePerNightPerPerson) {
        // given, when
        int peopleCapacity = 4;

        room = new Room(peopleCapacity, pricePerNightPerPerson);

        // then
        assert true;
    }

    @Test
    public void should_CorrectlySetPeopleCapacity_WhenDataAreAppropriate() {
        // arrange
        int peopleCapacity = 3;

        // act
        room.setPeopleCapacity(peopleCapacity);

        // assert
        assertThat(room.getPeopleCapacity()).isEqualTo(3);
    }

    @Test
    public void should_ThrowException_SettingPeopleCapacityWithWrongData() {
        // arrange
        int peopleCapacity = -10;

        // act
        Throwable exceptionCaught = catchThrowable(() -> {
            room.setPeopleCapacity(peopleCapacity);
        });

        // assert
        String message = "People capacity cannot be less than one!";

        Assertions.assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void should_CorrectlySetPricePerNightPerPerson_WhenDataAreAppropriate() {
        // arrange
        double pricePerNightPerPerson = 9430.1;

        // act
        room.setPricePerNightPerPerson(pricePerNightPerPerson);

        // assert
        assertThat(room.getPricePerNightPerPerson()).isEqualTo(9430.1);
    }

    @Test
    public void should_ThrowException_SettingPricePerNightPerPersonyWithWrongData() {
        // arrange
        double pricePerNightPerPerson = -7930.156;

        // act
        Throwable exceptionCaught = catchThrowable(() -> {
            room.setPricePerNightPerPerson(pricePerNightPerPerson);
        });

        // assert
        String message = "Price per night per person cannot be less than one!";

        Assertions.assertThat(exceptionCaught)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    public void should_CorrectlyGetPeopleCapacity() {
        // arrange
        int peopleCapacity = 6;
        double pricePerNightPerPerson = 7901.123;

        // act
        room = new Room(peopleCapacity, pricePerNightPerPerson);

        // assert
        assertThat(room.getPeopleCapacity()).isEqualTo(6);
    }

    @Test
    public void should_CorrectlyGetPricePerNightPerPerson() {
        // arrange
        int peopleCapacity = 1;
        double pricePerNightPerPerson = 4002.987;

        // act
        room = new Room(peopleCapacity, pricePerNightPerPerson);

        // assert
        assertThat(room.getPricePerNightPerPerson()).isEqualTo(4002.987);
    }
}
