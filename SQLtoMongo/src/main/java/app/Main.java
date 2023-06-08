package app;


import com.mongodb.MongoClient;
import database.controller.mongo.MongoConnection;
import gui.view.MainFrame2;

import javax.swing.*;


public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame2.getInstance();

            }
        });


    }


}
