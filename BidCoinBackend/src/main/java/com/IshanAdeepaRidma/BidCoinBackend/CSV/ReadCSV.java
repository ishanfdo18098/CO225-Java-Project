package com.IshanAdeepaRidma.BidCoinBackend.CSV;

import java.io.*;
import java.util.*;

public class ReadCSV {
    public static List<Record> allCurrencies = new ArrayList<Record>();

    public static void readCSV() {
        try {
            File myObj = new File("src/main/java/com/IshanAdeepaRidma/BidCoinBackend/CSV/CryptoCurrency.csv");
            Scanner myReader = new Scanner(myObj);

            myReader.nextLine(); // first line has the titles. Dont need it

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splitted = data.split(",");
                allCurrencies.add(new Record(splitted[0], splitted[1], Integer.valueOf(splitted[2])));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(allCurrencies.get(0));
    }
}


