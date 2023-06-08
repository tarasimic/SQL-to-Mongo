package gui.view;

import gui.controller.SubmitAction;
import parser.controller.ParserImplementation;
import parser.model.SQLQuery;
import parser.model.Clause;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class MainFrame2 extends JFrame {
    private JTextArea textArea;
    private static MainFrame2 instance = null;
    private JButton btn;

    private JTable table;
    private ActionListener submit = new SubmitAction();

    private MainFrame2() {

    }

    public void initialise(){
        setTitle("Projekat");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());


        textArea = new JTextArea();
        textArea.setRows(10);
        JScrollPane textScrollPane = new JScrollPane(textArea);
        //panel.add(textScrollPane, BorderLayout.CENTER);


        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submit.actionPerformed(new ActionEvent(textArea, ActionEvent.ACTION_PERFORMED, null));
                }
            }
        });


        JToolBar toolBar = new JToolBar();
        panel.add(toolBar, BorderLayout.NORTH);



        btn = new JButton("Submit");
        btn.addActionListener(submit);
        toolBar.add(btn);

        table = new JTable();

        JScrollPane tableScrollPane = new JScrollPane(table);
        // panel.add(tableScrollPane, BorderLayout.SOUTH);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, textScrollPane, tableScrollPane);
        splitPane.setResizeWeight(0.5); // Set the initial size distribution between the components
        panel.add(splitPane, BorderLayout.CENTER);


        add(panel);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public static MainFrame2 getInstance(){
        if (instance==null){
            instance = new MainFrame2();
            instance.initialise();
        }
        return instance;
    }

    public void updateTable(DefaultTableModel tableModel) {
        table.setModel(tableModel);
    }



    public JTextArea getTextArea() {
        return textArea;
    }}