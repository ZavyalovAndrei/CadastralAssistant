import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final int DEAL_QUANTITY = 20;

    public static void main(String[] args) {
        List<LandPlot> dealList = getDealList(DEAL_QUANTITY);
        System.out.println("Введите рекомендованную цену участка за сотку.");
        Scanner scanner = new Scanner(System.in);
        int recommendPrice = checkEntry(scanner);
        List<LandPlot> filteredDealList = dealListFilter(dealList, recommendPrice);
        printList(filteredDealList);

    }


    private static List<LandPlot> getDealList(int dealQuantity) {
        List<LandPlot> dealList = new ArrayList<>();
        for (int i = 0; i < dealQuantity; i++) {
            dealList.add(LandPlot.getLandPlot());
        }
        return dealList;
    }

    private static int checkEntry(Scanner scanner) {
        while (true) {
            try {
                int price = Integer.parseInt(scanner.nextLine());
                if (price <= 0) {
                    System.out.println("Ошибка! Стоимость не может быть равна нулю или отрицательной.");
                } else {
                    return price;
                }
            } catch (NumberFormatException err) {
                System.out.println("Ошибка! Введите стоимость.");
            }
        }
    }

    private static List<LandPlot> dealListFilter(List<LandPlot> dealList, int recommendPrice) {
        return dealList.stream()
                .filter(landPlot -> landPlot.getPricePerUnitSquare() > recommendPrice)
                .collect(Collectors.toList());
    }

    private static void printList(List<LandPlot> list) {
        list.forEach(System.out::println);
    }
}
