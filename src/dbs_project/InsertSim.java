package dbs_project;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class InsertSim extends javax.swing.JFrame {

    generalHashing gh;
    JTable bucketTable;
    JTable directoryTable;
    String[][] direct ;
    String[][] bucket ;
    String s1,b,keyValue;
    String[] bHead;
    int key,brows,drows;
    public InsertSim() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public void collectGeneral(generalHashing gh)
    {
        this.gh=gh;
    }
    void formulate()
    {
        int flag=0,tr=-1;
        String mom;
        if (keyValues.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Add non-zero number of Key value!");
        }
        else
        {
            try
            {
                key = Integer.parseInt(keyValues.getText());                
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Invalid Keyvalue!");
            }
            int k = (key) % (gh.getN());
            keyValue = Integer.toBinaryString(k);
            for (int i=0;i<brows;i++)
            {
                mom=keyValue;
                    if (mom.length()<gh.lds[i])
                    {
                        int w = gh.lds[i] - mom.length();
                        for (int j=0;j<w;j++)
                        {
                            mom = "0" + mom;
                        }
                    }
                    else if (mom.length()>gh.lds[i])
                    {
                         mom = mom.substring(mom.length() - gh.lds[i]);
                    }
                    mom = "B" + mom;
                if (bucket[i][0].equals(mom))
                {
                    for (int j=1;j<gh.getBfr()+1;j++)
                    {
                        if (bucket[i][j].equals(""))
                        {
                            bucket[i][j] = Integer.toString(key);
                            flag=1;
                            break;
                        }
                    }
                    if (flag==0)
                        tr = i;
                }
                if (flag==1)
                    break;
        }
        buckets.validate();
        buckets.repaint();
        if (flag==0)
            updateTable(tr);
        }
        keyValues.setText("");
    }
    void updateTable(int rn)
    {
        if (gh.lds[rn] + 1<=gh.getGD())
        {
            bucketUpdate(rn);
        }
        else
        {
            directoryUpdate();
            bucketUpdate(rn);
        }
    }
    void bucketUpdate(int rn)
    {
        String dtemp = bucket[rn][0];
        int ke,l;
        String temp;
        brows++;
        gh.changeLDs(rn);
        for (int i=brows-1;i>rn+1;i--)
        {
            bucket[i] = bucket[i-1].clone();
            java.util.Arrays.fill(bucket[i-1],"");
        }
        String h = bucket[rn][0].substring(1);
        int y = gh.getBfr() +1;
        String tep[] = new String[y];
        for (int i=1;i<y;i++)
        {
            tep[i-1] = bucket[rn][i];
        }
        java.util.Arrays.fill(bucket[rn],"");
        java.util.Arrays.fill(bucket[rn+1],"");
        bucket[rn+1][0] = "B1" + h;
        bucket[rn][0] = "B0" + h;
        for (int i=1;i<y;i++)
        {
            l = Integer.parseInt(tep[i-1]);
            ke = (l) % (gh.getN());
            temp = Integer.toBinaryString(ke);
            if (temp.length()<gh.lds[rn])
            {
                int w = gh.lds[rn] - temp.length();
                for (int j=0;j<w;j++)
                {
                    temp = "0" + temp;
                }
            }
            else if (temp.length()>gh.lds[rn])
            {
                temp = temp.substring(temp.length() - gh.lds[rn]);
            }
            temp = "B" +temp;
            if (temp.equals(bucket[rn][0]))
            {
                for (int j=1;j<y;j++)
                {
                    if (bucket[rn][j].equals(""))
                    {
                        bucket[rn][j] = Integer.toString(l);
                        break;
                    }
                }
            }
            else if (temp.equals(bucket[rn+1][0]))
            {
                for (int j=1;j<y;j++)
                {
                    if (bucket[rn+1][j].equals(""))
                    {
                        bucket[rn+1][j] = Integer.toString(l);
                        break;
                    }
                }
            }
        }
        int nextKey = key;
        String nK;
        int v = (nextKey) % (gh.getN());
        nK = Integer.toBinaryString(v);
        if (nK.length()<gh.lds[rn])
        {
            int w = gh.lds[rn] - nK.length();
            for (int i=0;i<w;i++)
            {
                nK = "0" + nK;
            }
        }
        else if (nK.length()>gh.lds[rn])
        {
             nK = nK.substring(nK.length() - gh.lds[rn]);
        }
        nK = "B" + nK;
        if (nK.equals(bucket[rn][0]))
            {
                for (int j=1;j<y;j++)
                {
                    if (bucket[rn][j].equals(""))
                    {
                        bucket[rn][j] = Integer.toString(nextKey);
                        break;
                    }
                }
            }
            else if (nK.equals(bucket[rn+1][0]))
            {
                for (int j=1;j<y;j++)
                {
                    if (bucket[rn+1][j].equals(""))
                    {
                        bucket[rn+1][j] = Integer.toString(nextKey);
                        break;
                    }
                }
            }
        String lop;
        for (int i=0;i<drows;i++)
        {
            if (dtemp.equals(direct[i][1]))
            {
                lop = "0" + direct[i][1].substring(1);
                if (direct[i][0].substring(direct[i][0].length() - gh.lds[rn]).equals(lop))
                {
                    lop = "B" + lop;
                    direct[i][1] = lop;
                }
                else
                {
                    lop = "B1" + direct[i][1].substring(1);
                    direct[i][1] = lop;
                }
            }
        }
        directory.validate();
        directory.repaint();
    }
    void directoryUpdate()
    {
        gh.collectGD(gh.getGD()+1);
        drows = (int) Math.pow(2, gh.getGD());
        for (int i=0;i<drows;i++)
        {
            direct[i][0] = Integer.toBinaryString(i);
            if (direct[i][0].length()!=gh.getGD())
                addZero(direct[i][0],i);
            for (int j=0;j<brows;j++)
            {
                String s2 = direct[i][0].substring(direct[i][0].length() - gh.lds[j]);
                direct[i][1] = "B" + s2;
            }
        }
        directory.validate();
        directory.repaint();
    }
    void addZero(String s,int q)
    {
        int w = gh.getGD() - s.length();
        for (int i=0;i<w;i++)
        {
            direct[q][0] = "0" + direct[q][0];
        }
    }
    void addZeros(String q, int j)
    {
        int w = gh.getLD() - q.length();
        for (int i=0;i<w;i++)
        {
            s1 = "0" + s1;
        }
    }
    void initialTable()
    {
        drows = (int) Math.pow(2, gh.getGD());
        brows = (int) Math.pow(2, gh.getLD());
        direct = new String[1000][2];
        bucket = new String[1000][gh.getBfr() + 1];
        for (int i=0;i<drows;i++)
        {
            direct[i][0] = Integer.toBinaryString(i);
            if (direct[i][0].length()!=gh.getGD())
                addZero(direct[i][0],i);
            String s2 = direct[i][0].substring(direct[i][0].length() - gh.getLD());
            for (int j=0;j<brows;j++)
            {
                s1 = Integer.toBinaryString(j);
                if (s1.length()!=gh.getLD())
                    addZeros(s1,j);
                if (s1.equals(s2))
                    direct[i][1] = "B" + s1;
            }
        }
        for (int i=0;i<brows;i++)
        {
                s1 = Integer.toBinaryString(i);
                if (s1.length()!=gh.getLD())
                    addZeros(s1,i);
                bucket[i][0] = "B" + s1;
                // buck.add(new ArrayList<String>());
                // buck.get(i).add(0,bucket[i][0]);
                for (int j=1;j<gh.getBfr() +1;j++)
                {
                    bucket[i][j] = "";
                }
        }
        String[] dHead= { "Global Binary Values", "Bucket Name" };
        directoryTable = new JTable(direct, dHead);
        directoryTable.setRowHeight(directoryTable.getRowHeight() + 25);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0;x<2;x++){
         directoryTable.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }
        JScrollPane jpn = new JScrollPane(directoryTable);
        jpn.setBounds(23, 15, 300, 500);
        directory.add(jpn);
        int y = gh.getBfr() +1;
        bHead = new String[y];
        bHead[0] = "Bucket Name";
        for (int i=1;i<y;i++)
        {
            bHead[i] = "Record " + i;
        }
        bucketTable = new JTable(bucket, bHead);
        bucketTable.setRowHeight(bucketTable.getRowHeight() + 25);
        for(int x=0;x<gh.getBfr() +1;x++)
        {
            bucketTable.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }
        JScrollPane jp = new JScrollPane(bucketTable);
        jp.setBounds(23, 15, 550, 500);
        buckets.add(jp);
        directory.validate();
        directory.repaint();
        buckets.validate();
        buckets.repaint();

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        keyValues = new javax.swing.JTextField();
        insert = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        directory = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        buckets = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

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
        jLabel1.setText("Insert Simulation");

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Begin");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 387, Short.MAX_VALUE)
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
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Enter Key Values to be Inserted :");

        keyValues.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        insert.setBackground(new java.awt.Color(0, 0, 153));
        insert.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        insert.setForeground(new java.awt.Color(255, 255, 255));
        insert.setText("Insert");
        insert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Buckets");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Directory");

        directory.setPreferredSize(new java.awt.Dimension(343, 2000));

        javax.swing.GroupLayout directoryLayout = new javax.swing.GroupLayout(directory);
        directory.setLayout(directoryLayout);
        directoryLayout.setHorizontalGroup(
            directoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
        );
        directoryLayout.setVerticalGroup(
            directoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2000, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(directory);

        buckets.setPreferredSize(new java.awt.Dimension(598, 2000));

        javax.swing.GroupLayout bucketsLayout = new javax.swing.GroupLayout(buckets);
        buckets.setLayout(bucketsLayout);
        bucketsLayout.setHorizontalGroup(
            bucketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );
        bucketsLayout.setVerticalGroup(
            bucketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2000, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(buckets);

        jButton2.setBackground(new java.awt.Color(0, 0, 204));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Proceed");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(286, 286, 286))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(keyValues, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(insert)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(keyValues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insert))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void insertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertMouseClicked
        formulate();
    }//GEN-LAST:event_insertMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       initialTable();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
            gh.collectBucket(bucket,brows);
            SearchSim ss = new SearchSim();
            ss.setVisible(true);
            ss.pack();
            ss.setLocationRelativeTo(null);
            ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ss.collectGeneral(gh);
            this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertSim().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buckets;
    private javax.swing.JPanel directory;
    private javax.swing.JButton insert;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField keyValues;
    // End of variables declaration//GEN-END:variables
}
