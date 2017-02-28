
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

import cz.babi.java.jhungryhamster.Main;
import cz.babi.java.jhungryhamster.data.Icons;
import cz.babi.java.jhungryhamster.entity.Settings;
import cz.babi.java.jhungryhamster.utils.Common;

import java.beans.PropertyChangeSupport;
import java.util.ResourceBundle;

/**
 *
 * @author babi
 */
public class RecipeTitlePanel extends javax.swing.JPanel {
    
    private static Settings settings = Settings.getInstance();

    private boolean controlStateOn = settings.isHideRecipeDetails();
    protected final PropertyChangeSupport propertyChangeSupport;

    /**
     * Get the value of controlStateOn
     *
     * @return the value of controlStateOn
     */
    public boolean isControlStateOn() {
        return controlStateOn;
    }

    /**
     * Set the value of controlStateOn
     *
     * @param controlStateOn new value of controlStateOn
     */
    public void setControlStateOn(boolean controlStateOn) {
        this.controlStateOn = controlStateOn;
    }    

    /** Creates new form RecipeTitlePanel */
    public RecipeTitlePanel() {
        initComponents();
        propertyChangeSupport = new PropertyChangeSupport(this);
        lblControlMouseReleased(null);
    }
    
    /**
     * Get the PropertUchangeSupport of controlStateOn
     * 
     * @return the PropertUchangeSupport of controlStateOn
     */
    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblControl = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        _lblTitle = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(510, 20));
        setName("Form");
        setPreferredSize(new java.awt.Dimension(510, 20));

        lblControl.setIcon(Icons.ARROW_DOWN);
        ResourceBundle bundle = Common.RESOURCE_BUNDLE;
        lblControl.setToolTipText(bundle.getString("RecipeTitlePanel.lblControl.tooltip"));
        lblControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblControl.setName("lblControl");
        lblControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblControlMouseReleased(evt);
            }
        });

        lblTitle.setToolTipText(bundle.getString("RecipeTitlePanel.lblTitle.tooltip"));
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTitle.setName("lblTitle");
        lblTitle.setPreferredSize(new java.awt.Dimension(44, 20));

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(Main.class).getContext().getResourceMap(RecipeTitlePanel.class);
        _lblTitle.setForeground(resourceMap.getColor("RecipeDetailsPanel.foreground"));
        _lblTitle.setText(bundle.getString("RecipeTitlePanel._lblTitle.text"));
        _lblTitle.setMaximumSize(new java.awt.Dimension(85, 17));
        _lblTitle.setMinimumSize(new java.awt.Dimension(85, 17));
        _lblTitle.setName("_lblTitle");
        _lblTitle.setPreferredSize(new java.awt.Dimension(85, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblControl)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(_lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblControl))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblControlMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblControlMouseReleased
        boolean oldControlState = isControlStateOn();
        
        if(isControlStateOn()) {
            lblControl.setIcon(Icons.ARROW_DOWN);
            setControlStateOn(false);
            settings.setHideRecipeDetails(true);
        } else {
            lblControl.setIcon(Icons.ARROW_UP);
            setControlStateOn(true);
            settings.setHideRecipeDetails(false);
        }
        
        propertyChangeSupport.firePropertyChange("controlStateOn", oldControlState, isControlStateOn());
}//GEN-LAST:event_lblControlMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel _lblTitle;
    private javax.swing.JLabel lblControl;
    private static javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables

    /**
     * Metoda nastaví text názvu receptu.
     * @param title název receptu
     */
    public static void setTitleText(String title) {
        lblTitle.setText(title);
    }
}
