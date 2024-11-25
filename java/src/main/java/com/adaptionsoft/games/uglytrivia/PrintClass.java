package com.adaptionsoft.games.uglytrivia;

import java.awt.print.Printable;

public class PrintClass implements PrintInterface {
    @Override
    public void print(Object text) {
        System.out.println((String)text);
    }
}
