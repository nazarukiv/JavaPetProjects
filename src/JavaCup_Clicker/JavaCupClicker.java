package JavaCup_Clicker;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class JavaCupClicker extends JFrame {

    private int clickCount = 0;
    private JLabel counterLabel;

    public JavaCupClicker() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 800));
        setResizable(false);
        setLocationRelativeTo(null);

        addGuiComponents();
        pack();
    }

    private void addGuiComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel bannerImg = loadImage("/JavaCup_Clicker/images/banner.png", 600, 250);
        mainPanel.add(bannerImg, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JButton cupButton = createImageButton("/JavaCup_Clicker/images/java_logo.jpg", 250, 250);
        cupButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        counterLabel = new JLabel("Clicks: 0");
        counterLabel.setFont(new Font("Arial", Font.BOLD, 24));
        counterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        cupButton.addActionListener(e -> {
            clickCount++;
            counterLabel.setText("Clicks: " + clickCount);
        });

        centerPanel.add(cupButton);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(counterLabel);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        this.getContentPane().add(mainPanel);
    }

    private JButton createImageButton(String fileName, int width, int height) {
        try {
            InputStream inputStream = getClass().getResourceAsStream(fileName);
            BufferedImage img = ImageIO.read(inputStream);
            Image scaled = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new JButton(new ImageIcon(scaled));
        } catch (Exception e) {
            return new JButton("Error");
        }
    }

    private JLabel loadImage(String fileName, int width, int height) {
        try {
            InputStream inputStream = getClass().getResourceAsStream(fileName);
            BufferedImage original = ImageIO.read(inputStream);
            Image scaled = original.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new JLabel(new ImageIcon(scaled));
        } catch (Exception e) {
            return new JLabel("Error loading image");
        }
    }
}