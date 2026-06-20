package org.CaixaRapido;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class CaixaRapido extends JFrame {    

    private final JFrame mainFrame = new JFrame();
    private final JPanel mainPanel = new JPanel();        

    private final JLabel readerLabel = new JLabel("Code of the product to insert: ");
    private final JTextField readerInput = new JTextField(30);    
    
    private final JPanel reportPane = new JPanel();
    private final JScrollPane reportPaneScroll = new JScrollPane(reportPane);
    private final Map<JPanel, String> reportPaneElements = new HashMap<>();
    private final enum reportPaneElementsEnum {
        ID,
        NAME,
        DESCRIPTION,
        PRICE        
    };

    private final JPanel keyShortcuts = new JPanel();

    private void initKeyShortcuts() { // TODO: the program must work through only keyboard shortcuts
                
        Action f1Action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("f1 pressed!");
            }
        };

        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke("F1"), "triggerF1");

        mainPanel.getActionMap().put("triggerF1", f1Action);

    }

    private void initInterface() {
        mainFrame.add(mainPanel);                 

        mainPanel.add(readerLabel);
        mainPanel.add(readerInput);
        
        mainPanel.add(reportPaneScroll);        
        reportPane.setLayout(new BoxLayout(reportPane, BoxLayout.Y_AXIS));
        reportPaneScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        reportPaneScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);



    }

    private void init() {
        
        initInterface();

        mainFrame.setSize(400, 400);        
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

        initKeyShortcuts();

    }       
    
    private void update() {
        //mainPanel.setBackground(Color.LIGHT_GRAY);
        mainFrame.setVisible(true);
    }

    public CaixaRapido() {                

        init();                        

        readerInput.addActionListener(e -> {
            
            //System.out.println(readerInput.getText());

            reportPane.add(new JLabel(readerInput.getText()));
                        
            update();

        });










        update();

    }

}