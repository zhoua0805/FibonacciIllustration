//AliceZU3A1Q5
//Alice Zhou
//For: Mrs. Harris
//May 22nd, 2018
//Fibonacci’s rabbits: this program creates a vivid illustration of the famous Fibonacci sequence.
//Revision: None

//import all the modules needed for the program (gui, images, arraylists...)
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class AliceZU3A1Q5 implements ActionListener {
    private Button bt1, bt2;     //set up all the needed components and global variables (buttons, labels, ints, images, arraylists)
    private Label lb1, lb2;
    private static int x = 1;
    private static int y = 1;
    private BufferedImage image1 = null;
    private static ArrayList<Integer> nums = new ArrayList<Integer>();

    public static void fib(int n) {  //this is the recursive method for the fibonacci sequence
        int z;    //initialize an integer variable z
        if (n == 2) {       //if the order is equal to 2
            nums.add(1);    //add {1, 1} to the arraylist nums (initial values for the sequence)
            nums.add(1);
        } else {      //if the order is higher than 2
            fib(n - 1); //execute fib(n - 1), which is the same method with one lower order
        }
        z = x + y;       //let z be the sum of x + y
        x = y;           //let x = y
        y = z;           //let y = z --(the newly added numbers y, z have become x, y now)
        nums.add(z);     //add z to the arraylist nums (this list stores all the fibonacci numbers)
    }

    public static void main(String[] args) {      //this is the main program
        AliceZU3A1Q5 gui = new AliceZU3A1Q5();      //create a new class for the program
        gui.createGUI();                  //call method createGUI() and execute the rest of the program
    }


    public void createGUI() {    //this is where most of the gui and logic codes are
        JFrame frame = new JFrame("Fibonacci's Rabbits");          //create a new Jframe
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           //set default to exit on close

        JPanel panel1 = new panel();           //create a new Jpanel using the method panel()
        panel1.setLayout(null);                //set layout to null

        try {        //read in the rabbit image
            image1 = ImageIO.read(new File("C:\\Users\\14396\\IdeaProjects\\AliceZU3A1\\src\\rabbit.jpg"));
        } catch (IOException e) {     //catch if the input operation fails
            e.printStackTrace();
        }

        bt1 = new Button("See illustration");      //create a new button with text "See illustration"
        bt1.setBounds(240, 380, 100, 40); //set up its size and location
        bt1.setBackground(new Color(250, 250, 210));  //set the background color
        panel1.add(bt1);                        //add this button to the panel
        bt1.addActionListener(this);         //add an action listener to this button

        bt2 = new Button("Exit");      //create another new button with text "Exit"
        bt2.setBounds(350, 380, 70, 40);    //set up its size and location
        bt2.setBackground(new Color(250, 250, 210));  //set the background color
        panel1.add(bt2);                        //add this button to the panel
        bt2.addActionListener(this);         //add an action listener to this button

        lb1 = new Label("Fibonacci Rabbits");     //create a new label with text "Fibonacci Rabbits"
        lb1.setAlignment(1);                    //set alignment to center
        lb1.setFont(new Font("Serif", Font.BOLD, 34));     //set up the font properties
        lb1.setBounds(160, 50, 300, 50);          //set up the size and location
        panel1.add(lb1);                                               //add the label to the panel

        lb2 = new Label("Question: ");     //create a new label with text "Question: "
        lb2.setBackground(new Color(250, 250, 210));     //set the background color
        lb2.setAlignment(1);                                       //set alignment to center
        lb2.setFont(new Font("Serif", Font.BOLD, 24)); //set up the font properties
        lb2.setBounds(420, 130, 120, 40);      //set up the size and location
        panel1.add(lb2);                                           //add the label to the panel

        frame.getContentPane().add(panel1);                       //add the panel to the frame
        frame.setSize(700, 470);                   //set the frame size
        frame.setVisible(true);                                   //make the frame visible
    }


    @Override
    public void actionPerformed(ActionEvent e) {             //here are the action performance codes
        int b;            //initialize a new integer b
        if (e.getSource() == bt1) {   //if bt1 (the "See illustration" button) is pressed:
            JFrame frame3 = new JFrame("Months passed");   //create and new JFrame with title "Months passed"

            do {               //this loop repeats infinite times until the user has the correct input
                //prompt the user to enter an integer between 2 and 12 (the range of how many fibonacci numbers the program can display)
                String k = JOptionPane.showInputDialog(frame3, "How many months have passed for your rabbits? \n(Please type in an integer between 2 and 12 here) ");        //let string k be the next input value

                try {   //try:
                    b = Integer.parseInt(k);   //convert string k to integer b
                    if (b > 1 && b < 13)      //if b is between 2 and 12:
                        break;                      //break the loop
                    else {             //else:
                        JOptionPane.showMessageDialog(frame3,"Invalid input! Please input again. ");  //show a message that the input was invalid and go back to the beginning of the loop
                    }

                } catch (IllegalArgumentException ee) {      //if the try statement did not work (k is not convertible)
                    JOptionPane.showMessageDialog(frame3,"Invalid input! Please input again. ");     //show a message that the input was invalid and go back to the beginning of the loop
                }
            } while (true);

            fib(b);    //execute the method fib with the integer number b

            JFrame frame2 = new JFrame("Illustration");   //create another Jframe frame2
            JPanel panel2 = new panel2();  //create a new Jpanel panel2 using the method panel2()
            panel2.setLayout(null);         //set layout to null

            frame2.getContentPane().add(panel2);      //add panel2 to frame2
            frame2.setSize(1300, 700);   //set the frame size
            frame2.setVisible(true);                  //make the frame visible

        } else if (e.getSource() == bt2) {   //if bt2 (the "Exit" button) is pressed:
            System.exit(0);                //exit the program
        }
    }


    class panel extends JPanel {              //this is the method for drawing the first panel
        public void paint(Graphics display) {
            display.setColor(new Color(135, 206, 250));     //draw the sk7 with the color light blue
            display.fillRect(0, 0, 700, 470);

            display.setColor(new Color(161, 229, 76));     //draw the grass field with color green
            display.fillRect(0, 330, 700, 470);

            //the following instruction texts are borrowed from
            //http://educ.queensu.ca/sites/webpublish.queensu.ca.educwww/files/files/Community/COC/Melodies/Mister%20Fibonacci%20-%20Notes.pdf
            display.setColor(Color.BLACK);     //set the color to black
            display.setFont(new Font("Serif", Font.PLAIN, 18));  //set the font properties
            display.drawString("    A newly-born pair of rabbits are put in a field.", 300, 200);  //print out the instructions onto the panel
            display.drawString("After one month they are able to mate and", 300, 220);
            display.drawString("produce another pair of rabbits.", 300, 240);
            display.drawString("    Suppose that our rabbits never die and that the", 300, 260);
            display.drawString("mature female always produces one new pair (one", 300, 280);
            display.drawString("male, one female) every month. How many pairs", 300, 300);
            display.drawString("of rabbits will there be in a certain amount of time?", 300, 320);

            display.drawImage(image1, 20, 220, 200, 150, null);   //add a rabbit image onto the panel
        }
    }


    class panel2 extends JPanel {              //this is the method for drawing the second panel
        public void paint(Graphics display) {
            display.setColor(new Color(161, 229, 76));     //draw the background with color green
            display.fillRect(0, 0, 1300, 700);

            for (int i = 0; i < nums.size(); i++) {     //for every number in the fibonacci sequence
                display.setColor(Color.BLACK);       //set the color and font properties
                display.setFont(new Font("Serif", Font.BOLD, 18));
                display.drawString("Month" + i, 63+ 90* i, 50);  //print out the month number on top of each column

                if (i < 6) {    //for the first 6 fibonacci numbers (space is enough to print the all images out)
                    for (int ii = 0; ii < (nums.get(i)); ii++) {    //in each column add the respective fibonacci number of the rabbit images
                        display.drawImage(image1, 55 + 90 * i, 80 + 50 * ii, 70, 50, null);
                    }
                    display.drawString(Integer.toString(nums.get(i)), 85+ 90* i, 110+ 50* nums.get(i));  //print out the Fibonacci number under each column
                } else {   //if i is greater than 6 (the number gets too large to display all images)
                    for (int ii = 0; ii < 10; ii++) {       //in each column just add 10 of the rabbit images
                        display.drawImage(image1, 55 + 90 * i, 80 + 50 * ii, 70, 50, null);
                    }
                    display.fillOval(77 + 90 * i, 600, 8,8);   //draw three dots under the column, indicating the ellipsis mark
                    display.fillOval(87 + 90 * i, 600, 8,8);
                    display.fillOval(97 + 90 * i, 600, 8,8);
                    display.drawString(Integer.toString(nums.get(i)), 85+ 90* i, 630);    //print out the Fibonacci number under each column
                }
            }

            //After all the gui display:
            nums.clear();   //clear the arraylist nums
            x = 1;          //set the initial values x and y back to 1 again
            y = 1;
        }
    }
}
