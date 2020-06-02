/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sleuthkit.autopsy.discovery;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author wschaefer
 */
public class UserCreatedFilterPanel extends AbstractDiscoveryFilterPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Creates new form UserCreatedFilterPanel
     */
    public UserCreatedFilterPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userCreatedCheckbox = new javax.swing.JCheckBox();

        org.openide.awt.Mnemonics.setLocalizedText(userCreatedCheckbox, org.openide.util.NbBundle.getMessage(UserCreatedFilterPanel.class, "UserCreatedFilterPanel.userCreatedCheckbox.text_1")); // NOI18N
        userCreatedCheckbox.setMaximumSize(new java.awt.Dimension(150, 25));
        userCreatedCheckbox.setMinimumSize(new java.awt.Dimension(150, 25));
        userCreatedCheckbox.setPreferredSize(new java.awt.Dimension(150, 25));

        setMinimumSize(new java.awt.Dimension(250, 30));
        setPreferredSize(new java.awt.Dimension(250, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    void configurePanel(boolean selected, int[] indicesSelected) {
        userCreatedCheckbox.setSelected(selected);
    }

    @Override
    JCheckBox getCheckbox() {
        return userCreatedCheckbox;
    }

    @Override
    JLabel getAdditionalLabel() {
        return null;
    }

    @Override
    String checkForError() {
        //this filter currently has no errors it generates
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox userCreatedCheckbox;
    // End of variables declaration//GEN-END:variables

    @Override
    JList<?> getList() {
        return null;
    }

    @Override
    FileSearchFiltering.FileFilter getFilter() {
        if (userCreatedCheckbox.isSelected()) {
            return new FileSearchFiltering.UserCreatedFilter();
        }
        return null;
    }

    @Override
    boolean hasPanel() {
        return false;
    }
}
