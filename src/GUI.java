import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;

import org.json.simple.JSONObject;

 public class GUI extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField3;
    private JPanel mainPanel;
    private JButton printButton;
    private JButton saveButton;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JTextField textField5;
    private JCheckBox matricCheckBox;
    private JCheckBox intermediateCheckBox;
    private JCheckBox graduateCheckBox;
    private JCheckBox postGraduateCheckBox;
    private JComboBox comboBox1;
    private JTextArea textArea1;
     private JButton databaseButton;
     private JButton printfromdb;

     String gender;
    String education;
    String regno;
    String address;
    String country;
     String name ;
     String batch ;
     String section;
     String rollNo;

    //constructor

    public GUI(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

// save button acton listener
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JSONObject jsonObject = new JSONObject();

                regno = textField5.getText();
                 name = textField1.getText();
                 batch = textField4.getText();
                 section = textField3.getText();
                 rollNo = textField2.getText();
                if (maleRadioButton.isSelected()) {
                    gender = maleRadioButton.getText();
                } else {
                    gender = femaleRadioButton.getText();
                }

                address = textArea1.getText();

                if (matricCheckBox.isSelected()) {
                    education = matricCheckBox.getText();
                }
                if (intermediateCheckBox.isSelected()) {
                    education = intermediateCheckBox.getText();
                }
                if (graduateCheckBox.isSelected()) {
                    education = graduateCheckBox.getText();
                }
                if (postGraduateCheckBox.isSelected()) {
                    education = postGraduateCheckBox.getText();
                }

                country = comboBox1.getSelectedItem().toString();

                jsonObject.put("REG. NO.", regno);
                jsonObject.put("Name", name);
                jsonObject.put("Batch", batch);
                jsonObject.put("Section", section);
                jsonObject.put("Roll No.", rollNo);
                jsonObject.put("Gender", gender);
                jsonObject.put("Qualification", education);
                jsonObject.put("Address", address);
                jsonObject.put("Country", country);

                try {
                    FileWriter file = new FileWriter("D:/output2.json");
                    file.write(jsonObject.toJSONString());
                    file.close();
                } catch (IOException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }
                //System.out.println("JSON file created at specified path");
                JOptionPane.showMessageDialog(null, "Data saved in JSON file successfully");

            }
        });

// print button acton listener
        printButton.addActionListener(new ActionListener() { //display frame to frame
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI2 gui2 = new GUI2("Students Registration Form");
                gui2.txt1.setText(regno);
                gui2.txt2.setText(name);
                gui2.txt3.setText(batch);
                gui2.txt4.setText(section);
                gui2.txt5.setText(rollNo);

                gui2.txt6.setText(gender);
                gui2.txt7.setText(education);
                gui2.txt8.setText(textArea1.getText());
                gui2.txt9.setText(comboBox1.getSelectedItem().toString());

                gui2.txt1.setEditable(false);
                gui2.txt2.setEditable(false);
                gui2.txt3.setEditable(false);
                gui2.txt3.setEditable(false);
                gui2.txt4.setEditable(false);
                gui2.txt5.setEditable(false);
                gui2.txt6.setEditable(false);
                gui2.txt7.setEditable(false);
                gui2.txt8.setEditable(false);
                gui2.txt9.setEditable(false);

                gui2.setBounds(400, 100, 650, 500);
                gui2.setVisible(true);
                setVisible(false);

            }
        });

        databaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regno = textField5.getText();
                name = textField1.getText();
                batch = textField4.getText();
                section = textField3.getText();
                rollNo = textField2.getText();
                if (maleRadioButton.isSelected()) {
                    gender = maleRadioButton.getText();
                } else {
                    gender = femaleRadioButton.getText();
                }

                address = textArea1.getText();

                if (matricCheckBox.isSelected()) {
                    education = matricCheckBox.getText();
                }
                if (intermediateCheckBox.isSelected()) {
                    education = intermediateCheckBox.getText();
                }
                if (graduateCheckBox.isSelected()) {
                    education = graduateCheckBox.getText();
                }
                if (postGraduateCheckBox.isSelected()) {
                    education = postGraduateCheckBox.getText();
                }

                country = comboBox1.getSelectedItem().toString();

                try {
                    String query3 = "insert into stinfo values('"+regno+"','"+name+"','"+batch+"','"+section+ "','"+rollNo+"','"+gender+"','"+education+"','"+address+"','"+country+"')";
                    ConnectionDB condb = new ConnectionDB();
                    condb.stat.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null, "Data saved in database successfully");
                }
                catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        });

        printfromdb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI2 gui2 = new GUI2("Students Registration Form");

                try {
                    ConnectionDB connn = new ConnectionDB();
                   String query3 = "select * from stinfo where regNo = '"+regno+"'";
                    ResultSet rs3 = connn.stat.executeQuery(query3);

                    while (rs3.next()) {
                        gui2.txt1.setText(rs3.getString("regNo"));
                        gui2.txt2.setText(rs3.getString("sname"));
                        gui2.txt3.setText(rs3.getString("batch"));
                        gui2.txt4.setText(rs3.getString("section"));
                        gui2.txt5.setText(rs3.getString("rollno"));
                        gui2.txt6.setText(rs3.getString("gender"));
                        gui2.txt7.setText(rs3.getString("qualification"));
                        gui2.txt8.setText(rs3.getString("address"));
                        gui2.txt9.setText(rs3.getString("country"));
                    }
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }

                gui2.txt1.setEditable(false);
                gui2.txt2.setEditable(false);
                gui2.txt3.setEditable(false);
                gui2.txt3.setEditable(false);
                gui2.txt4.setEditable(false);
                gui2.txt5.setEditable(false);
                gui2.txt6.setEditable(false);
                gui2.txt7.setEditable(false);
                gui2.txt8.setEditable(false);
                gui2.txt9.setEditable(false);

                gui2.setBounds(400, 100, 650, 500);
                gui2.setVisible(true);
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new GUI("Student Registration Form");
        frame.setBounds(400, 100, 650, 500);
        frame.setVisible(true);
    }
 }