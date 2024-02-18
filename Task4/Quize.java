import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quize extends JFrame {
    private JLabel question;
    private JRadioButton[] questionoptions;
    private JButton submit;
    private JLabel tlabel; 
    private int QuestionIndex;
    private int scorequestion;
    private Timer timer;
    private String[] questions = {
            "who is president of india?",
            "What is chemical formula of water?",
            "What is 4+4=?",
            "which planet is known as water planet?"
    };
    private String[][] questionschoices = {
            {"Droupadi Murmu", "Narendra modi", "Amit Shah", "Pandit Govind Ballabh Pant"},
            {"HCL", "H2O", "NACL", "O"},
            {"2", "5", "8", "10"},
            {"Earth", "Mercury", "Moon", "Venus"}
    };
    private int[] correctAnswers = {1, 2, 3, 1};

    public Quize() {
        setTitle("Quiz Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 300);
        setLayout(new BorderLayout());

        initializeComponents();
        setupListeners();

        QuestionIndex = 0;
        showQuestion();
        sTimer();
    }

    private void initializeComponents() {
        question = new JLabel();
        add(question, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        questionoptions = new JRadioButton[4];
        ButtonGroup buttonGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            questionoptions[i] = new JRadioButton();
            buttonGroup.add(questionoptions[i]);
            optionsPanel.add(questionoptions[i]);
        }
        add(optionsPanel, BorderLayout.CENTER);

        submit = new JButton("Submit");
        add(submit, BorderLayout.SOUTH);

        tlabel = new JLabel();
        add(tlabel, BorderLayout.EAST); // Add the timer label
    }

    private void setupListeners() {
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                showNextQuestion();
            }
        });
    }

    private void showQuestion() {
        question.setText(questions[QuestionIndex]);
        for (int i = 0; i < 4; i++) {
            questionoptions[i].setText(questionschoices[QuestionIndex][i]);
            questionoptions[i].setSelected(false);
        }
    }

    private void showNextQuestion() {
        QuestionIndex++;
        if (QuestionIndex < questions.length) {
            showQuestion();
            r();
        } else {
            Result();
        }
    }

    private void checkAnswer() {
        for (int i = 0; i < 4; i++) {
            if (questionoptions[i].isSelected() && i == correctAnswers[QuestionIndex] - 1) {
                scorequestion++;
            }
        }
    }

    private void Result() {
        
        JOptionPane.showMessageDialog(this, "Your Quiz Completed!\nScore: " + scorequestion + "/" + questions.length);
        if(scorequestion>=4){
            JOptionPane.showMessageDialog(this,"Congrats you select all right options");
        }
        else{
           JOptionPane.showMessageDialog(this,"Thank you for participating");
        }
        System.exit(0);
    }

    private void sTimer() {
        timer = new Timer(1000, new ActionListener() { // Timer ticks every 1 second
            private int secondsLeft = 15; // Initial timer value

            @Override
            public void actionPerformed(ActionEvent e) {
                if (secondsLeft >= 0) {
                    tlabel.setText("Time left: " + secondsLeft + " seconds");
                    secondsLeft--;
                } else {
                    timer.stop();
                    checkAnswer();
                    showNextQuestion();
                }
            }
        });
        timer.start();
    }

    private void r() {
        timer.stop();
        sTimer();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Quize().setVisible(true);
            }
        });
    }
}

