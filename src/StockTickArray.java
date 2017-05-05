import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Rackenrotz on 06.12.15.
 */
public class StockTickArray {

    //Liste für Börsenkurse mit namen
    StockTick[] array;

    //Liste mit Namen
    String[] name = {"IBM", "CSCO", "HPQ", "GOOG", "ORCL", "GPRO", "BABA", "AAPL", "SAP", "MSFT"};

    private int count = 0;

    //Konstruktor mit wert eingabe
    public StockTickArray(int array, String sort) {
        this.array = new StockTick[array];
        fillArray(sort);
    }

    //füllt den Array mit Zufallszahlen und Zufallsnamen
    private void fillArray(String sort) {
        System.out.println("Kurs" + "     " + "Name");

        System.out.println("-------------");

        for (int i = 0; i < array.length; i++) {
            //Wählt zufällig aus welcher Firmenname benutzt werden soll
            int var1 = (int) (Math.random() * 10);
            //Wählt zufälllig einen Kurs zwischen 60 und 70
            int var2 = (int) (Math.random() * 11 + 60);
            //Array wird gefüllt mit beiden zufallswerten
            array[i] = new StockTick(name[var1], var2);
        }
        //Aufruf der allgemeinen Sortier Methode
        sortStockTickArray(sort);
    }

    //sortiert nach dem insertion-sort verfahren
    public void sortStockTickArray(String sort) {

        //output(array);

        if (sort.equals("binary")) {
            kursbinary();
            //symbolbinary();
            //symbolsearch();


        }else if(sort.equals("normal")){
            kursnormal();
            //symbolnormal();
        }else{
            System.out.println("Bitte geben sie entweder binary oder normal ein!");
        }








    }

    //Aufruf der jeweiligen testverfahren
    private void kursnormal() {
        System.out.println("");
        System.out.println("Sortiert (insertion) nach Kurs: ");
        sortbyKurs(array);
        //sortbySymbol(array);
        output(array);
    }

    private void kursbinary() {
        System.out.println("");
        System.out.println("Sortiert (binary) nach Kurs: ");
        sortbybinaryKurs(array);
        //output(array);
    }

    private void symbolnormal() {
        System.out.println("");
        System.out.println("Sortiert (insertion) nach Symbol: ");
        sortbySymbol(array);
        output(array);
    }

    private void symbolbinary() {
        System.out.println("");
        System.out.println("Sortiert (binary) nach Kurs: ");
        sortbybinarySymbol(array);
        output(array);
    }

    private void symbolsearch(){
        System.out.println("");
        System.out.println("Sortiert (binary) nach Symbol: ");
        sortbybinaryKurs(array);
        output(array);
        checkSort();
        getFirmenSymbol();



    }

    //Sortiert den Array nach Kurs
    private void sortbyKurs(StockTick[] arr) {
        StockTick x;
        int j;
        for (int i = 1; i < arr.length; i++) {

            //Merkt sich den Verlgeichswert
            x = arr[i];
            //variable zum zwischenspeichern
            j = i;

            //Führt so lange eine vertauschung durch, bis kein größeres Element mehr davor steht
            while (j > 0 && arr[j - 1].getKurs() >= x.getKurs()) {

                arr[j] = arr[j - 1];
                arr[j - 1] = x;
                j--;
                count++;

            }

        }
        //Stellt sicher das die Sortierung stabil ist
    }

    // insertionSort nach Symbol
    private void sortbySymbol(StockTick[] arr) {

        StockTick x;
        int j;

        for (int i = 1; i < arr.length; i++) {

            x = arr[i];
            j = i;

            //Sortiert alphabetisch! stabil durch compareTo (aufsteigend nach Zahlen sortiert)
            while (j > 0 && arr[j - 1].getSymbol().compareTo(x.getSymbol()) > 0) {

                arr[j] = arr[j - 1];
                arr[j - 1] = x;
                j--;
                count++;
            }
            
        }
    }

    //binarySort nach Kurs
    private void sortbybinaryKurs(StockTick[] arr) {
        int left;
        int mid;
        int right;
        StockTick x;

        for (int i = 1; i < arr.length; i++) {

            x = arr[i];
            left = 0;
            right = i - 1;

            while (left <= right) {
                mid = (left + right) / 2;


                if (x.getKurs() < arr[mid].getKurs()) {
                    right = mid - 1;

                } else {
                    left = mid + 1;
                }


                count++;
            }
            for (int j = i - 1; j >= left; j--) {

                arr[j + 1] = arr[j];

            }
            arr[left] = x;

        }
    }

    //binerySort nach Symbol
    private void sortbybinarySymbol(StockTick[] arr) {
        int left;
        int mid;
        int right;
        StockTick x;

        for (int i = 1; i < arr.length; i++) {

            x = arr[i];
            left = 0;
            right = i - 1;

            while (left <= right) {
                mid = (left + right) / 2;


                if (arr[mid].getSymbol().compareTo(x.getSymbol()) > 0) {
                    right = mid - 1;

                } else {
                    left = mid + 1;
                }


                count++;
            }
            for (int j = i - 1; j >= left; j--) {

                arr[j + 1] = arr[j];

            }
            arr[left] = x;

        }
    }

    //überprüft ob eine der Array richtig sortiert ist
    private void checkSort() {

        for (int i = 1; i < array.length; i++) {

            if (array[i].getKurs() < array[i - 1].getKurs()) {
                System.out.println("Array ist an der Stelle " + i + " fehlerhaft");
                break;
            } else if (i == array.length - 1) {
                System.out.println("");
                System.out.println("Korrekt sortiert");
            }
        }
    }

    //sucht das passende Symbuol über Scanner und gibt nur die Werte der gesuchten Firma aus
    private void getFirmenSymbol() {

        System.out.println("");
        for (int i = 0; i < name.length; i++) {

            System.out.print(name[i] + "[" + (i + 1) + "]" + "    ");

        }

        System.out.println("");
        System.out.println("Von welcher Firma wollen Sie die Börstenkurse erfahren (Bitte die dazugehörige Zahl eingeben)?");
        Scanner scan = new Scanner(System.in);
        int testIntscan = scan.nextInt();
        //name wird gespeichert
        String nameSy = name[testIntscan - 1];
        //Prüft ob die eingegebene Zahl im Array berreich liegt
        if (testIntscan > 0 || testIntscan < name.length + 1) {

            sortbybinarySymbol(array);
            //Kopie des Arrays die den gleichen Kurswert haben
            int counter = 0;
            int rem = 0;
            StockTick[] newArray;
            //zählt das gesuchte Symbol und merkt sich die letzte Stelle
            for (int i = 0; i < array.length; i++) {

                if (array[i].getSymbol().equals(nameSy)) {
                    counter++;
                    rem = i;
                }

            }
            newArray = Arrays.copyOfRange(array, rem - counter + 1, rem + 1);

            System.out.println("Die Kurse zu " + nameSy);
            output(newArray);

        } else {
            System.out.println("bitte verwenden Sie die Korrekte Zahl");
        }

    }


    //Methode die den Array in einer bestimmten Art und Weise ausgibt
    private void output(StockTick[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getKurs() + "       " + arr[i].getSymbol());
        }
    }

    public int getCount() {
        return count;
    }
}

