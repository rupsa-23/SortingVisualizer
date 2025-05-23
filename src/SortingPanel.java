import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SortingPanel extends JPanel implements ActionListener {
    private int[] array;
    private JButton startBtn, randomizeBtn;
    private JComboBox<String> algorithmBox;
    private final String[] algorithms = {"Bubble Sort", "Selection Sort"};

    public SortingPanel() {
        this.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();

        algorithmBox = new JComboBox<>(algorithms);
        startBtn = new JButton("Start");
        randomizeBtn = new JButton("Randomize");

        topPanel.add(algorithmBox);
        topPanel.add(startBtn);
        topPanel.add(randomizeBtn);
        this.add(topPanel, BorderLayout.NORTH);

        startBtn.addActionListener(this);
        randomizeBtn.addActionListener(e -> {
            generateArray();
            repaint();
        });

        generateArray();
    }

    private void generateArray() {
        Random rand = new Random();
        array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(500) + 1;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (array == null) return;
        int width = getWidth() / array.length;
        for (int i = 0; i < array.length; i++) {
            g.setColor(Color.BLUE);
            g.fillRect(i * width, getHeight() - array[i], width, array[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selected = (String) algorithmBox.getSelectedItem();
        new Thread(() -> {
            switch (selected) {
                case "Bubble Sort":
                    SortAlgorithm.bubbleSort(array, this);
                    break;
                case "Selection Sort":
                    SortAlgorithm.selectionSort(array, this);
                    break;
            }
        }).start();
    }
}
