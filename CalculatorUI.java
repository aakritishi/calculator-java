import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class CalculatorUIComp{
        private String num1 = "";
        private String num2 = "";
        private String operator = "";
        private JTextField resultbox;
    public CalculatorUIComp(){
        JFrame frame = new JFrame("Calulator");
        frame.setSize(420, 600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // result box
        resultbox = new JTextField();
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
        btn7.addActionListener(new ButtonClickListener());
        JButton btn8 = new JButton("8");
        btn8.addActionListener(new ButtonClickListener());
        JButton btn9 = new JButton("9");
        btn9.addActionListener(new ButtonClickListener());
        JButton btnAC = new JButton("AC");
        btnAC.addActionListener(new ButtonClickListener());

        JButton btn4 = new JButton("4");
        btn4.addActionListener(new ButtonClickListener());
        JButton btn5 = new JButton("5");
        btn5.addActionListener(new ButtonClickListener());
        JButton btn6 = new JButton("6");
        btn6.addActionListener(new ButtonClickListener());
        JButton btnDiv = new JButton("/");
        btnDiv.addActionListener(new ButtonClickListener());

        JButton btn1 = new JButton("1");
        btn1.addActionListener(new ButtonClickListener());
        JButton btn2 = new JButton("2");
        btn2.addActionListener(new ButtonClickListener());
        JButton btn3 = new JButton("3");
        btn3.addActionListener(new ButtonClickListener());
        JButton btnMul = new JButton("*");
        btnMul.addActionListener(new ButtonClickListener());

        JButton btn0 = new JButton("0");
        btn0.addActionListener(new ButtonClickListener());
        JButton btnAdd = new JButton("+");
        btnAdd.addActionListener(new ButtonClickListener());
        JButton btnSub = new JButton("-");
        btnSub.addActionListener(new ButtonClickListener());
        JButton btnEqual = new JButton("=");
        btnEqual.addActionListener(new ButtonClickListener());

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

    public class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if(command.matches ("[0-9]") || command.equals("0")){
                if(operator.isEmpty()){
                    num1 += command;
                }
                else{
                    num2 += command;
                }
                resultbox.setText(num1+operator+num2);
            }
            else if(command.matches("[+\\-*/]")){
                if(!num1.isEmpty()){
                    operator = command;
                }
                resultbox.setText(num1+operator+num2);
            }
            else if(command.equals("AC")){
                num1 = "";
                num2 = "";
                operator ="";
                resultbox.setText("");
            }
            else if( command.equals("=")){
                if(!num1.isEmpty() && !num2.isEmpty()){
                    String result = performOperation();
                    resultbox.setText(result);
                    num1 = result;
                    num2 = "";
                    operator = "";
                }
            }
        }
        
    } 
   
    
    private String performOperation(){
        if(operator.equals("/")){
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);
            double result = Divide(n1, n2);
            return String.valueOf(result);
        }
        else{
            int n1 = Integer.parseInt(num1);
            int n2 = Integer.parseInt(num2);
            int result = 0;
            if(operator.equals("+")){
                result = Addition(n1, n2);
            }
            else if(operator.equals("-")){
                result = Subtraction(n1, n2);
            }
            else if(operator.equals("*")){
                result = Multiplication(n1, n2);
            }
            return String.valueOf(result);
        }
    }

    private double Divide(double num1, double num2){
        if(num2 != 0){
            return num1/num2;
        }
        else{
            throw new ArithmeticException("Cannot divide by zero");
        }
    }

    private int Addition(int num1,int num2){
        return num1 + num2;
    }

    private int Subtraction(int num1, int num2){
        return num1 - num2;
    }

    private int Multiplication(int num1, int num2){
        return num1 * num2;
    }
}

    

public class CalculatorUI{
    public static void main(String[] args) {
        new CalculatorUIComp();
    }
}