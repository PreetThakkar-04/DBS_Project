package dbs_project;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JOptionPane;

public class FD extends javax.swing.JFrame {
    public FD() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    general gen;
    public int i,num;
    public JList Xa[];
    public JList Ya[];
    public void collectGen(general gen)
    {
        this.gen=gen;
    }
    
    public void collectfds()
    {
        String  na = numberofFDs.getText();
        if (na.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Add non-zero number of FDs!");
        }
        else
        {
            try
            {
                num = Integer.parseInt(na);
            }
            catch(NumberFormatException e)
                    {
                        JOptionPane.showMessageDialog(null, "Invalid number of Attribute");
                    }
            JLabel fds[] = new JLabel[num];
            JButton confirm = new JButton();
            Xa = new JList[num];
            Ya= new JList[num];
            for (int i=0;i<num;i++)
            {
                    fds[i] = new JLabel();
                    fds[i].setText("FD "+(i+1)+":");
                    fds[i].setBounds(30, 5 + 20*i*gen.getNumberOfAttribute() + i*10, 50, 20);
                    fds[i].setFont(new Font("Times New Roma", Font.BOLD, 12));
                    Xa[i] = new JList(gen.attribute);
                    Ya[i] = new JList(gen.attribute);
                    Xa[i].setBounds(50, 5 + 20*i*gen.getNumberOfAttribute() + i*10, 100, 20*gen.getNumberOfAttribute());
                    Ya[i].setBounds(60, 5 + 20*i*gen.getNumberOfAttribute() + i*10, 100, 20*gen.getNumberOfAttribute());
                    Xa[i].setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                    Ya[i].setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                    add(new JScrollPane(Xa[i]));
                    add(new JScrollPane(Ya[i]));
                    fdlabelpanel.add(fds[i]);
                    xattributepanel.add(Xa[i]);
                    yattributepanel.add(Ya[i]);
                    fdlabelpanel.validate();
                    fdlabelpanel.repaint();
                    xattributepanel.validate();
                    xattributepanel.repaint();
                    yattributepanel.validate();
                    yattributepanel.repaint();
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        orangemainpanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        numberofFDs = new javax.swing.JTextField();
        go = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jSplitPane3 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        xattributepanel = new javax.swing.JPanel();
        fdlabelpanel = new javax.swing.JPanel();
        yattributepanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("-");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("X");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Functional Dependancies");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(322, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(233, 233, 233)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        orangemainpanel.setBackground(new java.awt.Color(255, 153, 0));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Enter number of FDs :");

        numberofFDs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        go.setBackground(new java.awt.Color(0, 0, 102));
        go.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        go.setForeground(new java.awt.Color(255, 255, 255));
        go.setText("Go");
        go.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        go.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("X");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Y");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel7.setText("→");

        jSplitPane3.setDividerLocation(330);
        jSplitPane3.setPreferredSize(new java.awt.Dimension(579, 5000));

        jSplitPane2.setDividerLocation(100);

        javax.swing.GroupLayout xattributepanelLayout = new javax.swing.GroupLayout(xattributepanel);
        xattributepanel.setLayout(xattributepanelLayout);
        xattributepanelLayout.setHorizontalGroup(
            xattributepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        xattributepanelLayout.setVerticalGroup(
            xattributepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4996, Short.MAX_VALUE)
        );

        jSplitPane2.setRightComponent(xattributepanel);

        javax.swing.GroupLayout fdlabelpanelLayout = new javax.swing.GroupLayout(fdlabelpanel);
        fdlabelpanel.setLayout(fdlabelpanelLayout);
        fdlabelpanelLayout.setHorizontalGroup(
            fdlabelpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 99, Short.MAX_VALUE)
        );
        fdlabelpanelLayout.setVerticalGroup(
            fdlabelpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4996, Short.MAX_VALUE)
        );

        jSplitPane2.setLeftComponent(fdlabelpanel);

        jSplitPane3.setLeftComponent(jSplitPane2);

        javax.swing.GroupLayout yattributepanelLayout = new javax.swing.GroupLayout(yattributepanel);
        yattributepanel.setLayout(yattributepanelLayout);
        yattributepanelLayout.setHorizontalGroup(
            yattributepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );
        yattributepanelLayout.setVerticalGroup(
            yattributepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4998, Short.MAX_VALUE)
        );

        jSplitPane3.setRightComponent(yattributepanel);

        jScrollPane1.setViewportView(jSplitPane3);

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Confirm");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout orangemainpanelLayout = new javax.swing.GroupLayout(orangemainpanel);
        orangemainpanel.setLayout(orangemainpanelLayout);
        orangemainpanelLayout.setHorizontalGroup(
            orangemainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orangemainpanelLayout.createSequentialGroup()
                .addGroup(orangemainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orangemainpanelLayout.createSequentialGroup()
                        .addGroup(orangemainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(orangemainpanelLayout.createSequentialGroup()
                                .addGap(242, 242, 242)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(numberofFDs, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(go))
                            .addGroup(orangemainpanelLayout.createSequentialGroup()
                                .addGap(338, 338, 338)
                                .addComponent(jLabel4)
                                .addGap(92, 92, 92)
                                .addComponent(jLabel7)
                                .addGap(82, 82, 82)
                                .addComponent(jLabel6)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(orangemainpanelLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        orangemainpanelLayout.setVerticalGroup(
            orangemainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orangemainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orangemainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(orangemainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(numberofFDs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(go)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(orangemainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(orangemainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orangemainpanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orangemainpanelLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(248, 248, 248))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(orangemainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(orangemainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void goMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goMouseClicked
        collectfds();
    }//GEN-LAST:event_goMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        ArrayList<ArrayList<String> > x = new ArrayList<ArrayList<String> >();
        ArrayList<ArrayList<String> > y = new ArrayList<ArrayList<String> >();
        int w,z,flag=0;
        for (int j=0;j<num;j++)
        {
            int xindices[] = Xa[j].getSelectedIndices();
            if (xindices.length==0)
            {
                flag=1;
            }
            int yindices[] = Ya[j].getSelectedIndices();
             if (yindices.length==0)
             {
                 flag=1;
             } 
        }
        if (flag==1)
        {
            JOptionPane.showMessageDialog(null, "Select atleast one in all the lists");
        }
        else
        {
           for (w=0;w<num;w++)
        {
           int xindices[] = Xa[w].getSelectedIndices();
           for (z=0;z<xindices.length;z++)
           {
             x.add(new ArrayList<String>());  
             x.get(w).add(z, (String) Xa[w].getModel().getElementAt(xindices[z]));
           }
           int yindices[] = Ya[w].getSelectedIndices();
           for (z=0;z<yindices.length;z++)
           {
             y.add(new ArrayList<String>());
             y.get(w).add(z, (String) Ya[w].getModel().getElementAt(yindices[z]));
           }
        }
        gen.collectNumberOffds(num);
        gen.collectfds(x, y);
        FinalDescription fdesc = new FinalDescription();
        fdesc.setVisible(true);
        fdesc.pack();
        fdesc.setLocationRelativeTo(null);
        fdesc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fdesc.collectGen(gen);
        this.dispose(); 
        }
    }//GEN-LAST:event_jButton1MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fdlabelpanel;
    public javax.swing.JButton go;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    public javax.swing.JTextField numberofFDs;
    private javax.swing.JPanel orangemainpanel;
    private javax.swing.JPanel xattributepanel;
    private javax.swing.JPanel yattributepanel;
    // End of variables declaration//GEN-END:variables
}
