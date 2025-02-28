import javax.swing.*;
import java.awt.*;

class CalculatorUIComp{
    public CalculatorUIComp(){
        JFrame frame = new JFrame("Calulator");
        frame.setSize(420, 600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // result box
        JTextField resultbox = new JTextField();
        // resultbox.setBackground(Color.BLACK);
        // resultbox.setForeground(Color.WHITE);
        resultbox.setFont(new Font("Arial", Font.BOLD, 20));
        resultbox.setHorizontalAlignment(JTextField.RIGHT);
        resultbox.setEditable(false);
        
        // for setting height of the resultbox 
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setPreferredSize(new Dimension(420, 100));
        resultPanel.add(resultbox, BorderLayout.CENTER);

        frame.add(resultPanel, BorderLayout.NORTH);

        // panel for buttons
        JPanel btnPanel = new JPanel(new GridLayout(4,4));

        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btnAC = new JButton("AC");

        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btnDiv = new JButton("/");

        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btnMul = new JButton("*");

        JButton btn0 = new JButton("0");
        JButton btnAdd = new JButton("+");
        JButton btnSub = new JButton("-");
        JButton btnEqual = new JButton("=");

        btnPanel.add(btn7);
        btnPanel.add(btn8);
        btnPanel.add(btn9);
        btnPanel.add(btnAC);
        btnPanel.add(btn4);
        btnPanel.add(btn5);
        btnPanel.add(btn6);
        btnPanel.add(btnDiv);
        btnPanel.add(btn1);
        btnPanel.add(btn2);
        btnPanel.add(btn3);
        btnPanel.add(btnMul);
        btnPanel.add(btn0);
        btnPanel.add(btnAdd);
        btnPanel.add(btnSub);
        btnPanel.add(btnEqual);

        frame.add(btnPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

public class CalculatorUI{
    public static void main(String[] args) {
        new CalculatorUIComp();
    }
}