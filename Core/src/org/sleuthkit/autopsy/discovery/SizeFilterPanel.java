/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sleuthkit.autopsy.discovery;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import org.sleuthkit.autopsy.discovery.FileSearchData.FileSize;

/**
 *
 * @author wschaefer
 */
final class SizeFilterPanel extends AbstractDiscoveryFilterPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Creates new form SizeFilterPanel
     */
    SizeFilterPanel(FileSearchData.FileType type) {
        initComponents();
        setUpSizeFilter(type);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sizeCheckbox = new javax.swing.JCheckBox();
        sizeScrollPane = new javax.swing.JScrollPane();
        sizeList = new javax.swing.JList<>();

        org.openide.awt.Mnemonics.setLocalizedText(sizeCheckbox, org.openide.util.NbBundle.getMessage(SizeFilterPanel.class, "SizeFilterPanel.sizeCheckbox.text")); // NOI18N
        sizeCheckbox.setMaximumSize(new java.awt.Dimension(150, 25));
        sizeCheckbox.setMinimumSize(new java.awt.Dimension(150, 25));
        sizeCheckbox.setPreferredSize(new java.awt.Dimension(150, 25));
        sizeCheckbox.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        sizeCheckbox.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        sizeCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeCheckboxActionPerformed(evt);
            }
        });

        setMinimumSize(new java.awt.Dimension(250, 30));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(250, 30));

        sizeScrollPane.setPreferredSize(new java.awt.Dimension(27, 27));

        sizeList.setModel(new DefaultListModel<FileSize>());
        sizeList.setEnabled(false);
        sizeList.setMaximumSize(new java.awt.Dimension(32767, 32767));
        sizeList.setVisibleRowCount(5);
        sizeScrollPane.setViewportView(sizeList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sizeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sizeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sizeCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeCheckboxActionPerformed
        sizeList.setEnabled(sizeCheckbox.isSelected());
    }//GEN-LAST:event_sizeCheckboxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox sizeCheckbox;
    private javax.swing.JList<FileSize> sizeList;
    private javax.swing.JScrollPane sizeScrollPane;
    // End of variables declaration//GEN-END:variables

    @Override
    public void configurePanel(boolean selected, int[] indicesSelected) {
        sizeCheckbox.setSelected(selected);
        if (sizeCheckbox.isEnabled() && sizeCheckbox.isSelected()) {
            sizeScrollPane.setEnabled(true);
            sizeList.setEnabled(true);
            if (indicesSelected != null) {
                sizeList.setSelectedIndices(indicesSelected);
            }
        } else {
            sizeScrollPane.setEnabled(false);
            sizeList.setEnabled(false);
        }
    }

    @Override
    public JCheckBox getCheckbox() {
        return sizeCheckbox;
    }

    @Override
    public JLabel getAdditionalLabel() {
        return null;
    }

    /**
     * Initialize the file size filter
     */
    private void setUpSizeFilter(FileSearchData.FileType fileType) {
        int count = 0;
        DefaultListModel<FileSize> sizeListModel = (DefaultListModel<FileSize>) sizeList.getModel();
        sizeListModel.removeAllElements();
        if (null == fileType) {
            for (FileSize size : FileSize.values()) {
                sizeListModel.add(count, size);
            }
        } else {
            List<FileSearchData.FileSize> sizes;
            switch (fileType) {
                case VIDEO:
                    sizes = FileSize.getOptionsForVideos();
                    break;
                case IMAGE:
                    sizes = FileSize.getOptionsForImages();
                    break;
                case DOCUMENTS:
                    sizes = FileSize.getOptionsForImages();
                    break;
                default:
                    sizes = new ArrayList<>();
                    break;
            }
            for (FileSize size : sizes) {
                sizeListModel.add(count, size);
            }
        }
    }

    @Override
    String checkForError() {
        if (sizeCheckbox.isSelected() && sizeList.getSelectedValuesList().isEmpty()) {
            return "At least one size must be selected";
        }
        return null;

    }

    @Override
    JList<?> getList() {
        return sizeList;
    }

    @Override
    FileSearchFiltering.FileFilter getFilter() {
        if (sizeCheckbox.isSelected()) {
            return new FileSearchFiltering.SizeFilter(sizeList.getSelectedValuesList());
        }
        return null;
    }
}
