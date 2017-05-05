/**
 * Created by Rackenrotz on 06.12.15.
 */
public class test {

    public static void main(String[] args) {
        int count_a = 0;
        int count_b = 0;
        for (int i = 0; i < 10 ; i++) {
            //StockTickArray a = new StockTickArray(100, "normal");
            //count_a = count_a + a.getCount();
            //System.out.println("Vergleiche des Objekt a"+(i+1)+": " + a.getCount());
            //System.out.println("");

            StockTickArray b = new StockTickArray(100, "normal");
            count_b = count_b + b.getCount();
            System.out.println("Vergleiche des Objekt b"+(i+1)+": " + b.getCount());
            System.out.println("");


        }

        System.out.println("        Summe aller Vergleiche von a1-10 " + count_a);
        System.out.println("        Durchschnittliche Anzahl der Vergleiche: " + (count_a/10));

        System.out.println();

        System.out.println("        Summe aller Vergleiche von b1-10" + count_b);
        System.out.println("        Durchschnittliche Anzahl der Vergleiche: " + (count_b/10));





      //  StockTickArray a = new StockTickArray(100, "normal");



    }

}
