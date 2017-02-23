package com.frames;

import com.dbc.DBConnection;
import com.models.Languages;
import java.awt.Desktop;
import static java.awt.Desktop.getDesktop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Neriman-laptop
 */
public final class Main extends JFrame {

    /**
     * Creates new form Main
     */
    private static final DBConnection listLanguage = new DBConnection();

    /**
     * @main
     */
  
          
    public Main() {
        initComponents();
        setLocationRelativeTo(this);
        this.setTitle("EVIL INSULT GENERATOR");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/imgs/app-icon.png")));

        addCombobox();

        AutoCompleteDecorator.decorate(this.cmbLanguage);
        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);

        cmbLanguage.setRenderer(dlcr);

        StyledDocument doc = txtPaneShow.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        try {

            Document doc1 = Jsoup.connect("http://evilinsult.com/generate_insult.php?lang=en").get();

            Elements links = doc1.select("body");
            for (Element link : links) {
                txtPaneShow.setText("\n" + link.text());
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception ex) {
            txtPaneShow.setText("Insult Outage! Please Check Your Internet Connection And Try Again In Three Minutes");
        }

    }

    /**
     * @void
     */
    public void addCombobox() {

        try {
            for (Languages l : listLanguage.listLanguages()) {
                cmbLanguage.addItem(l);
            }

        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
        }
    }

