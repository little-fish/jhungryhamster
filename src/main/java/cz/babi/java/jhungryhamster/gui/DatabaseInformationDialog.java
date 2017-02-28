
/*
 * Copyright 2017 Martin Misiarz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cz.babi.java.jhungryhamster.gui;

import static cz.babi.java.jhungryhamster.utils.Common.RESOURCE_BUNDLE;

import cz.babi.java.jhungryhamster.data.FileOperations;
import cz.babi.java.jhungryhamster.entity.MyTree;
import cz.babi.java.jhungryhamster.entity.Settings;
import cz.babi.java.jhungryhamster.utils.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

/**
 * Dialogové okno zobrazující informace o databázi
 * @author babi
 */
public class DatabaseInformationDialog extends javax.swing.JDialog {
    
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;
    
    public static Settings settings = Settings.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseInformationDialog.class);

    /** Creates new form DatabaseInformationDialog */
    public DatabaseInformationDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        // Close the dialog when Esc is pressed
        String ok = "ok";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), ok);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(ok, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doClose(RET_OK);
            }
        });
        
        BasicFileAttributes basicFileAttributes = null;
        try {
            basicFileAttributes = Files.readAttributes(FileOperations.getUserDatabaseFile().toPath(), BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        } catch(IOException ioe) {
            LOGGER.error("Can not read file attributes.", ioe);
        }
                
        lblName.setText(settings.getDatabaseName());
        lblLocation.setText(FileOperations.getUserDatabaseFile().getAbsolutePath());
        lblSize.setText(String.valueOf(Math.round(
                FileOperations.getUserDatabaseFile().length()/(double)(1024L*1024L)*100.0)/100.0) + " MB");
        lblDatabaseCreated.setText(Common.convertDateToString(
                Common.DATEFORMAT_RECIPE, new Date(basicFileAttributes.creationTime().toMillis())));
        lblRecipeCount.setText(String.valueOf(MyTree.getRecipeMap().size()));
        lblCategoryCount.setText(String.valueOf(MyTree.getAllSortedCategories().length-1));
        
        this.setLocationRelativeTo(null);
    }

    /** @return the return status of this dialog - one of RET_OK or RET_CANCEL */
    public int getReturnStatus() {
        return returnStatus;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblRecipeCount = new javax.swing.JLabel();
        lblSize = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblCategoryCount = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblDatabaseCreated = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(RESOURCE_BUNDLE.getString("DatabaseInformationDialog.title"));
        setName("Form");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        btnClose.setText(RESOURCE_BUNDLE.getString("Application.text.close"));
        btnClose.setToolTipText(RESOURCE_BUNDLE.getString("Application.text.closeWindow"));
        btnClose.setName("btnClose");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportBorder(null);
        jScrollPane1.setName("jScrollPane1");

        jPanel1.setBorder(null);
        jPanel1.setName("jPanel1");

        jLabel1.setForeground(new java.awt.Color(110, 108, 104));
        jLabel1.setText(RESOURCE_BUNDLE.getString("DatabaseInformationDialog.lblName.text"));
        jLabel1.setName("jLabel1");

        jLabel2.setForeground(new java.awt.Color(110, 108, 104));
        jLabel2.setText(RESOURCE_BUNDLE.getString("DatabaseInformationDialog.lblLocation.text"));
        jLabel2.setName("jLabel2");

        jLabel4.setForeground(new java.awt.Color(110, 108, 104));
        jLabel4.setText(RESOURCE_BUNDLE.getString("DatabaseInformationDialog.lblRecipeCount.text"));
        jLabel4.setName("jLabel4");

        jLabel3.setForeground(new java.awt.Color(110, 108, 104));
        jLabel3.setText(RESOURCE_BUNDLE.getString("DatabaseInformationDialog.lblSize.text"));
        jLabel3.setName("jLabel3");

        jLabel5.setForeground(new java.awt.Color(110, 108, 104));
        jLabel5.setText(RESOURCE_BUNDLE.getString("DatabaseInformationDialog.lblCategoryCount.text"));
        jLabel5.setName("jLabel5");

        lblRecipeCount.setText("");
        lblRecipeCount.setName("lblRecipeCount");

        lblSize.setText("");
        lblSize.setName("lblSize");

        lblLocation.setText("");
        lblLocation.setName("lblLocation");

        lblName.setText("");
        lblName.setName("lblName");

        lblCategoryCount.setText("");
        lblCategoryCount.setName("lblCategoryCount");

        jLabel6.setForeground(new java.awt.Color(110, 108, 104));
        jLabel6.setText(RESOURCE_BUNDLE.getString("DatabaseInformationDialog.lblCreated.text"));
        jLabel6.setName("jLabel6");

        lblDatabaseCreated.setText("");
        lblDatabaseCreated.setName("lblDatabaseCreated");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCategoryCount, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(lblRecipeCount, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(lblSize, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(lblDatabaseCreated, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(lblLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblLocation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblDatabaseCreated))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblRecipeCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblCategoryCount)))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                    .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getRootPane().setDefaultButton(btnClose);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        doClose(RET_OK);
    }//GEN-LAST:event_btnCloseActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_OK);
    }//GEN-LAST:event_closeDialog
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoryCount;
    private javax.swing.JLabel lblDatabaseCreated;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRecipeCount;
    private javax.swing.JLabel lblSize;
    // End of variables declaration//GEN-END:variables
    private int returnStatus = RET_OK;
}