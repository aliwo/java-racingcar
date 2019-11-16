package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car = Car.of("베디");


    @Test
    @DisplayName("이동 안함")
    void moveTest1() {
        // given
        int expected = car.getPosition();

        // when
        car.move(x -> false);
        int actual = car.getPosition();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이동")
    void moveTest2() {
        // given
        int expected = car.getPosition()+1;

        // when
        car.move(x -> true);
        int actual = car.getPosition();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}