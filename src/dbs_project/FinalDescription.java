
package dbs_project;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FinalDescription extends javax.swing.JFrame {

    general gen;
    public FinalDescription() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
        public JLabel type[];
        public JLabel originalattri[];
        public JLabel numbercandidate[];
        public JLabel candidates[][];
        public JLabel NF;
        public JLabel NNF;
        public JLabel numberrelation[];
        public JLabel relations[][];
        public JLabel numberpk[];
        public JLabel pks[][];
    public void collectGen(general gen)
    {
        this.gen=gen;
    }
    void finalDisplay()
    {
        int na =gen.getNumberOfAttribute();
        String attri[] = new String[na];
        attri = gen.getAttributes();
        ArrayList<ArrayList<String> > cks = new ArrayList<ArrayList<String> >();
        ArrayList<ArrayList<String> > rel = new ArrayList<ArrayList<String> >();
        ArrayList<ArrayList<String> > pk = new ArrayList<ArrayList<String> >();
        cks = gen.getCandidateKeys();
        int s = gen.getNumberOfCandidateKeys();
        String n =gen.getNormalForm();
        rel=gen.getDecomposedRelation();
        int r = gen.getNumberOfDecomposedRelation();
        pk=gen.getPrimaryKeys();
        type = new JLabel[5];
        originalattri = new JLabel[na];
        numbercandidate = new JLabel[s];
        candidates = new JLabel[s][20];
        NF = new JLabel();
        NNF = new JLabel();
        numberrelation = new JLabel[r];
        relations = new JLabel[r][20];
        numberpk = new JLabel[r];
        pks = new JLabel[r][20];
        for (int i=0;i<5;i++)
        {
            type[i] = new JLabel();
        }
        for (int i=0;i<na;i++)
        {
            originalattri[i] = new JLabel();
        }
        for (int i=0;i<s;i++)
        {
            numbercandidate[i] = new JLabel();
        }
        for (int i=0;i<s;i++)
        {
            for (int j=0;j<cks.get(i).size();j++)
            {
                candidates[i][j] = new JLabel();
            }
        }
        for (int i=0;i<r;i++)
        {
            numberrelation[i] = new JLabel();
        }
        for (int i=0;i<r;i++)
        {
            for (int j=0;j<rel.get(i).size();j++)
            {
                relations[i][j] = new JLabel();
            }
        }
        for (int i=0;i<r;i++)
        {
            numberpk[i] = new JLabel();
        }
        for (int i=0;i<r;i++)
        {
            for (int j=0;j<pk.get(i).size();j++)
            {
                pks[i][j] = new JLabel();
            }
        }
        type[0].setText("Original Relation :");
        type[1].setText("Candidate Keys :");
        type[2].setText("Highest NF :");
        type[3].setText("Next NF :");
        type[4].setText("Decomposed Relations :");
        for (int i=0;i<5;i++)
        {
            type[i].setFont(new Font("Times New Roma", Font.BOLD, 12));
        }
        for (int i=0;i<na;i++)
        {
            originalattri[i].setText(""+attri[i]+"");
        }
        for (int i=0;i<s;i++)
        {
            numbercandidate[i].setText(""+(i+1)+". ");
        }
        for (int i=0;i<s;i++)
        {
            for (int j=0;j<cks.get(i).size();j++)
            {
                candidates[i][j].setText(""+cks.get(i).get(j)+"");
            }
        }
        NF.setText(""+n);
        NNF.setText(""+gen.getNextNormalForm());
        for (int i=0;i<r;i++)
        {
            numberrelation[i].setText("Relation "+(i+1)+". ");
        }
        for (int i=0;i<r;i++)
        {
            for (int j=0;j<rel.get(i).size();j++)
            {
                relations[i][j].setText(""+rel.get(i).get(j)+"");
            }
        }
        for (int i=0;i<r;i++)
        {
            numberpk[i].setText("Primary Key : ");
        }
        for (int i=0;i<r;i++)
        {
            for (int j=0;j<pk.get(i).size();j++)
            {
                pks[i][j].setText(""+pk.get(i).get(j)+"");
            }
        }
        type[0].setBounds(50, 5, 150, 40);
        for (int i=0;i<na;i++)
        {
            originalattri[i].setBounds(50 + i*100 + i*10, 5, 100, 40);
        }
        type[1].setBounds(50, 60, 150, 40);
        for (int i=0;i<s;i++)
        {
            numbercandidate[i].setBounds(50,60 + i*40 + i*10, 20, 40);
        }
        for (int i=0;i<s;i++)
        {
            for (int j=0;j<cks.get(i).size();j++)
            {
                candidates[i][j].setBounds(120+100*j,60 + i*40 + i*10, 100, 40);
            }
        }
        int temp = 60 + (s-1)*40 + (s-1)*10 + 40 + 15;
        type[2].setBounds(50, temp, 150, 40);
        NF.setBounds(50, temp, 150, 40);
        temp = temp+55;
        type[3].setBounds(50, temp, 150, 40);
        NNF.setBounds(50, temp, 150, 40);
        temp = temp+55;
        type[4].setBounds(50, temp, 150, 40);
        int t= temp,te=temp+50;
        for (int i=0;i<r;i++)
        {
            numberrelation[i].setBounds(50, temp, 100, 40);
            temp = temp + 50;
            numberpk[i].setBounds(50, temp, 100, 40);
            temp = temp + 50;
        }
        for (int i=0;i<r;i++)
        {
            for (int j=0;j<rel.get(i).size();j++)
            {
                relations[i][j].setBounds(160 + 100*j, t, 100, 40);
            }
            t=t+100;
        }
        for (int i=0;i<r;i++)
        {
            for (int j=0;j<pk.get(i).size();j++)
            {
                pks[i][j].setBounds(160 + 100*j, te, 100, 40);
            }
            te=te+100;
        }
        for (int i=0;i<5;i++)
        {
            typepanel.add(type[i]);
        }
        for (int i=0;i<na;i++)
        {
            contentpanel.add(originalattri[i]);
        }
        for (int i=0;i<s;i++)
        {
            contentpanel.add(numbercandidate[i]);
        }
        for (int i=0;i<s;i++)
        {
            for (int j=0;j<cks.get(i).size();j++)
            {
                contentpanel.add(candidates[i][j]);
            }
        }
        contentpanel.add(NF);
        contentpanel.add(NNF);
        for (int i=0;i<r;i++)
        {
            contentpanel.add(numberrelation[i]);
            contentpanel.add(numberpk[i]);
        }
        for (int i=0;i<r;i++)
        {
            for (int j=0;j<rel.get(i).size();j++)
            {
                contentpanel.add(relations[i][j]);
            }
        }
        for (int i=0;i<r;i++)
        {
            for (int j=0;j<pk.get(i).size();j++)
            {
               contentpanel.add( pks[i][j]);
            }
        }
        typepanel.validate();
        typepanel.repaint();
        contentpanel.validate();
        contentpanel.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        typepanel = new javax.swing.JPanel();
        contentpanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
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
        jLabel1.setText("Final Description");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(416, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(350, 350, 350)
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

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setToolTipText("");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setMinimumSize(new java.awt.Dimension(1000, 102));
        jSplitPane1.setPreferredSize(new java.awt.Dimension(3000, 1500));

        javax.swing.GroupLayout typepanelLayout = new javax.swing.GroupLayout(typepanel);
        typepanel.setLayout(typepanelLayout);
        typepanelLayout.setHorizontalGroup(
            typepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );
        typepanelLayout.setVerticalGroup(
            typepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1498, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(typepanel);

        javax.swing.GroupLayout contentpanelLayout = new javax.swing.GroupLayout(contentpanel);
        contentpanel.setLayout(contentpanelLayout);
        contentpanelLayout.setHorizontalGroup(
            contentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2794, Short.MAX_VALUE)
        );
        contentpanelLayout.setVerticalGroup(
            contentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1498, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(contentpanel);

        jScrollPane1.setViewportView(jSplitPane1);

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Show");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back to main page");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(438, 438, 438)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(116, 116, 116))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        finalDisplay();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        MainPage mp = new MainPage();
        mp.setVisible(true);
        mp.pack();
        mp.setLocationRelativeTo(null);
        mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinalDescription().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentpanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel typepanel;
    // End of variables declaration//GEN-END:variables
}
