package com.company.gui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GUI
  implements ActionListener
{
  public JFrame frame;

  static final int frameWidth = 900;
  static final int frameHeight = 700;
  static final int verticleSplitLocation = 75;
  static final int horizontalSplitLocation = 220;
  public  Label_TextField_Panel AOR_Panel;
  public  Label_TextField_Panel SERVER_IP_Panel;
  public  Label_TextField_Panel SERVER_PORT_Panel;
  public  Label_TextField_Panel CALLED_SIP_Panel;
 
  public JTextArea textArea;
    public JLabel titleLabel;
  private TextField textField;

  private GuiListener listener;


  public static void main(String[] args){
	  GUI gui_object=new GUI();
	  gui_object.createGui();
	  
  }
  
  public void createGui()
  {
    this.frame = new JFrame();
    this.frame.setBounds(150,25,frameWidth,frameHeight);
     final int topPnaelHeght=75;

    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new FlowLayout());

    Dimension leftdimension = new Dimension(220,frameWidth-topPnaelHeght);
    leftPanel.setMaximumSize(leftdimension);
    leftPanel.setMinimumSize(leftdimension);
    leftPanel.setPreferredSize(leftdimension);

    textField = new TextField("Hello World",20);
    Button sendButton = new Button("SEND");
    sendButton.addActionListener(this);
    leftPanel.add(textField);
    leftPanel.add(sendButton);

    
    
    JPanel rightPanel = new JPanel();
    rightPanel.setLayout(new FlowLayout());

    Dimension rightdimension = new Dimension(frameWidth-leftdimension.width,leftdimension.height);
    rightPanel.setMaximumSize(rightdimension);
    rightPanel.setMinimumSize(rightdimension);
    rightPanel.setPreferredSize(rightdimension);
    
    textArea = new JTextArea();
    
    JScrollPane jScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    Dimension scrolldimension = new Dimension(rightdimension.width-10,5*leftdimension.height);
    jScrollPane.setMaximumSize(scrolldimension);
    jScrollPane.setMinimumSize(scrolldimension);
    jScrollPane.setPreferredSize(scrolldimension);
    
    jScrollPane.setViewportView(textArea);
    
    rightPanel.add(jScrollPane);
    JSplitPane splitPane = new JSplitPane(1, leftPanel, rightPanel);
    splitPane.setDividerSize(0);
    splitPane.setDividerLocation(220);
    JPanel topPanel = new JPanel();
    titleLabel = new JLabel("TITLE");
    topPanel.add(titleLabel);
    JPanel bottomPanel = new JPanel();
    bottomPanel.add(splitPane);
    
    JSplitPane splitPane2 = new JSplitPane(0, topPanel, bottomPanel);
    splitPane2.setDividerSize(0);
    splitPane2.setDividerLocation(topPnaelHeght);
    this.frame.add(splitPane2);
    this.frame.setVisible(true);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     
  }
  
  
  
  public void display(String msg)
  {
    textArea.append(msg+"\n");
  }
  
  public void actionPerformed(ActionEvent event)
  {
    String command = event.getActionCommand();
    if (command.equals("SEND"))
    {

      String text = textField.getText().toString();
      if(listener!=null)
        listener.onClickSend(text);
      else System.out.println("gui listener null");


		/*JOptionPane.showMessageDialog(frame,
				    "Pragram couldn'nt resolve local IP,try again",
				    "Local IP Not Found",
				    JOptionPane.ERROR);	*/
	}

   

  }

  public void setGuiListener(GuiListener listener) {
    this.listener = listener;
  }
}
