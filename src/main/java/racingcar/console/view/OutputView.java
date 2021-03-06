package racingcar.console.view;

import racingcar.domain.RaceResult;
import racingcar.service.dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String ROUTE = "-";

    private OutputView() {
    }

    public static void printRaceResult(final RaceResult raceResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("실행 결과\n");
        while (raceResult.hasNext()) {
            printCurrentRace(raceResult, sb);
        }
        System.out.println(sb.toString());
    }

    private static void printCurrentRace(final RaceResult raceResult, final StringBuilder sb) {
        final List<CarDto> carDtos = raceResult.next();
        carDtos.forEach(carDto -> {
            sb.append(String.format("%s : ", carDto.getName()));
            for (int i = 0; i < carDto.getPosition(); i++) {
                sb.append(ROUTE);
            }
            sb.append("\n");
        });
        sb.append("\n");
    }


    public static void printWinner(final List<CarDto> winners) {
        final String joinedWinners = winners.stream()
                .map(CarDto::getName)
                .collect(Collectors.joining(", "));

        System.out.println(String.format("%s가 최종 우승했습니다.", joinedWinners));
    }
}
