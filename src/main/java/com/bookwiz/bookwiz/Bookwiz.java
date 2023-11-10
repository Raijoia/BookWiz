/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.bookwiz.bookwiz;

import com.bookwiz.bookwiz.screens.LoginFrame;
import com.formdev.flatlaf.FlatDarkLaf;

/**
 *
 * @author koishi
 */
public class Bookwiz {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FlatDarkLaf.setup();
                new LoginFrame().setVisible(true);
            }
        });
    }
}
