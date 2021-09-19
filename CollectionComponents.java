import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Note1: Click Vector and Map Back And Forth To Pop Up All Numbers.
//Note2: Can Only Click Generate Three Times.

class CollectionComponents extends JFrame implements ActionListener{
    
    public static Stack <Integer> stk = new Stack <Integer>();
    public static Queue <Integer> que = new LinkedList <Integer>();
    public static ArrayList <Integer> list = new ArrayList <Integer>();
    public static Vector <Integer> vectr = new Vector <Integer>();
    public static Map <Integer, Integer> map = new HashMap <Integer, Integer>();
    
    static JButton generateButton, queueButton, listButton, vectorButton, mapButton;
    static JTextArea outputArea;
    static int counter = 0;
    
    public static void main(String args[]){

        CollectionComponents obj = new  CollectionComponents();
    }
    
    public CollectionComponents(){
      
        setButtons();
        setTextArea();
        setAction();
        setLocation(450, 180);
        setSize(600, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void setButtons(){
        
        JPanel panel = new JPanel();
        
        FlowLayout textlayout = new FlowLayout();
        setLayout(textlayout);

        generateButton = new JButton("Generate");
        generateButton.setForeground(Color.red);
        
        queueButton = new JButton("Queue");
        queueButton.setForeground(Color.green);
        
        listButton = new JButton("List");
        listButton.setForeground(Color.blue);
        
        vectorButton = new JButton("Vector");
        vectorButton.setForeground(Color.black);
        
        mapButton = new JButton("Map");
        mapButton.setForeground(Color.orange);
        
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(BorderFactory.createMatteBorder(10,10,10,10,Color.BLACK));
        
        add(panel, BorderLayout.NORTH);
        panel.add(generateButton);
        panel.add(queueButton);
        panel.add(listButton);
        panel.add(vectorButton);
        panel.add(mapButton);
        
    }
    
    public void setTextArea(){

        outputArea = new JTextArea(2, 40);
        add(outputArea, BorderLayout.CENTER);  
        outputArea.setEditable(false);
        outputArea.setBorder(BorderFactory.createMatteBorder(10,10,10,10,Color.LIGHT_GRAY));
    }
    
    public void setAction(){

        generateButton.addActionListener(this);
        queueButton.addActionListener(this);
        listButton.addActionListener(this);
        vectorButton.addActionListener(this);
        mapButton.addActionListener(this);
        
    }
    
    public void clearData(){
        stk.clear();
        que.clear();
        list.clear();
        vectr.clear();
        map.clear();
    } 
    
    public void actionPerformed(ActionEvent e){
    
        inner:
        if(e.getSource() == generateButton){
            if(counter < 3){
                  clearData();
                  int randNum = 0;
                  Random x = new Random();
                  String g=" ";
                  for(int i=0; i<5; i++){
            
                  randNum = x.nextInt(100) + 1;
                  stk.push(randNum); //add to stack
                  g=g +" "+ randNum;
                  
                  }
                  
                  outputArea.setText("                                                "+g);
             }
             
             if(counter == 3){
                   outputArea.setText("                            "+"Stack Is Full...Can't Generate More Numbers.");
                   break inner;
             }
            
            counter += 1;
        }
        
        else if(e.getSource() == queueButton){
             while(!stk.isEmpty()){
                  que.add(stk.pop()); //add stk to que
             }
             
             outputArea.setText("                                                "+que.toString());
             
             
             if(que.isEmpty())
                  outputArea.setText("                                                "+"Queue Is Empty ");
        }

        else if(e.getSource() == listButton){

             while(!que.isEmpty()){
                  list.add(que.remove()); // add que to list
             }
             
             outputArea.setText("                                                "+list.toString());
            
             if(list.isEmpty())
                  outputArea.setText("                                                "+"List Is Empty ");
        }
        
        
        else if(e.getSource() == vectorButton){
               
              while(!list.isEmpty()){
                     for(int i=0; i<list.size(); i++){
                           vectr.add(list.remove(i)); // add list to vectr
                     }
              }
                     
             outputArea.setText("                                                "+vectr.toString());
             if(vectr.isEmpty())
                  outputArea.setText("                                                "+"Vector Is Empty ");
        }
        
        
        else if(e.getSource() == mapButton){ 
        
             int randKey = 0;
             String kv = " ";
             Random rand = new Random();
        
             Set <Integer> setkey = map.keySet();
             Collection <Integer> setvalue = map.values();

             for(int i=0; i<vectr.size(); i++){
                   randKey = rand.nextInt(100) + 1;
                   map.put(randKey, vectr.remove(i));
             }
        
             outputArea.setText("                                 "+map.toString());
             if(map.isEmpty())
                  outputArea.setText("                                                "+"Map Is Empty ");
        }
        
        else{
             outputArea.setText("                                                "+"Invalid Command...");
        }
        
    }
}