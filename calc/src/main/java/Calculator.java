//Source: https://github.com/AlexanderMisel/SimpleCalculator

package calculator;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
 
public class Calculator extends JFrame {
    private static final String NUMBER_PROPERTY = "NUMBER_PROPERTY";
    private static final String OPERATOR_PROPERTY = "OPERATOR_PROPERTY";
    private static final String FIRST = "FIRST";
    private static final String VALID = "VALID";
 
    // These would be much better if placed in an enum,
    // but enums are only available starting in Java 5.
    // Code using them isn't back portable.
    private static interface Operator{
        static final int EQUALS = 0;
        static final int PLUS = 1;
        static final int MINUS = 2;
        static final int MULTIPLY = 3;
        static final int DIVIDE = 4;
    }
 
    private String status;
    private int previousOperation;
    private double lastValue;
    private JTextArea lcdDisplay;
    private JLabel errorDisplay;
 
    public static void main(String[] args) {
        // Remember, all swing components must be accessed from
        // the event dispatch thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Calculator calc = new Calculator();
                calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                calc.setVisible(true);
            }
        });
    }
 
    public Calculator() {
        super("Calculator");
 
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel numberPanel = buildNumberPanel();
        JPanel operatorPanel = buildOperatorPanel();
        JPanel clearPanel = buildClearPanel();
        lcdDisplay = new JTextArea();
        lcdDisplay.setName("lcd");
        lcdDisplay.setFont(new Font("Dialog", Font.BOLD, 18));
        mainPanel.add(clearPanel, BorderLayout.SOUTH);
        mainPanel.add(numberPanel, BorderLayout.CENTER);
        mainPanel.add(operatorPanel, BorderLayout.EAST);
        mainPanel.add(lcdDisplay, BorderLayout.NORTH);
 
        errorDisplay = new JLabel(" ");
        errorDisplay.setFont(new Font("Dialog", Font.BOLD, 12));
 
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(errorDisplay, BorderLayout.SOUTH);
 
        pack();
        resetState();
    }
 
    private final ActionListener numberListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JComponent source = (JComponent)e.getSource();
            Integer number = (Integer) source.getClientProperty(NUMBER_PROPERTY);
            if(number == null){
                throw new IllegalStateException("No NUMBER_PROPERTY on component");
            }
 
            numberButtonPressed(number.intValue());
        }
    };
 
    private final ActionListener decimalListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            decimalButtonPressed();
        }
    };
 
    private final ActionListener operatorListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JComponent source = (JComponent) e.getSource();
            Integer opCode = (Integer) source.getClientProperty(OPERATOR_PROPERTY);
            if (opCode == null) {
                throw new IllegalStateException("No OPERATOR_PROPERTY on component");
            }
 
            operatorButtonPressed(opCode);
        }
    };
 
    private final ActionListener clearListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            resetState();
        }
    };
 
    private JButton buildNumberButton(int number) {
        JButton button = new JButton(Integer.toString(number));
        button.setName(""+number);
        button.putClientProperty(NUMBER_PROPERTY, Integer.valueOf(number));
        button.addActionListener(numberListener);
        return button;
    }
 
    private JButton buildOperatorButton(String symbol, int opType) {
        JButton plus = new JButton(symbol);
        plus.setName(""+symbol);
        plus.putClientProperty(OPERATOR_PROPERTY, Integer.valueOf(opType));
        plus.addActionListener(operatorListener);
        return plus;
    }
 
    public JPanel buildNumberPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3));
 
        panel.add(buildNumberButton(7));
        panel.add(buildNumberButton(8));
        panel.add(buildNumberButton(9));
        panel.add(buildNumberButton(4));
        panel.add(buildNumberButton(5));
        panel.add(buildNumberButton(6));
        panel.add(buildNumberButton(1));
        panel.add(buildNumberButton(2));
        panel.add(buildNumberButton(3));
 
        JButton buttonDec = new JButton(".");
        buttonDec.addActionListener(decimalListener);
        panel.add(buttonDec);
 
        panel.add(buildNumberButton(0));
 
        // Exit button is to close the calculator and terminate the program.
        JButton buttonExit = new JButton("EXIT");
        buttonExit.setMnemonic(KeyEvent.VK_C);
        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(buttonExit);
        return panel;
 
    }
 
    public JPanel buildOperatorPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
 
        panel.add(buildOperatorButton("+", Operator.PLUS));
        panel.add(buildOperatorButton("-", Operator.MINUS));
        panel.add(buildOperatorButton("*", Operator.MULTIPLY));
        panel.add(buildOperatorButton("/", Operator.DIVIDE));
        return panel;
    }
 
    public JPanel buildClearPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
 
        JButton clear = new JButton("C");
        clear.addActionListener(clearListener);
        panel.add(clear);
 
        JButton CEntry = new JButton("CE");
        CEntry.addActionListener(clearListener);
        panel.add(CEntry);
 
        panel.add(buildOperatorButton("=", Operator.EQUALS));
 
        return panel;
    }
 
    public void numberButtonPressed(int i) {
        String displayText = lcdDisplay.getText();
        String valueString = Integer.toString(i);
 
        if (("0".equals(displayText)) || (FIRST.equals(status))) {
            displayText = "";
        }
 
        int maxLength = (displayText.indexOf(".") >= 0) ? 21 : 20;
        if(displayText.length() + valueString.length() <= maxLength){
            displayText += valueString;
            clearError();
        } else {
            setError("Reached the 20 digit max");
        }
 
        lcdDisplay.setText(displayText);
        status = VALID;
    }
 
    public void operatorButtonPressed(int newOperation) {
        Double displayValue = Double.valueOf(lcdDisplay.getText());
 
//        if(newOperation == Operator.EQUALS && previousOperation != //Operator.EQUALS){
//            operatorButtonPressed(previousOperation);
//        } else {
            switch (previousOperation) {
                case Operator.PLUS:
                    displayValue = lastValue + displayValue;
                    commitOperation(newOperation, displayValue);
                    break;
                case Operator.MINUS:
                    displayValue = lastValue - displayValue;
                    commitOperation(newOperation, displayValue);
                    break;
                case Operator.MULTIPLY:
                    displayValue = lastValue * displayValue;
                    commitOperation(newOperation, displayValue);
                    break;
                case Operator.DIVIDE:
                    if (displayValue == 0) {
                        setError("ERROR: Division by Zero");
                    } else {
                        displayValue = lastValue / displayValue;
                        commitOperation(newOperation, displayValue);
                    }
                    break;
                case Operator.EQUALS:
                    commitOperation(newOperation, displayValue);
//            }
        }
    }
 
    public void decimalButtonPressed() {
        String displayText = lcdDisplay.getText();
        if (FIRST.equals(status)) {
            displayText = "0";
        }
 
        if(!displayText.contains(".")){
            displayText = displayText + ".";
        }
        lcdDisplay.setText(displayText);
        status = VALID;
    }
 
    private void setError(String errorMessage) {
        if(errorMessage.trim().equals("")){
            errorMessage = " ";
        }
        errorDisplay.setText(errorMessage);
    }
 
    private void clearError(){
        status = FIRST;
        errorDisplay.setText(" ");
    }
 
    private void commitOperation(int operation, double result) {
        status = FIRST;
        lastValue = result;
        previousOperation = operation;
        lcdDisplay.setText(String.valueOf(result));
    }
 
    /**
     * Resets the program state.
     */
    void resetState() {
        clearError();
        lastValue = 0;
        previousOperation = Operator.EQUALS;
 
        lcdDisplay.setText("0");
    }
}