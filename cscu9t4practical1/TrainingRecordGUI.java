// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener
{
      //Textfield, Labels and Buttons
    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JTextField where = new JTextField(30);
    private JTextField terrain = new JTextField(30);
    private JTextField tempo = new JTextField(30);
    private JTextField reps = new JTextField(2);
    private JTextField recov = new JTextField(3);
    private JLabel labterr = new JLabel(" Terrain:");
    private JLabel labtempo = new JLabel(" Tempo:");
    private JLabel labreps = new JLabel(" Repetitions:");
    private JLabel labrecov = new JLabel(" Recovery:");
    private JLabel labwhere = new JLabel(" Where(outdoor or pool):");
    String[] trainingType = {"Swim", "Sprint", "Cycle"};
    private JComboBox<String> TrainingType = new JComboBox(trainingType);

    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");

    private JButton FindAllByDate = new JButton("Find All By Date");

    private JButton removeEntry = new JButton("Remove Entry");


    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args)
    {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labwhere);
        add(where);
        where.setEditable(true);
        add(labterr);
        add(terrain);
        terrain.setEditable(true);
        add(labtempo);
        add(tempo);
        tempo.setEditable(true);
        add(labreps);
        add(reps);
        reps.setEditable(true);
        add(labrecov);
        add(recov);
        recov.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(FindAllByDate);
        FindAllByDate.addActionListener(this);
        add(removeEntry);
        removeEntry.addActionListener(this);
        add(TrainingType);
        TrainingType.addActionListener(this);
        labwhere.setVisible(true);
        labterr.setVisible(false);
        labtempo.setVisible(false);
        labreps.setVisible(false);
        labrecov.setVisible(false);
        terrain.setVisible(false);
        where.setVisible(true);
        tempo.setVisible(false);
        reps.setVisible(false);
        recov.setVisible(false);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)

    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event)
    {
        //whem buttons are pressed

        String message = "";
        if (event.getSource() == addR)
        {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = String.valueOf(lookupEntry());
        }
        if (event.getSource() == FindAllByDate) {
            message = String.valueOf(FindAllByDate());
        }
        if (event.getSource() == removeEntry) {
            message = RemoveEntry();
        }
        if (event.getSource() == TrainingType) {
            String selectedTrainingType = (String) TrainingType.getSelectedItem();
            if (selectedTrainingType.equals("Swim")) {
                labwhere.setVisible(true);
                labterr.setVisible(false);
                labtempo.setVisible(false);
                labreps.setVisible(false);
                labrecov.setVisible(false);
                terrain.setVisible(false);
                where.setVisible(true);
                tempo.setVisible(false);
                reps.setVisible(false);
                recov.setVisible(false);
            } else if (selectedTrainingType.equals("Sprint")) {
                labwhere.setVisible(false);
                labterr.setVisible(false);
                labtempo.setVisible(false);
                labreps.setVisible(true);
                labrecov.setVisible(true);
                terrain.setVisible(false);
                where.setVisible(false);
                tempo.setVisible(false);
                reps.setVisible(true);
                recov.setVisible(true);
            } else {
                labwhere.setVisible(false);
                labterr.setVisible(true);
                labtempo.setVisible(true);
                labreps.setVisible(false);
                labrecov.setVisible(false);
                terrain.setVisible(true);
                where.setVisible(false);
                tempo.setVisible(true);
                reps.setVisible(false);
                recov.setVisible(false);
            }
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) //adding records according the classes
    {

        System.out.println("Adding " + what + " entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int min = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String loc = where.getText();
        String t = terrain.getText();
        String t2 = tempo.getText();
        int r = Integer.parseInt(reps.getText());
        int r1 = Integer.parseInt(recov.getText());
        String selectedItem = TrainingType.getSelectedItem().toString();
        if (selectedItem.equals("Sprint")) {
            Entry a = new SprintEntry(n, d, m, y, h, min, s, km, r, r1);
            myAthletes.addEntry(a);
            return "SprintEntry record added";
        }
        if (selectedItem.equals("Swim")) {
            Entry a = new SwimEntry(n, d, m, y, h, min, s, km, loc);
            myAthletes.addEntry(a);
            return "SwimEntry record added";
        }
        if (selectedItem.equals("Cycle")) {
            Entry a = new CycleEntry(n, d, m, y, h, min, s, km, t, t2);
            myAthletes.addEntry(a);
            return "CycleEntry record added";
        } else {
            return "please select the training type";
        }


    }


    public String lookupEntry() // for looking up records
    {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntries(d, m, y);
        ;
        return message;
    }

    public String FindAllByDate() //Finding records by date
    {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("Finding the entries by date... ");
        String message = myAthletes.FindAllByDate(d, m, y);
        return message;
    }

    public String RemoveEntry() //Removing entries
    {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        String n = name.getText();
        outputArea.setText("clearing record ...");
        myAthletes.RemoveEntry(d, m, y, n);


        return "Record removed";
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        terrain.setText("");
        where.setText("");
        tempo.setText("");
        reps.setText("");
        recov.setText("");
    }// blankDisplay

    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
        if (ent instanceof SwimEntry) {
            SwimEntry swimEntry = (SwimEntry) ent;
            where.setText(swimEntry.getWhere());}
        if (ent instanceof SprintEntry) {
            SprintEntry SprintEntry = (SprintEntry) ent;
            reps.setText(String.valueOf(SprintEntry.getRepetitions()));
            recov.setText(String.valueOf(SprintEntry.getRecovery()));}
        if (ent instanceof CycleEntry){
        CycleEntry CycleEntry = (CycleEntry) ent;
        terrain.setText(CycleEntry.getTerrain());
        tempo.setText(CycleEntry.getTempo());}
    }


} // TrainingRecordGUI

