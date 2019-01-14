package com.intellij.plugin;

import com.intellij.openapi.wm.ToolWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MyToolWindow {

  private JTextField YEmail;
  private JTextField REmail;
  private JPasswordField YPass;
  private JButton BSend;
  private JButton BCancel;
  private JTextArea AText;
  private JTextField Theme;
  private javax.swing.JPanel JPanel;
  private JCheckBox Save;

  MyToolWindow(ToolWindow toolWindow) {
    BSend.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        SendEmail.sendSomeEmail(YEmail.getText(), YPass.getText(), new String[]{REmail.getText()},
            Theme.getText(), AText.getText());
        toolWindow.hide(null);
        setClear();
        if (!Save.isSelected()) {
          YEmail.setText("");
          YPass.setText("");
        }
      }
    });

    BCancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setClear();
        if (!Save.isSelected()) {
          YEmail.setText("");
          YPass.setText("");
        }
        toolWindow.hide(null);
      }
    });

    YEmail.getDocument().addDocumentListener(new DocumentListener() {
      @Override
      public void insertUpdate(DocumentEvent e) {
        changed();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        changed();
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        changed();
      }
    });

    YPass.getDocument().addDocumentListener(new DocumentListener() {
      @Override
      public void insertUpdate(DocumentEvent e) {
        changed();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        changed();
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        changed();
      }
    });

    REmail.getDocument().addDocumentListener(new DocumentListener() {
      @Override
      public void insertUpdate(DocumentEvent e) {
        changed();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        changed();
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        changed();
      }
    });

  }

  private void changed() {
    if (YEmail.getText().isEmpty() || YPass.getText().isEmpty() || REmail.getText().isEmpty())
      BSend.setEnabled(false);
    else
      BSend.setEnabled(true);
  }


  private void setClear() {
    REmail.setText("");
    Theme.setText("");
    AText.setText("");
  }

  public void setData(GUI data) {
    REmail.setText(data.getREmail());
    YEmail.setText(data.getYEmail());
    Theme.setText(data.getTEmail());
    YPass.setText(data.getYPass());
    AText.setText(data.getAText());
  }

  public void getData(GUI data) {
    data.setREmail(REmail.getText());
    data.setYEmail(YEmail.getText());
    data.setTEmail(Theme.getText());
    data.setYPass(YPass.getText());
    data.setAText(AText.getText());
  }

  public boolean isModified(GUI data) {
    if (REmail.getText() != null ? !REmail.getText().equals(data.getREmail())
        : data.getREmail() != null) {
      return true;
    }
    if (YEmail.getText() != null ? !YEmail.getText().equals(data.getYEmail())
        : data.getYEmail() != null) {
      return true;
    }
    if (Theme.getText() != null ? !Theme.getText().equals(data.getTEmail())
        : data.getTEmail() != null) {
      return true;
    }
    if (YPass.getText() != null ? !YPass.getText().equals(data.getYPass())
        : data.getYPass() != null) {
      return true;
    }
    if (AText.getText() != null ? !AText.getText().equals(data.getAText())
        : data.getAText() != null) {
      return true;
    }
    return false;
  }

  JComponent getContent() {
    return JPanel;
  }
}
