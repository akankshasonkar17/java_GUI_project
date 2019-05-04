import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui {
  

   public static JFrame mainFrame = null;
   public static JTextArea chatText = null;
   public static JTextField chatLine = null;
   public static JLabel statusBar = null;
   public static JTextField ipField = null;
   public static JTextField portField = null;
   public static JRadioButton hostOption = null;
   public static JRadioButton guestOption = null;
   public static JButton connectButton = null;
   public static JButton disconnectButton = null;

   private static JPanel initOptionsPane() {
      JPanel pane = null;
      ActionAdapter buttonListener = null;

      JPanel optionsPane = new JPanel(new GridLayout(4, 1));

      pane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      pane.add(new JLabel("Item Name:"));
      ipField = new JTextField(10); ipField.setText("Shirt");
      ipField.setEditable(true);
      pane.add(ipField);
      optionsPane.add(pane);

      pane = new JPanel(new FlowLayout(FlowLay));
      pane.add(new JLabel("Rate (per unit)"));
      portField = new JTextField(10); portField.setEditable(true);
      portField.setText("550");
      pane.add(portField);
      optionsPane.add(pane);

      pane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      pane.add(new JLabel("Quantity"));
      portField = new JTextField(10); portField.setEditable(true);
      portField.setText("5");
      pane.add(portField);
      optionsPane.add(pane);

      ButtonGroup bg = new ButtonGroup();
      hostOption = new JRadioButton("Host", true);
      guestOption = new JRadioButton("Guest", false);
      bg.add(hostOption);
      bg.add(guestOption);
      pane = new JPanel(new GridLayout(1, 2));
      pane.add(hostOption);
      pane.add(guestOption);
      optionsPane.add(pane);

      JPanel buttonPane = new JPanel(new GridLayout(1, 2));
      buttonListener = new ActionAdapter() {
            public void actionPerformed(ActionEvent e) {

               if (e.getActionCommand().equals("connect")) {
                  connectButton.setEnabled(false);
                  disconnectButton.setEnabled(true);
               }
               else {
                  connectButton.setEnabled(true);
                  disconnectButton.setEnabled(false);
               }
            }
         };
      connectButton = new JButton("Connect");
      connectButton.setActionCommand("connect");
      connectButton.addActionListener(buttonListener);
      disconnectButton = new JButton("Disconnect");
      disconnectButton.setActionCommand("disconnect");
      disconnectButton.addActionListener(buttonListener);
      buttonPane.add(connectButton);
      buttonPane.add(disconnectButton);
      optionsPane.add(buttonPane);

      return optionsPane;
   }

   private static void Gui() {
      statusBar = new JLabel();
      statusBar.setText("Offline");

      JPanel optionsPane = initOptionsPane();

      JPanel chatPane = new JPanel(new BorderLayout());
      chatText = new JTextArea(10, 20);
      chatText.setLineWrap(true);
      chatText.setEditable(false);
      chatText.setForeground(Color.blue);
      JScrollPane chatTextPane = new JScrollPane(chatText,
         JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
         JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      chatLine = new JTextField();
      chatLine.setEnabled(false);
      chatPane.add(chatLine, BorderLayout.SOUTH);
      chatPane.add(chatTextPane, BorderLayout.CENTER);
      chatPane.setPreferredSize(new Dimension(200, 200));

      JPanel mainPane = new JPanel(new BorderLayout());
      mainPane.add(statusBar, BorderLayout.SOUTH);
      mainPane.add(optionsPane, BorderLayout.WEST);
      mainPane.add(chatPane, BorderLayout.CENTER);

      mainFrame = new JFrame("Simple TCP Chat");
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainFrame.setContentPane(mainPane);
      mainFrame.setSize(mainFrame.getPreferredSize());
      mainFrame.setLocation(200, 200);
      mainFrame.pack();
      mainFrame.setVisible(true);
   }

   public static void main(String args[]) {
      Gui();
   }
}

class ActionAdapter implements ActionListener {
   public void actionPerformed(ActionEvent e) {}
}
