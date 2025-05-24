import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Font;


public class SortingPanel extends JPanel implements ActionListener {
//    private final Object JButton;
    private int[] array;
    private JButton startBtn, randomizeBtn, stopBtn;
    private JComboBox<String> algorithmBox;
    private final String[] algorithms = {"Bubble Sort", "Selection Sort", "Insertion Sort"};
    private volatile boolean stopreq=false;
    public boolean stopreq() {
        return stopreq;
    }


    public SortingPanel() {
        this.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();

        algorithmBox = new JComboBox<>(algorithms);
        //this.add(algorithmBox);


        startBtn = new JButton("Start");
        startBtn.setFocusable(false);
        startBtn.setBackground(new Color(0,0,0,0));
        startBtn.setBorderPainted(false);


        stopBtn = new JButton("Stop");
        stopBtn.setFocusable(false);
        stopBtn.setBackground(new Color(0,0,0,0));
        stopBtn.setBorderPainted(false);


        randomizeBtn = new JButton("Randomize");
        randomizeBtn.setFocusable(false);
        //randomizeBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        randomizeBtn.setBackground(new Color(0,0,0,0));
        randomizeBtn.setBorderPainted(false);
        //randomizeBtn.setBorder(BorderFactory.createCompoundBorder());
        //randomizeBtn.setFont(new Font("Calibri",Font.BOLD,16));


        topPanel.add(algorithmBox);
        topPanel.add(startBtn);
        topPanel.add(randomizeBtn);
        topPanel.add(stopBtn);
        this.add(topPanel, BorderLayout.NORTH);

        startBtn.addActionListener(this);
        //algorithmBox.addActionListener(this);
        stopBtn.addActionListener(e ->  stopreq =true);
        randomizeBtn.addActionListener(e -> { //instead of using actionlistener
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
            g.setColor(Color.PINK);
            g.fillRect(i * width, getHeight() - array[i], width, array[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        stopreq = false; // reset before new sort
        String selected = (String) algorithmBox.getSelectedItem();
        new Thread(() -> {
            switch (selected) {
                case "Bubble Sort":
                    SortAlgorithm.bubbleSort(array, this);
                    break;
                case "Selection Sort":
                    SortAlgorithm.selectionSort(array, this);
                    break;
                case "Insertion Sort":
                    SortAlgorithm.insertionSort(array,this);
                    break;
            }
        }).start();
    }
}
