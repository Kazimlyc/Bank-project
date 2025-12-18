/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.ayarlar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kazimkalayci
 */
public class Dialogs {

    public static void bosOlamazMesajiGoster(JFrame frame) {
        JOptionPane.showMessageDialog(frame, "Tum alanlar dolu olmalidir!");
    }

    public static void ozelMesajGoster(JFrame frame, String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public static int onayMesajiGoster(JFrame frame, String message) {
        int optionType = JOptionPane.YES_NO_OPTION;
        int selected = JOptionPane.showConfirmDialog(frame, message, "UYARI", optionType);
        
        if (optionType == selected) {
            return 1;
        }
        return 0;
    }

}
