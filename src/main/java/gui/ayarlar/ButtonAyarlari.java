/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.ayarlar;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author kazimkalayci
 */
public class ButtonAyarlari {
    /*
    arkaplan ve yazı rengi ayarları
    */
    
    private static Color originalBgColor, originalFgColor;
    
    public static void setBgFg(JButton button, Color bgColor, Color fgColor){
        originalBgColor = button.getBackground();
        originalFgColor = button.getForeground();
        button.setBackground(bgColor);
        button.setForeground(fgColor);
    }
    
    public static void setOriginalBgFg(JButton button){
    button.setBackground(originalBgColor);
    button.setForeground(originalFgColor);
    }
    
    /*
    
    */

   
}
