
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

import cz.babi.java.jhungryhamster.data.Icons;
import cz.babi.java.jhungryhamster.entity.MyTree;
import cz.babi.java.jhungryhamster.entity.TreeNodes;
import cz.babi.java.jhungryhamster.entity.TreeNodes.Node;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Třída definující vzhled jednoduchého dialogu pro zadání názvu nové, popřípadě
 * editované kategorie.
 * 
 * @author babi
 */
public class CategoryDialog extends javax.swing.JDialog {

    /** A return status code - returned if Cancel button has been pressed */
    public static final int RET_CANCEL = 0;
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;
    
    public static boolean changeTitle;
    public static boolean changeCategory;
    
    private TreeNodes.Node node = null;

    /** Creates new form CategoryDialog */
    public CategoryDialog(java.awt.Frame parent, boolean modal, String windowTitle, TreeNodes.Node node) {
        super(parent, modal);
        this.node = node;
        
        changeCategory = false;
        changeTitle = false;
        
        initComponents();
        
        this.setIconImage(Icons.HAMSTER_LOGO.getImage());
        
        if(node!=null) {
            txtfName.setText(node.getTitle());
            
            Node[] tempAllCategories = new Node[MyTree.getAllSortedCategories().length-1];
            for(int i=0, j=0; i<MyTree.getAllSortedCategories().length; i++, j++) {
                if(MyTree.getAllSortedCategories()[i].getIdNode()!=node.getIdNode())
                    tempAllCategories[j] = MyTree.getAllSortedCategories()[i];
                else j = j - 1;
            }
            
            cmbCategory.setModel(new DefaultComboBoxModel(tempAllCategories));
            
            for(int i=0; i<tempAllCategories.length; i++) {
                if(tempAllCategories[i].getIdNode()==node.getIdParent()) {
                    cmbCategory.setSelectedIndex(i);
                    break;
                }
            }
        } else {
            if(MyTree.getCurrentCategory()!=null) {
                for(int i=0; i<MyTree.getAllSortedCategories().length; i++) {
                    if(MyTree.getAllSortedCategories()[i].getIdNode()==MyTree.getCurrentCategory().getIdNode()) {
                        cmbCategory.setSelectedIndex(i);
                        break;
                    }
                }
            }
        }
        
        this.setTitle(windowTitle);
        this.setLocationRelativeTo(null);
        
        txtfName.requestFocusInWindow();

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
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

        btnOk = new JButton();
        btnCancel = new JButton();
        lblName = new JLabel();
        txtfName = new JTextField();
        lblCategory = new JLabel();
        cmbCategory = new JComboBox();

        setName("Form");
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                closeDialog(evt);
            }
        });

        btnOk.setText(RESOURCE_BUNDLE.getString("CategoryDialog.btnOk.text"));
        btnOk.setToolTipText(RESOURCE_BUNDLE.getString("CategoryDialog.btnOk.text"));
        btnOk.setEnabled(false);
        btnOk.setName("btnOk");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancel.setText(RESOURCE_BUNDLE.getString("CategoryDialog.btnCancel.text"));
        btnCancel.setToolTipText(RESOURCE_BUNDLE.getString("CategoryDialog.btnCancel.text"));
        btnCancel.setName("btnCancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblName.setText(RESOURCE_BUNDLE.getString("CategoryPanel.lblName.text"));
        lblName.setName("lblName");

        txtfName.setText("");
        txtfName.setToolTipText(RESOURCE_BUNDLE.getString("CategoryDialog.txtfName.tooltip"));
        txtfName.setName("txtfName");
        txtfName.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent evt) {
                txtfNameCaretUpdate(evt);
            }
        });

        lblCategory.setText(RESOURCE_BUNDLE.getString("CategoryDialog.lblCategory.text"));
        lblCategory.setName("jLabel1");

        cmbCategory.setModel(new DefaultComboBoxModel(MyTree.getAllSortedCategories()));
        cmbCategory.setToolTipText(RESOURCE_BUNDLE.getString("CategoryDialog.cmbCategory.tooltip"));
        cmbCategory.setName("jComboBox1");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 221, Short.MAX_VALUE)
                        .addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblCategory)
                            .addComponent(lblName))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txtfName, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(cmbCategory, 0, 290, Short.MAX_VALUE))))
                .addContainerGap())
        );

        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnCancel, btnOk});

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategory)
                    .addComponent(cmbCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnOk))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getRootPane().setDefaultButton(btnOk);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        doClose(RET_OK);
    }//GEN-LAST:event_btnOkActionPerformed
    
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_btnCancelActionPerformed

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void txtfNameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtfNameCaretUpdate
        if(!txtfName.getText().isEmpty() && !txtfName.getText().trim().equals("")) btnOk.setEnabled(true);
        else btnOk.setEnabled(false);
    }//GEN-LAST:event_txtfNameCaretUpdate
   
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        
        if(returnStatus==RET_OK) {
            TreeNodes.Node selectedCategory = (TreeNodes.Node)cmbCategory.getSelectedItem();
            
            if(node!=null) {
                if(node.getTitle().compareTo(txtfName.getText())!=0) {
                    changeTitle = true;
                    node.setTitle(txtfName.getText());
                }
                
                if(node.getIdParent()!=selectedCategory.getIdNode()) {
                    changeCategory = true;
                    node.setIdParent(selectedCategory.getIdNode());
                }
            } else {
                node = new TreeNodes.Node(txtfName.getText());
                node.setIdParent(selectedCategory.getIdNode());
            }
        }
        
        setVisible(false);
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JComboBox cmbCategory;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextField txtfName;
    // End of variables declaration//GEN-END:variables
    
    private int returnStatus = RET_CANCEL;

    /**
     * @return the node
     */
    public TreeNodes.Node getNode() {
        return node;
    }

    /**
     * @param node the node to set
     */
    public void setNode(TreeNodes.Node node) {
        this.node = node;
    }
}
