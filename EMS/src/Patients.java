
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter.Entry;
import jess.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bharat
 */
public class Patients extends javax.swing.JFrame {
    
    
 Connection con = null;
    ResultSet rs,rs1,rs2,rs3,rs4,rs5 = null;
    PreparedStatement pst,pst1,pst2,pst3,pst4,pst5 = null;
    
    
    ArrayList<String> imp = new ArrayList<String>();

    
    //DefaultComboBoxModel list = new DefaultComboBoxModel();
    //JComboBox cbo_cats = new JComboBox(list);
    //String sql = "Select * from Symptoms";
    public void connect(){
        try{
        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=login;user=sa;password=bharat02101998;");
        String connectionUrl = "jdbc:sqlserver://BHARAT:1433;databaseName=MedicalDatabase;user=sa;password=bharat02101998";
        Connection con = DriverManager.getConnection(connectionUrl); 
        Statement stmt = con.createStatement();
            //System.out.println("hi");
            
       

            String sql = "Select distinct Symptom1 from DiseaseSymptoms"; 
            //System.out.println("hi");
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                jComboBox1.addItem(rs.getString("Symptom1"));
               
                  
            }
            
        String sql1 = "Select distinct Symptom2 from DiseaseSymptoms";
        pst1 = con.prepareStatement(sql1);
        
        rs1 = pst1.executeQuery();
        while(rs1.next()){
             jComboBox2.addItem(rs1.getString("Symptom2"));
            
             }
        
         String sql2 = "Select distinct Symptom3 from DiseaseSymptoms";
        pst2 = con.prepareStatement(sql2);
        
        rs2 = pst2.executeQuery();
        while(rs2.next()){
             jComboBox3.addItem(rs2.getString("Symptom3"));
            
             }
        
        String sql3 = "Select distinct Symptom4 from DiseaseSymptoms";
        pst3 = con.prepareStatement(sql3);
        
        rs3 = pst3.executeQuery();
        while(rs3.next()){
             jComboBox4.addItem(rs3.getString("Symptom4"));
            
             }
        
         String sql4 = "list ";
        pst4 = con.prepareStatement(sql4);
        
        rs4 = pst4.executeQuery();
        while(rs4.next()){
             jComboBox5.addItem(rs4.getString("Symptom5"));
            
             }
        
        
        }
        catch(SQLException | HeadlessException ex){
            
            JOptionPane.showMessageDialog(null,ex);
    }             

        
    }
    
    public void diagnosis(){
        
        imp.clear();
        
        
        
        String s1 = (String)jComboBox1.getSelectedItem().toString();
        String s2 = (String)jComboBox2.getSelectedItem().toString();
        String s3 = (String)jComboBox3.getSelectedItem().toString();
        String s4 = (String)jComboBox4.getSelectedItem().toString();
        String s5 = (String)jComboBox5.getSelectedItem().toString(); 
        
        
        try{
        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=login;user=sa;password=bharat02101998;");
        String connectionUrl = "jdbc:sqlserver://BHARAT:1433;databaseName=MedicalDatabase;user=sa;password=bharat02101998";
        Connection con = DriverManager.getConnection(connectionUrl); 
        
        
        String sql = "Select Disease from DiseaseSymptoms where Symptom1=?";
        pst = con.prepareStatement(sql);
        pst.setString(1,s1);
        rs = pst.executeQuery();
        while(rs.next()){
            imp.add(rs.getString("Disease"));
                
        }
        
        String sql1 = "Select Disease from DiseaseSymptoms where Symptom2=?";
        pst1 = con.prepareStatement(sql1);
        pst1.setString(1,s2);
        rs1 = pst1.executeQuery();
        while(rs1.next()){
            imp.add(rs1.getString("Disease"));
                
        }
        
        String sql2 = "Select Disease from DiseaseSymptoms where Symptom3=?";
        pst2 = con.prepareStatement(sql2);
        pst2.setString(1,s3);
        rs2 = pst2.executeQuery();
        while(rs2.next()){
            imp.add(rs2.getString("Disease"));
        }
            
        String sql3 = "Select Disease from DiseaseSymptoms where Symptom4=?";
        pst3 = con.prepareStatement(sql3);
        pst3.setString(1,s4);
        rs3 = pst3.executeQuery();
        while(rs3.next()){
            imp.add(rs3.getString("Disease"));
            
        }
        String sql4 = "Select Disease from DiseaseSymptoms where Symptom5=?";
        pst4 = con.prepareStatement(sql4);
        pst4.setString(1,s5);
        rs4 = pst4.executeQuery();
        while(rs4.next()){
            imp.add(rs4.getString("Disease"));
        }
        }
        
        
        catch(SQLException | HeadlessException ex){
             JOptionPane.showMessageDialog(null,ex);
        }
        
        //System.out.println(imp);
                
       Map<String, Integer> stringsCount = new HashMap<>();
       for(String s: imp)
{
  Integer c = stringsCount.get(s);
  if(c == null) c = new Integer(0);
  c++;
  stringsCount.put(s,c);
}
       
       Map.Entry<String,Integer> mostRepeated = null;
for(Map.Entry<String, Integer> e: stringsCount.entrySet())
{
    if(mostRepeated == null || mostRepeated.getValue()<e.getValue())
        mostRepeated = e;
}

 String dis = mostRepeated.getKey();
 System.out.println(dis);
 
 try{
     
 con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=login;user=sa;password=bharat02101998;");
        String connectionUrl = "jdbc:sqlserver://BHARAT:1433;databaseName=MedicalDatabase;user=sa;password=bharat02101998";
        Connection con = DriverManager.getConnection(connectionUrl); 
        
 
 //String sql5 = "Select 'Description' +CHAR(13)+ 'Prescription' +CHAR(13)+ 'Doasge' +CHAR(13)+ 'Warning' from Prescription where Disease=?;";
 String sql5 = "Select * from Prescription where Disease=?";
        pst5 = con.prepareStatement(sql5);
        pst5.setString(1,dis);
        rs5 = pst5.executeQuery();
        while(rs5.next()){
            
            
            String report = rs5.getString("Description");
            String report1 = rs5.getString("Prescription");
            String report2 = rs5.getString("Dosage");
            String report3 = rs5.getString("Warning");
            
            String finalreport = dis + "\n" + report + "\n" + report1 +  "\n" + report2 + "\n" + report3;



            
            
            JOptionPane.showMessageDialog(new JFrame(),finalreport);
            
        }
        
 }
 catch(SQLException | HeadlessException ex){
             JOptionPane.showMessageDialog(null,ex);
        }
 
 
 
 
 
       
               
        
        
       
       
                
                
                
        
        
    }
                


    /**
     * Creates new form Patients
     */
    public Patients() {
        initComponents();
        connect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        diagnosis = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Please Enter All the Symptoms");

        jLabel2.setText("Symptom1");

        jLabel3.setText("Symptom2");

        jLabel4.setText("Symptom3");

        jLabel5.setText("Symptom4");

        jLabel6.setText("Symptom5");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        diagnosis.setText("Geneate Diagnosis");
        diagnosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagnosisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(diagnosis)))
                .addContainerGap(362, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(182, 182, 182)
                .addComponent(diagnosis)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void diagnosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diagnosisActionPerformed
        // TODO add your handling code here:
        diagnosis();
    }//GEN-LAST:event_diagnosisActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Patients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patients().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton diagnosis;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
