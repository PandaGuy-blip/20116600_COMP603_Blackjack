package assignment2;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Johnson
 * @Student ID 20116600
 * @Course COMP603/50A
 * Memory Card Game 
 * Try to get the least amount of mistakes to get the best score 
 * This will test your memory to remember things in a short span
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class MemoryCardGame extends javax.swing.JFrame implements ActionListener {
//Title 
//Name of the game
JFrame jframe = new JFrame("Memory Card Game");
private JLabel jlabel = new JLabel("Get Ready And Try To Get The Lowest Score");
//Menu
JPanel text = new JPanel();
JPanel jmenu = new JPanel();
JPanel jmenu2 = new JPanel();
//Start And End Screen
JPanel first_screen = new JPanel();
JPanel end_screen = new JPanel();
//Intro
JPanel Intro = new JPanel();
JPanel mini_Intro = new JPanel();
//Button for Board and Start
JButton[] jbutton = new JButton[52];
JButton start = new JButton("Start");
//Randomize the Board
Random rand = new Random();
private boolean punish = false;
//Create Board
String[] board;
//52 Cards in a deck
    //Too hard to remember with 52 Cards and Too Long 
int[] layout=new int[52];
Boolean show_cards = true;
int move=52;
int move2=52;
//String array to choose difficulty 
String level_difficulty[];
//Difficulty 
int user_score=0;
int difficulty=10;

        
public void setUpGame(int a,Boolean diff){
boolean yes = true;
clearFirst();		
//Set Cards and Background Color to a light color 
board = new String[2*a];
for(int i=0;i<(a*2);i++){
    jbutton[i] = new JButton("");
    jbutton[i].setEnabled(yes);
    jbutton[i].setBackground(Color.GREEN);
    jbutton[i].addActionListener(this);
text.add(jbutton[i]);
}              
//Cards That'll be used to play
String[] Cards = {"Ace Heart","Ace Spades","Ace Diamond","Ace Clubs",
    "Two Heart","Two Spades","Two Diamond","Two Clubs",
    "Three Heart","Three Spades", "Three Diamond", "Three Clubs",
    "Four Heart", "Four Spades", "Four Diamond", "Four Clubs", 
    "Five Heart", "Five Spades", "Five Diamond", "Five Clubs",
    "Six Heart", "Six Spades", "Six Diamond", "Six Clubs",
    "Seven Heart", "Seven Spades", "Seven Diamond", "Seven Clubs",
    "Eight Heart", "Eight Spades", "Eight Diamond", "Eight Clubs",
    "Nine Heart", "Nine Spades", "Nine Diamond", "Nine Clubs",
    "Ten Heart", "Ten Spades", "Ten Diamond", "Ten Clubs"};
//Set to 10
difficulty=a;
if(diff) level_difficulty=Cards;
    for(int i=0;
            i<a;
            i++){
    for(int c=0;
            c<2;
            c++){
    if(yes){
        while(true){	
        int y = rand.nextInt(a*2);
    //If board is empty
	if(board[y]==null){
    //Employ level difficulty
        jbutton[y].setText(level_difficulty[i]);
     board[y]=level_difficulty[i];
        break;
    }
    }    
    }    
    }
    }
//Create the board 
    create();
}
//Hide all cards when start and set False
public void hideCards(int a){
    for(int i=0;
            i<(a*2);
            i++){
    //Set empty card to display cards once flipped
    jbutton[i].setText("Cards");		
    }
    show_cards=false;
}
    
//Show Space Void Method
public void showspace(int i){
    jbutton[i].setText(board[i]);
}
//Switch Card Spots
public void switchSpot(int a){
    //Finished doesn't equal to board
    if("Finished"!=board[a]){
        //Supposed to have been button connect to image
    if(jbutton[a].getText()=="Cards"){
       jbutton[a].setText(board[a]);
    } 
    else 
    {
    jbutton[a].setText("Cards");
    }
        }
}

//Display all the cards on the board
public void display_Cards(int x, String a[]){
    for(int i=0;i<(x*2);i++){
        jbutton[i].setText(a[i]);
    }
    show_cards=true;
}

//Check if every card is found
public boolean checkWin(){
    for(int i=0;i<(difficulty*2);i++){
    if (board[i]!="done")return false;
    }
    winner();
    return true;
    }
//Winnder Winner Chicken Dinner
public void winner(){		
    first_screen.remove(text);
    first_screen.add(end_screen, BorderLayout.CENTER);
    end_screen.add(new TextField("You Win"), BorderLayout.NORTH);
    end_screen.add(new TextField("You Got Wrong: " + user_score), BorderLayout.SOUTH);		
    }
//MemoryCardGame Hold the layout
public MemoryCardGame(){
    //Set Layout and Location
    jframe.setSize(700,500);
    jframe.setLocation(700,500);
    jframe.setLayout(new BorderLayout());
    
//Color
    jframe.getContentPane().setBackground(Color.YELLOW);
//layout
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jmenu.setLayout(new FlowLayout(FlowLayout.CENTER));
    jmenu2.setLayout(new FlowLayout(FlowLayout.CENTER));
//Intro
    Intro.setLayout(new FlowLayout(FlowLayout.LEFT));
    mini_Intro.setLayout(new FlowLayout(FlowLayout.CENTER));
    Intro.add(mini_Intro, BorderLayout.CENTER);
//First Screen
    first_screen.setLayout(new BorderLayout());
    first_screen.add(jmenu, BorderLayout.NORTH);
    first_screen.add(Intro, BorderLayout.CENTER);
    first_screen.add(jmenu2, BorderLayout.CENTER);
    jframe.add(first_screen, BorderLayout.CENTER);
    jmenu.add(jlabel);
    jframe.setVisible(true);
    
//Set button
    start.addActionListener(this);
    start.setEnabled(true);
    jmenu2.add(start);
}	

//Main Screen
public void goToMainScreen(){
    new MemoryCardGame();
}

//Create and Show the board 
public void create(){
    text.setLayout(new BorderLayout());
    first_screen.add(text, BorderLayout.CENTER);		
    text.setLayout(new GridLayout(5,4,2,2));
    text.setBackground(Color.black);
    text.requestFocus();
}
//Clears the Starting Screen
public void clearFirst(){
    first_screen.remove(Intro);
    first_screen.remove(jmenu);
    first_screen.remove(jmenu2);
    first_screen.repaint();
    first_screen.revalidate();
}

//Clicking 
public void actionPerformed(ActionEvent click){
    Object source = click.getSource();
                
if(punish){
    switchSpot(move2);
    switchSpot(move);
    user_score++;
    move=(difficulty*2);
    move2=30;
    punish=false;
}
//start sets level and difficulty and calls method to set up game
if(source==start){ 
    try{
    difficulty = Integer.parseInt("10");
    } catch (Exception e){
	difficulty=10;
    }
    setUpGame(difficulty, true);//level between 1 and 2, eh is true or false
    }
    for(int i =0;
            i<(10*2)
            ;i++){
        //Start Gameplay
    if(source==jbutton[i]){
    if(show_cards){
    hideCards(10);//if first time, hides field
//Or Play
    }else{
    switchSpot(i);
    if(move>=(difficulty*2)){
    move=i;
    } 
//Reset
    else 
    {
    if((board[move]!=board[i])||(move==i)){
	move2=i;
        punish=true;				
        } else {
    board[i]="done";
    board[move]="done";
    checkWin();
    move=(difficulty*2);
    }						
    }
    }
    }
    }
}

//Main Method
public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
    new Register().setVisible(true);
        }
    });
}	
//
}