/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cb3;

import Model.DBConnection;

/**
 *
 * @author USER
 */
public class Cb3 {

    public static void main(String[] args) {
        DBConnection.connect();
        MainView mv = new MainView();
        mv.setVisible(true);
    }
}
