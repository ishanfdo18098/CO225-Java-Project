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

class Record {
    String Symbol;
    String Name;
    Integer Rank;

    public Record(String symbol, String name, Integer rank) {
        this.Symbol = symbol;
        this.Name = name;
        this.Rank = rank;
    }

    public String getSymbol() {
        return this.Symbol;
    }

    public void setSymbol(String Symbol) {
        this.Symbol = Symbol;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Integer getRank() {
        return this.Rank;
    }

    public void setRank(Integer Rank) {
        this.Rank = Rank;
    }

}
