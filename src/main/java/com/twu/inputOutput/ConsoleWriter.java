package com.twu.inputOutput;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Output Writer for writing outputs.
 */
public class ConsoleWriter  {

    BufferedWriter bufferedWriter;
    int writeCount=0;

    public ConsoleWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter=bufferedWriter;
    }


    public void write(String output) {
        try {
            bufferedWriter.write(output);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            writeCount++;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(ArrayList<String> list) {
//        for(String str:list)
//            write(str);

    }
}