    public void showWord() {
        try {
            String language;
            Languages l;
            l = (Languages) cmbLanguage.getSelectedItem();
            language = l.getLang();
            Document doc = Jsoup.connect("http://evilinsult.com/generate_insult.php?lang=" + language).get();
            Elements links = doc.select("body");
            for (Element link : links) {
                txtPaneShow.setText("\n" + link.text());
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception ex) {
            txtPaneShow.setText("\n" + "Insult Outage! Please Check Your Internet Connection And Try Again In Three Minutes");
        }
    }

    /**
     *
     * @param URL
     */
    public void webPages(String URL) {

        try {
            getDesktop().browse(URI.create(URL));
        } catch (IOException ex) {
            // Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({"unchecked", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnGenerate = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        txtPaneShow = new javax.swing.JTextPane();
        cmbLanguage = new javax.swing.JComboBox();
        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        javax.swing.JMenu jMenu2 = new javax.swing.JMenu();
        javax.swing.JPopupMenu.Separator jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItem2 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItem3 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItem4 = new javax.swing.JMenuItem();
        javax.swing.JMenu jMenu3 = new javax.swing.JMenu();
        javax.swing.JMenu jMenu4 = new javax.swing.JMenu();
        javax.swing.JMenu jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(13, 109, 179));
        setMinimumSize(new java.awt.Dimension(742, 465));
        setState(4);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(13, 109, 179));
        jPanel1.setForeground(new java.awt.Color(204, 255, 51));

        btnGenerate.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerate.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnGenerate.setForeground(new java.awt.Color(51, 204, 255));
        btnGenerate.setText("Generate Insult");
        btnGenerate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGenerate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        txtPaneShow.setBackground(new java.awt.Color(13, 109, 179));
        txtPaneShow.setBorder(null);
        txtPaneShow.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        txtPaneShow.setForeground(new java.awt.Color(13, 109, 179));
        txtPaneShow.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPaneShow.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPaneShow.setMaximumSize(new java.awt.Dimension(214, 2147483647));
        txtPaneShow.setSelectionColor(java.awt.Color.blue);
        jScrollPane2.setViewportView(txtPaneShow);

        cmbLanguage.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cmbLanguage.setForeground(new java.awt.Color(51, 204, 255));
        cmbLanguage.setAlignmentX(1.0F);
        cmbLanguage.setAlignmentY(1.0F);
        cmbLanguage.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jScrollPane2)
                .addGap(96, 96, 96))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(cmbLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(266, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(cmbLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(4, 6, 78));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(233, 40));

        jMenu1.setBackground(new java.awt.Color(2, 2, 17));
        jMenu1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setForeground(new java.awt.Color(51, 204, 255));
        jMenu1.setText("            Generate            ");
        jMenu1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu1.setOpaque(true);
        jMenu1.setPreferredSize(new java.awt.Dimension(300, 23));
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(2, 2, 17));
        jMenu2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu2.setForeground(new java.awt.Color(51, 204, 255));
        jMenu2.setText("            Social            ");
        jMenu2.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jMenu2.setOpaque(true);
        jMenu2.setPreferredSize(new java.awt.Dimension(300, 23));

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jMenu2.add(jSeparator1);

        jMenuItem1.setBackground(new java.awt.Color(2, 2, 17));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(51, 204, 255));
        jMenuItem1.setText("Proposal               ");
        jMenuItem1.setOpaque(true);
        jMenuItem1.setPreferredSize(new java.awt.Dimension(150, 22));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setBackground(new java.awt.Color(2, 2, 17));
        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem2.setForeground(new java.awt.Color(51, 204, 255));
        jMenuItem2.setText("Facebook");
        jMenuItem2.setOpaque(true);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setBackground(new java.awt.Color(2, 2, 17));
        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(51, 204, 255));
        jMenuItem3.setText("Twitter");
        jMenuItem3.setOpaque(true);
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setBackground(new java.awt.Color(2, 2, 17));
        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem4.setForeground(new java.awt.Color(51, 204, 255));
        jMenuItem4.setText("Newsletter");
        jMenuItem4.setOpaque(true);
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(2, 2, 17));
        jMenu3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu3.setForeground(new java.awt.Color(51, 204, 255));
        jMenu3.setText("            Contact            ");
        jMenu3.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jMenu3.setOpaque(true);
        jMenu3.setPreferredSize(new java.awt.Dimension(300, 23));
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setBackground(new java.awt.Color(2, 2, 17));
        jMenu4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu4.setForeground(new java.awt.Color(51, 204, 255));
        jMenu4.setText("            Website            ");
        jMenu4.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jMenu4.setOpaque(true);
        jMenu4.setPreferredSize(new java.awt.Dimension(300, 23));
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu5.setBackground(new java.awt.Color(2, 2, 17));
        jMenu5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu5.setForeground(new java.awt.Color(51, 204, 255));
        jMenu5.setText("            Legal            ");
        jMenu5.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jMenu5.setOpaque(true);
        jMenu5.setPreferredSize(new java.awt.Dimension(300, 23));
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        evt.getID();
        showWord();

    }//GEN-LAST:event_btnGenerateActionPerformed

    private void formWindowStateChanged(WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        evt.getID();
        int x = this.getWidth() / 2;
        int y = this.getHeight();
        cmbLanguage.setLocation(x - cmbLanguage.getPreferredSize().width / 2, y - 110);
        jPanel1.add(cmbLanguage);

        btnGenerate.setLocation(x - btnGenerate.getPreferredSize().width, y - 220);
        jPanel1.add(btnGenerate);

        if (y != 503) {
            java.awt.Dimension dim = new java.awt.Dimension(275, 21);
            jMenuItem1.setPreferredSize(dim);
        } else {
            java.awt.Dimension dim = new java.awt.Dimension(150, 21);
            jMenuItem1.setPreferredSize(dim);
        }

    private void jMenuItem2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        evt.getID();
        String URL = "https://www.facebook.com/EvilInsultGenerator/";
        webPages(URL);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        evt.getID();
        String URL = "https://twitter.com/__E__I__G__";
        webPages(URL);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        evt.getID();
        String URL = "https://evilinsult.com/newsletter/";
        webPages(URL);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu4MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        evt.getID();
        String URL = "https://evilinsult.com/";
        webPages(URL);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu5MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        evt.getID();
        String URL = "https://evilinsult.com/legal.html";
        webPages(URL);
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu3MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        evt.getID();
        Desktop desktop = getDesktop();
        try {
            try {
                desktop.mail(new URI("mailto:marvin@evilinsult.com?Subject=Evil%20Insult%20Generator%20Contact&Body=Marvin%2C%20fuck%20you%21"));
            } catch (URISyntaxException ex) {
                //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            //  Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenuItem1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Desktop desktop = getDesktop();
        evt.getID();
        try {
            try {
                desktop.mail(new URI("mailto:marvin@evilinsult.com?Subject=Evil%20Insult%20Generator%20Proposal&Body=Hej%20fuckers%2C%0A%0Aplease%20add%20this%20beauty%3A%0A%0Ainsult%3A%20...%0Alanguage%3A%20...%0Acomment%20%28optional%29%3A%20...%0A%0A...%0A"));
            } catch (URISyntaxException ex) {
                //   Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            //  Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerate;
    private javax.swing.JComboBox cmbLanguage;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextPane txtPaneShow;
    // End of variables declaration//GEN-END:variables
}
