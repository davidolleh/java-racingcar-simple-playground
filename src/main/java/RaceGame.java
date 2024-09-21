import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RaceGame {

    private List<Car> participants;
    private int count;

    private int maxLength;

    public RaceGame() {
        this.participants = new ArrayList<>();
        this.maxLength = 0;
        this.count = 0;
    }

    public void preparing() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        // 이것이 여기 있어야 할까
        Scanner sc = new Scanner(System.in);

        String[] carNames = sc.nextLine().split(",");
        for (String carName : carNames) {
            participants.add(new Car(carName));
        }


        System.out.println("시도할 회수는 몇회인가요?");
        this.count = sc.nextInt();
    }
    public void start() {
        Random rd = new Random();

        for (int i = 0; i < count; i++) {
            for (Car participant: participants) {
                if (rd.nextInt(10) >= 4) {
                    participant.move();

                    if (participant.location > maxLength) {
                        maxLength = participant.location;
                    }
                }
            }

            for (Car participant: participants) {
                String position = "-".repeat(participant.location);
                System.out.println(participant.name + " : " + position);
            }
            System.out.println();
        }
    }

    public void end() {
        String winners = "";

        int flag = 0;
        for (Car participant : participants) {
            if (maxLength == participant.location) {
                winners = winners + ", " + participant.name;
            }
        }

        System.out.println(winners + "가 최종 우승했습니다");
    }
}