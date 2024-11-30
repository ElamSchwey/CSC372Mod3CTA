import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Mod3CTA {

    // method for random green generator
    private static Color getRandomGreen() {
        Random random = new Random();
        int red = random.nextInt(50);
        int green = random.nextInt(70) + 130;
        int blue = random.nextInt(50) + 80;
        return new Color(red, green, blue);
    }

    // method for date & time
    private static String getDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        Date now = new Date();
        return sdf.format(now);
    }

    // method to log date & time to log.txt
    private static void logDateTimeToFile(String dateTime) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            writer.write(dateTime);
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {

        // create frame
        JFrame frame = new JFrame("Green Date & Time");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(getRandomGreen());
        frame.setVisible(true);

        // create menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Menu");
        menuBar.add(menu1);
        frame.setJMenuBar(menuBar);

        // Add items to menu
        JMenuItem displayDateTimeItem = new JMenuItem("Display Date & Time");
        menu1.add(displayDateTimeItem);
        JMenuItem logDateTimeItem = new JMenuItem("Log Date & Time");
        menu1.add(logDateTimeItem);
        JMenuItem changeBackgroundGreen = new JMenuItem("Change Background Green");
        menu1.add(changeBackgroundGreen);
        JMenuItem exitItem = new JMenuItem("Exit");
        menu1.add(exitItem);

        // display date & time item
        displayDateTimeItem.addActionListener(e -> {
            String dateTime = getDateTime();
            JOptionPane.showMessageDialog(frame, dateTime, "Date & Time", JOptionPane.INFORMATION_MESSAGE);
        });

        // log date & time item
        logDateTimeItem.addActionListener(e -> {
            String dateTime = getDateTime();
            logDateTimeToFile(dateTime);
            JOptionPane.showMessageDialog(frame, "Date & Time logged to file", "Log Success", JOptionPane.INFORMATION_MESSAGE);
        });

        // background color item
        changeBackgroundGreen.addActionListener(e -> {
            frame.getContentPane().setBackground(getRandomGreen());
        });

        // exit item
        exitItem.addActionListener(e -> System.exit(0));

    }
}
