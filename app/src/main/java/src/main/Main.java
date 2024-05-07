package main;


import javax.swing.JFrame;

public class Main{
    public static void main(String[] args){
        JFrame window = new JFrame();
        //Make the game exit properly
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Cannot resize Frame
        window.setResizable(false);
        //Title of Frame
        window.setTitle("PVZ test");

        //Instantiate Frame
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        //Frame location is free
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}