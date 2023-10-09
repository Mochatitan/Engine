package mochatitan.engine.gui;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;
import mochatitan.engine.Variables;

public class MainMenuPanel extends JPanel implements ActionListener{

    JTextArea textArea;
    JButton newProjectButton;
    JButton openProjectButton;

    public MainMenuPanel(JFrame parent){
        try {
            // Set metal look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
 
            // Set theme to ocean
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        }
        catch (Exception e) {
        }
        setLayout(null);
        newProjectButton = new JButton("New Project");
        openProjectButton = new JButton("Open Existing Project");
        newProjectButton.setBounds(100,100,parent.getWidth()-200,40);
        openProjectButton.setBounds(100,200,parent.getWidth()-200,50);
        add(newProjectButton);
        add(openProjectButton);
        
        newProjectButton.addActionListener(this);
        openProjectButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("action performed:");
        String s = e.getActionCommand();
        if(s.equals("New Project")){
            System.out.println("new project");
        } else if(s == "Open Existing Project"){
            System.out.println("opening old project");
        }
        System.out.println("");
    }

}
