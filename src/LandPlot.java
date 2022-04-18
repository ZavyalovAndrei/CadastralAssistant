import java.util.Random;

public class LandPlot {
    private final int length;
    private final int width;
    private final int price;
    private final float square;
    private final float pricePerUnitSquare;

    public float getPricePerUnitSquare() {
        return pricePerUnitSquare;
    }

    public LandPlot(int length, int width, int price) {
        this.length = length;
        this.width = width;
        this.price = price;
        this.square = (length * width) / 100F;
        this.pricePerUnitSquare = price / square;
    }

    @Override
    public String toString() {
        return "Размер участка: " + length + "*" + width + " метров (" +
                square + " соток)" +
                "\nСтоимость: " + price + " руб./Цена за сотку: " + pricePerUnitSquare +
                " руб.";
    }

    public static LandPlot getLandPlot() {
        int minLength = 12;
        int maxLength = 40;
        int minWidth = 12;
        int maxWidth = 40;
        int minPrice = 200000;
        int maxPrice = 1500000;
        Random random = new Random();
        return new LandPlot(random.nextInt(minLength, maxLength), random.nextInt(minWidth, maxWidth),
                random.nextInt(minPrice, maxPrice));
    }
}


