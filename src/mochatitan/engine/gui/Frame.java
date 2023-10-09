package mochatitan.engine.gui;


// Java Program to create a text editor using java
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;
import mochatitan.engine.Variables;

public class Frame extends JFrame implements ActionListener{
     
    public JFrame jframe;
    TextPanel textPanel;
    MainMenuPanel mainMenuPanel;
    
    public Frame(){
        // Create a frame
        jframe = new JFrame("editor");
        textPanel = new TextPanel(jframe);
        mainMenuPanel = new MainMenuPanel(jframe);
        jframe.add(mainMenuPanel);
        // jframe.add(textPanel);
        jframe.setSize(500, 500);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }

    
}

