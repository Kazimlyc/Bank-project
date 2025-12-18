/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.ayarlar;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author kazimkalayci
 */
public class TextAyarlari {

    /*
     odaklanma ayarları
     */
    private static String originalText;
    private static Color originalFgColor;

    public static void checkTheTextFocusGained(JTextField textField, String org) {
        originalText = org;

        if (textField.getText().trim().equals(org)) {
            originalFgColor = textField.getForeground();
            textField.setText("");
        }
        textField.setForeground(Color.blue);

    }

    public static void checkTheTextFocusLost(JTextField textField, String org) {
        originalText = org;

        if (textField.getText().trim().equals("")) {
            textField.setForeground(originalFgColor);
            textField.setText(org);
        } else {
            textField.setForeground(Color.BLACK);
        }

    }

    /*
    Key ayarları
     */
    public static void setOnlyNumber(JTextField textField) {

        textField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }

        });

    }

    public static void setOnlyAlphabetic(JTextField textField) {

        textField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isAlphabetic(c)) {
                    e.consume();
                }
            }

        });

    }

    /*
            limit ayarları
     */
    private static int limit;

    public static void setMaxLimit(JTextField textField, int lim) {
        limit = lim;
        textField.setDocument(new PlainDocument() {

            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null) {
                    return;
                }
                if ((getLength() + str.length()) <= limit) {
                    super.insertString(offs, str, a);
                }
            }

        });
    }
    
    public static boolean uzunlukSundanKucukMu(int length, String str){
    return (str.length() < length);
    }

    /*
        Para Miktari Ayarlari
     */
    public static int checkTheTextKeyReleased(JTextField textField, int moneyLimit) {
        String text = textField.getText();
        if (!text.equals("")) {
            int miktar = Integer.valueOf(text);
            if (miktar > moneyLimit) {
                miktar = moneyLimit;
                textField.setText(String.valueOf(miktar));
            }
            return miktar;
        }

        return 0;

    }

    /*
        Text alanlari kontrolu
     */
    public static boolean textAlanlariDolumu(JPanel panel) {
        Component[] components = panel.getComponents();
        for (Component c : components) {
            if (c instanceof JTextField) {
                JTextField textField = (JTextField) c;
                if (textField.getText().trim().equals("") && textField.isEnabled()) {
                    return false;
                }
            }
        }
        return true;
    }

}
