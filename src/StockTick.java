/**
 * Created by Rackenrotz on 06.12.15.
 */
public class StockTick {

    private String symbol;
    private int kurs;

    public StockTick(String symbol, int kurs) {
        this.symbol = symbol;
        this.kurs = kurs;
    }


    public String getSymbol() {
        return symbol;
    }

    public int getKurs() {
        return kurs;
    }
}
