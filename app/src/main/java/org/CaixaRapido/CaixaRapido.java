package org.CaixaRapido;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class CaixaRapido extends JFrame {    

    private final JFrame mainFrame = new JFrame();
    private final JPanel mainPanel = new JPanel();        

    private final JLabel readerLabel = new JLabel("Code of the product to insert: ");
    private final JTextField readerInput = new JTextField(30);    
    
    private final JPanel reportPane = new JPanel();
    private final JScrollPane reportPaneScroll = new JScrollPane(reportPane);

    private void init() {
        
        mainFrame.add(mainPanel);                 

        mainPanel.add(readerLabel);
        mainPanel.add(readerInput);
        
        mainPanel.add(reportPaneScroll);        
        reportPane.setLayout(new BoxLayout(reportPane, BoxLayout.Y_AXIS));
        reportPaneScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        reportPaneScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        mainFrame.setSize(400, 400);
        mainFrame.setBackground(Color.RED);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

    }       
    
    private void update() {
        mainFrame.setVisible(true);
    }

    public CaixaRapido() {                

        init();                        

        readerInput.addActionListener(e -> {
            
            System.out.println(readerInput.getText());

            reportPane.add(new JLabel(readerInput.getText()));
                        
            update();

        });










        update();

    }

}