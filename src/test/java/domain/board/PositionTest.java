package domain.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import domain.position.Position;
import domain.position.Positions;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {
    @DisplayName("문자열을 받아 Position을 생성할 수 있다.")
    @Test
    void createTest() {
        //given
        final String position = "A1";

        //when

        //then
        assertDoesNotThrow(() -> Positions.from(position));
    }

    @DisplayName("체스판 범위를 벗어난 문자열을 받으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"Z1", "AB5", ""})
    void createFail(String position) {
        //given

        //when

        //then
        assertThrowsExactly(IllegalArgumentException.class,
                () -> Positions.from(position));
    }

    @DisplayName("위치를 여러 개를 받아서 만들 수 있다.")
    @Test
    void createPositions() {
        //given
        final List<String> positions = List.of("A3", "H2", "G5");
        final List<Position> expected = positions.stream()
                .map(Positions::from)
                .collect(Collectors.toList());

        //when

        //then
        assertThat(Positions.of(positions.toArray(String[]::new))).isEqualTo(expected);
    }

    @DisplayName("대각선이면 true를 반환한다")
    @Test
    void isDiagonal() {
        //given
        final Position source = Positions.from("D4");
        final List<Position> destinations = Positions.of("E5", "C5", "E3", "C3");

        //when

        //then
        assertThat(destinations).allMatch(source::isDiagonal);
    }

    @DisplayName("대각선이 아니면 false를 반환한다")
    @Test
    void isNotDiagonal() {
        //given
        final Position source = Positions.from("D4");
        final List<Position> destinations = Positions.of("A5", "C1", "F3", "H3");

        //when

        //then
        assertThat(destinations).noneMatch(source::isDiagonal);
    }

    @DisplayName("직선이면 true를 반환한다")
    @Test
    void isStraight() {
        //given
        final Position source = Positions.from("D4");
        final List<Position> destinations = Positions.of("D1", "D7", "A4", "H4");

        //when

        //then
        assertThat(destinations).allMatch(source::isStraight);
    }

    @DisplayName("직선이 아니면 false를 반환한다")
    @Test
    void isNotStraight() {
        //given
        final Position source = Positions.from("D4");
        final List<Position> destinations = Positions.of("A3", "H7", "C7", "H8");

        //when

        //then
        assertThat(destinations).noneMatch(source::isStraight);
    }

    @DisplayName("거리를 맨허튼거리로 계산해 반환한다")
    @Test
    void getDistance() {
        //given
        final Position source = Positions.from("D4");
        final List<Position> destinations = Positions.of("A1", "H4", "H6", "C2");
        final List<Integer> expected = List.of(6, 4, 6, 3);

        //when

        //then
        assertThat(destinations).map(source::getDistance)
                .containsExactlyElementsOf(expected);
    }

    @DisplayName("아래로 한 칸 움직인 위치를 구할 수 있다")
    @Test
    void moveDown() {
        //given
        final Position source = Positions.from("D4");
        final Position expected = Positions.from("D3");

        //when

        //then
        assertThat(source.moveDown(1)).isEqualTo(expected);
    }

    @DisplayName("위로 한 칸 움직인 위치를 구할 수 있다")
    @Test
    void moveUp() {
        //given
        final Position source = Positions.from("D4");
        final Position expected = Positions.from("D5");

        //when

        //then
        assertThat(source.moveUp(1)).isEqualTo(expected);
    }

    @DisplayName("원하는 file과 rank만큼 움직인 위치를 구할 수 있다")
    @Test
    void move() {
        //given
        final Position source = Positions.from("D4");
        final int rankDifference = 3;
        final int fileDifference = 4;
        final Position expected = Positions.from("H7");

        //when

        //then
        assertThat(source.move(rankDifference, fileDifference)).isEqualTo(expected);
    }
}

