package com.company.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Label_TextField_Panel
  extends JPanel
{
  JTextField textField;
  JLabel label;
  
  public Label_TextField_Panel( int textfieldSize, String labelText, String defaultTextFieldValue)
  {
    this.label = new JLabel(labelText);
    this.textField = new JTextField(defaultTextFieldValue, textfieldSize);
    add(this.label);
    add(this.textField);
  }
  
  public String getText()
  {
    return this.textField.getText().toString();
  }
}
