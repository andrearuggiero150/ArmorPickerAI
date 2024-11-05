package org.example.ArmorPickerAI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArmorPickerAI extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton4;
    private JRadioButton radioButton3;
    private JRadioButton radioButton2;
    private JRadioButton radioButton5;
    private JRadioButton radioButton6;
    private JRadioButton radioButton7;
    private JRadioButton radioButton8;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton invioButton;
    private JTextArea textArea1;
    private JComboBox comboBox3;

    public ArmorPickerAI() {
        setTitle("ArmorPickerAI");

        setSize(450, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout());

        ButtonGroup group1 = new ButtonGroup();
        group1.add(radioButton1);
        group1.add(radioButton4);
        group1.add(radioButton3);
        group1.add(radioButton2);
        radioButton1.setText("Mobilità");
        radioButton2.setText("Resilienza");
        radioButton3.setText("Resistenza");
        radioButton4.setText("Nessuna");

        comboBox1.addItem("2");
        comboBox1.addItem("3");
        comboBox1.addItem("4");
        comboBox1.addItem("5");

        comboBox2.addItem("2");
        comboBox2.addItem("3");
        comboBox2.addItem("4");
        comboBox2.addItem("5");

        comboBox3.addItem("10");
        comboBox3.addItem("20");
        comboBox3.addItem("30");
        comboBox3.addItem("40");
        comboBox3.addItem("50");
        comboBox3.addItem("60");
        comboBox3.addItem("70");
        comboBox3.addItem("80");
        comboBox3.addItem("90");
        comboBox3.addItem("100");

        ButtonGroup group2 = new ButtonGroup();
        group2.add(radioButton5);
        group2.add(radioButton6);
        group2.add(radioButton7);
        group2.add(radioButton8);
        radioButton5.setText("Disciplina");
        radioButton6.setText("Intelletto");
        radioButton7.setText("Forza");
        radioButton8.setText("Nessuna");

        radioButton4.setSelected(true);
        radioButton8.setSelected(true);
        comboBox1.setEnabled(false);
        comboBox2.setEnabled(false);

        radioButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButton5.isSelected()) {
                    comboBox2.setEnabled(true);
                }
            }
        });
        radioButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButton6.isSelected()) {
                    comboBox2.setEnabled(true);
                }
            }
        });
        radioButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButton7.isSelected()) {
                    comboBox2.setEnabled(true);
                }
            }
        });
        radioButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButton8.isSelected()) {
                    comboBox2.setEnabled(false);
                }
            }
        });
        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButton1.isSelected()) {
                    comboBox1.setEnabled(true);
                }
            }
        });
        radioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButton2.isSelected()) {
                    comboBox1.setEnabled(true);
                }
            }
        });
        radioButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButton3.isSelected()) {
                    comboBox1.setEnabled(true);
                }
            }
        });
        radioButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButton4.isSelected()) {
                    comboBox1.setEnabled(false);
                }
            }
        });
        invioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pesoMobilita = 1;
                int pesoResilienza = 1;
                int pesoRecupero = 1;
                int pesoDisciplina = 1;
                int pesoIntelletto = 1;
                int pesoForza = 1;


                if (radioButton1.isSelected())
                    pesoMobilita = Integer.parseInt(comboBox1.getSelectedItem().toString());
                if (radioButton2.isSelected())
                    pesoResilienza = Integer.parseInt(comboBox1.getSelectedItem().toString());
                if (radioButton3.isSelected())
                    pesoRecupero = Integer.parseInt(comboBox1.getSelectedItem().toString());
                if (radioButton5.isSelected())
                    pesoDisciplina = Integer.parseInt(comboBox2.getSelectedItem().toString());
                if (radioButton6.isSelected())
                    pesoIntelletto = Integer.parseInt(comboBox2.getSelectedItem().toString());
                if (radioButton7.isSelected())
                    pesoForza = Integer.parseInt(comboBox2.getSelectedItem().toString());

                int percentualeMutazione = Integer.parseInt(comboBox3.getSelectedItem().toString());
                ArrayList<Integer> pesi = new ArrayList<>();
                pesi.add(pesoMobilita);
                pesi.add(pesoResilienza);
                pesi.add(pesoRecupero);
                pesi.add(pesoDisciplina);
                pesi.add(pesoIntelletto);
                pesi.add(pesoForza);

                GeneticAlgorithm ga = new GeneticAlgorithm();
                ArrayList<ArmorSet> temp = null;

                try {
                    temp = ga.populationEvolution(percentualeMutazione, textField1.getText(), pesi);
                    textArea1.setText("");
                    for(int i=0; i<temp.size(); i++) {
                        textArea1.append(temp.get(i).toString());
                    }
                } catch (FileNotFoundException er) {
                    JOptionPane.showMessageDialog(null, "Il file di cui hai inserito il path non è stato trovato", "File non trovato", JOptionPane.WARNING_MESSAGE);
                } catch (NoSuchElementException er) {
                    JOptionPane.showMessageDialog(null, "Il file di cui hai inserito il path è vuoto", "File vuoto", JOptionPane.WARNING_MESSAGE);
                } catch (ArrayIndexOutOfBoundsException er) {
                    JOptionPane.showMessageDialog(null, "Il file di cui hai inserito il path non è valido", "File non valido", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        add(panel1);
    }

    public static void main(String[] args) {
        ArmorPickerAI frame = new ArmorPickerAI();
        frame.setVisible(true);
    }
}
