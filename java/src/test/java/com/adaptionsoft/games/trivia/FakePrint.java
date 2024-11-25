package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.PrintInterface;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.List;

public class FakePrint implements PrintInterface {
    public List<String> printlist = new ArrayList<String>();
    @Override
    public void print(Object text) {
        printlist.add((String)text);
    }
}
