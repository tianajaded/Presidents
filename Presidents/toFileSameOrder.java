package Presidents;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class toFileSameOrder {
    // declare variables, create arrays for holding presidents and dates
    private static Presidents[] pList = new Presidents[100];
    private static Date[] dateList = new Date[100];
    static int counter = 0;

    public static void main(String[] args) {
        // create output file names
        String fileName = ("./presidents.txt");
        String outputFile = ("same_order.txt");
        String lastNameOutFile = ("last_name.txt");
        String inAugFile = ("inauguration.txt");

        try {
            // create buffered writers to output
            BufferedWriter w = new BufferedWriter(new FileWriter(outputFile));
            BufferedWriter wLast = new BufferedWriter(new FileWriter(lastNameOutFile));
            BufferedWriter wDate = new BufferedWriter(new FileWriter(inAugFile));
            // create buffered reader to read files
            BufferedReader reader = new BufferedReader(new FileReader((fileName)));
            String line = " ";

            // while the line is not empty, write output to the file
            while ((line = reader.readLine()) != null) {
                writeToFile(line, w);

            }
            // methods to close readers and sort Lists
            reader.close();
            w.close();
            sortList(wLast);
            wLast.close();
            // sortDates(wDate);
            wDate.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * method to write the list to the file
     * 
     * @param line -line of string to be stored in array
     * @param w    - output to file w
     */
    public static void writeToFile(String line, BufferedWriter w) {
        // create a String array of tokens/seperate little elements and split the lines
        // and store them in the array
        String[] chunks = line.split("\t");
        // instantiate a president object and pass in the seperated elements in the
        // desired order
        Presidents p = new Presidents(chunks[1], chunks[0], chunks[2], chunks[3]);
        // store these elements in the order we want them in an array of presidents
        pList[counter] = p;
        // increase by one so that each index points to the next index in the array
        counter = counter + 1;
        // now we create a string with the seperated elements in the way that we want
        // them so it outputs into the file in the desired way
        String outLine = chunks[1] + " " + chunks[0] + " was president from " +
                chunks[2] + " to " + chunks[3] + ".";

        try {
            // append the sequence
            w.append(outLine);
            // add a new line each time
            w.append(System.lineSeparator());
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * sortList method to sort the array
     * 
     * @param wLast - last name output
     */
    public static void sortList(BufferedWriter wLast) {
        // sort the president array. counter is keeping track of the number of
        // elements(presidents) that are present in the wLast file
        java.util.Arrays.sort(pList, 0, counter, new Comparator<Presidents>() {

            @Override
            // method to compare presidents
            public int compare(Presidents pres1, Presidents pres2) {
                // first condition: if the last names are the same, then sort by their first
                // names. Otherwise, sort by their last names.
                if (pres1.getLastName().compareTo(pres2.getLastName()) == 0) {
                    if (pres1.getFirstName().compareTo(pres2.getFirstName()) == 0) {
                        return pres1.getFirstDate().compareTo(pres2.getFirstDate());
                    }
                    return pres1.getFirstName().compareTo(pres2.getFirstName());
                }
                return pres1.getLastName().compareTo(pres2.getLastName());

            }
        });
        try {
            // loop that goes through each president in the array
            for (int i = 0; i < counter; i++) {
                // create another string that then outputs to the last_name file
                String OutLine2 = pList[i].getFirstName() + " " + pList[i].getLastName()
                        + " was president from: " + pList[i].getFirstDate() + " to "
                        + pList[i].getLastDate() + ".";

                // append and seperate lines
                wLast.append(OutLine2);

                wLast.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortListDate(BufferedWriter wDate) {
        // elements(presidents) that are present in the wLast file
        java.util.Arrays.sort(pList, 0, counter, new Comparator<Presidents>() {

            @Override
            // method to compare presidents
            public int compare(Presidents pres1, Presidents pres2) {
                // first condition: if the last names are the same, then sort by their first
                // names. Otherwise, sort by their last names.
                if (pres1.getFirstDate().compareTo(pres2.getFirstDate()) == 0) {
                    if (pres1.getFirstName().compareTo(pres2.getFirstName()) == 0) {
                        return pres1.getLastDate().compareTo(pres2.getLastDate());
                    }
                    return pres1.getFirstName().compareTo(pres2.getFirstName());
                }
                return pres1.getFirstDate().compareTo(pres2.getFirstDate());

            }
        });
        try {
            // loop that goes through each president in the array
            for (int i = 0; i < counter; i++) {
                // create another string that then outputs to the last_name file
                String OutLine2 = pList[i].getFirstName() + " " + pList[i].getLastName()
                        + " was president from: " + pList[i].getFirstDate() + " to "
                        + pList[i].getLastDate() + ".";

                // append and seperate lines
                wDate.append(OutLine2);

                wDate.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
