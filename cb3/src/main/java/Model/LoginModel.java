/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import static Model.DBConnection.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class LoginModel {
    private final String user;
    private final String pass;
    
    public LoginModel(String user, String pass){
        this.user = user;
        this.pass = pass;
    }
    
    public void login(javax.swing.JFrame frame, javax.swing.JPanel mainPanel, javax.swing.JPanel contentPanel, javax.swing.JPanel dasbor, javax.swing.JPanel konten){
        DBConnection.connect();
        
        String sql = "SELECT * FROM login WHERE user = ? AND pass = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, user);
            stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                //loginFrame.setVisible(false);
                mainPanel.removeAll();
                mainPanel.repaint();
                mainPanel.revalidate();

                mainPanel.add(dasbor);
                mainPanel.repaint();
                mainPanel.revalidate();

                contentPanel.removeAll();
                contentPanel.repaint();
                contentPanel.revalidate();

                contentPanel.add(konten);
                contentPanel.repaint();
                contentPanel.revalidate();
                
            }else{
                JOptionPane.showMessageDialog(frame,"Invalid username or password.");
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
}
