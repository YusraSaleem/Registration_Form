import javax.swing.*;

public class GUI2 extends JFrame {
    JTextField txt1;
    JTextField txt2;
    JTextField txt3;
    JTextField txt4;
    JTextField txt5;
    JTextField txt6;
    JTextField txt7;
    JTextField txt8;
    JTextField txt9;
    private JLabel reg;
    private JLabel name;
    private JLabel batch;
    private JLabel section;
    private JLabel rollno;
    private JLabel gender;
    private JLabel education;
    private JLabel address;
    private JLabel country;
    private JPanel frame2panel;

    public GUI2(String title2) {
        super(title2);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(frame2panel);
        this.pack();
    }

    public static void main(String[] args) {
        GUI2 frame2 = new GUI2("Student Registeration Form");
    }

}
