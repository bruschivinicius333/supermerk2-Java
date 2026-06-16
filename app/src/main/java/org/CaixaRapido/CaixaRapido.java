package org.CaixaRapido;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CaixaRapido extends JFrame {    

    private final JFrame mainFrame = new JFrame();
    private final JPanel mainPanel = new JPanel();        

    private final JLabel readerLabel = new JLabel("Code of the product to insert: ");
    private final JTextField readerInput = new JTextField(30);    
    private final JPanel reportPane = new JPanel();

    private void initMainStuff() {
        
        mainFrame.add(mainPanel);                 

        mainPanel.add(readerLabel);
        mainPanel.add(readerInput);
        
        mainPanel.add(reportPane);        

    }    

    private void showMainStuff() {
        mainFrame.setSize(400, 400);
        mainFrame.setBackground(Color.RED);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    }

    public CaixaRapido() {                

        initMainStuff();
         
        readerInput.addActionListener()










        showMainStuff();

    }

}