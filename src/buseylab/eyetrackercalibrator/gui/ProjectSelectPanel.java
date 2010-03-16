/*
 * Copyright (c) 2009 by Thomas Busey and Ruj Akavipat
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Experteyes nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Thomas Busey and Ruj Akavipat ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Thomas Busey and Ruj Akavipat BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
/*
 * ProjectSelectPanel.java
 *
 * Created on September 19, 2007, 9:36 PM
 */
package buseylab.eyetrackercalibrator.gui;

import buseylab.eyetrackercalibrator.framemanaging.FrameLoadingListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author  SQ
 */
public class ProjectSelectPanel extends javax.swing.JPanel implements CleanDataJPanel.DefaultValueAppliedListener{

    // Storing the last directory selected by browse action
    File lastSelectedLocation = new File(".");
    private double distanceFromMeasuredScene;
    private double sceneHeightCM;
    private double sceneWidthCM;
    private String cornerHintsDirectory;

    /** Creates new form ProjectSelectPanel */
    public ProjectSelectPanel() {
        initComponents();
    }

    void checkIntegerInput(String input) {
        try {
            if (input.length() > 0) {
                Integer.parseInt(input);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "<html>Require integers for width and height</html>");
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textFieldEmptyPositiveIntInputVerifier1 = new buseylab.eyetrackercalibrator.gui.util.TextFieldEmptyPositiveIntInputVerifier();
        jLabel2 = new javax.swing.JLabel();
        eyeDirectoryTextField = new javax.swing.JTextField();
        browseEyeViewButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        screenDirectoryTextField = new javax.swing.JTextField();
        browseScreenViewButton = new javax.swing.JButton();
        loadEyeImageButton = new javax.swing.JButton();
        reloadEyeInfoButton = new javax.swing.JButton();
        synchronizeButton = new javax.swing.JButton();
        calibrateButton = new javax.swing.JButton();
        eyeFrameLoadedProgressBar = new javax.swing.JProgressBar();
        screenFrameLoadedProgressBar = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        browseScreenInfoButton = new javax.swing.JButton();
        screenInfoDirectoryTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        eyeInfoDirectoryTextField = new javax.swing.JTextField();
        browseEyeInfoButton = new javax.swing.JButton();
        cleanDataButton = new javax.swing.JButton();
        markTrialButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        fullScreenDirectoryTextField = new javax.swing.JTextField();
        browseScreenFullViewButton = new javax.swing.JButton();
        advanceConfigPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        fullScreenWidthPixelTextField = new javax.swing.JTextField();
        monitorWidthPixelTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        fullScreenHeightPixelTextField = new javax.swing.JTextField();
        monitorHeightPixelTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        advanceSetupButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        loadScreenImageButton = new javax.swing.JButton();
        reloadScreenInfoButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        computeScreenIlluminationButton = new javax.swing.JButton();
        exportMoviesButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentTextPane = new javax.swing.JTextPane();

        jLabel2.setText("Eye view location");

        browseEyeViewButton.setText("Browse");
        browseEyeViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseEyeViewButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Scene view location");

        browseScreenViewButton.setText("Browse");
        browseScreenViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseScreenViewButtonActionPerformed(evt);
            }
        });

        loadEyeImageButton.setText("Load Images");
        loadEyeImageButton.setActionCommand("Load Eye Images");

        reloadEyeInfoButton.setText("Reload Information");
        reloadEyeInfoButton.setActionCommand("Reload Eye Information");

        synchronizeButton.setText("Synchronize");

        calibrateButton.setText("Calibrate");

        eyeFrameLoadedProgressBar.setString("N/A");
        eyeFrameLoadedProgressBar.setStringPainted(true);

        screenFrameLoadedProgressBar.setString("N/A");
        screenFrameLoadedProgressBar.setStringPainted(true);

        jLabel7.setText("Eye Frame Loaded:");

        jLabel8.setText("Scene Frame Loaded:");

        browseScreenInfoButton.setText("Browse");
        browseScreenInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseScreenInfoButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Scene info location");

        jLabel6.setText("Eye info location");

        browseEyeInfoButton.setText("Browse");
        browseEyeInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseEyeInfoButtonActionPerformed(evt);
            }
        });

        cleanDataButton.setText("Clean Data");

        markTrialButton.setText("Mark Trials");

        jLabel15.setText("Scene full size location");

        browseScreenFullViewButton.setText("Browse");
        browseScreenFullViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseScreenFullViewButtonActionPerformed(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Scene full size:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Monitor size:");

        jLabel11.setText("Width");

        jLabel13.setText("Width");

        fullScreenWidthPixelTextField.setInputVerifier(textFieldEmptyPositiveIntInputVerifier1);

        monitorWidthPixelTextField.setInputVerifier(textFieldEmptyPositiveIntInputVerifier1);
        monitorWidthPixelTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                monitorWidthPixelTextFieldKeyTyped(evt);
            }
        });

        jLabel10.setText("x Height");

        jLabel14.setText("x Height");

        fullScreenHeightPixelTextField.setInputVerifier(textFieldEmptyPositiveIntInputVerifier1);

        monitorHeightPixelTextField.setInputVerifier(textFieldEmptyPositiveIntInputVerifier1);

        jLabel18.setText("pixels");

        jLabel24.setText("pixels");

        advanceSetupButton.setText("Advance Setup");
        advanceSetupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advanceSetupButtonActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        org.jdesktop.layout.GroupLayout advanceConfigPanelLayout = new org.jdesktop.layout.GroupLayout(advanceConfigPanel);
        advanceConfigPanel.setLayout(advanceConfigPanelLayout);
        advanceConfigPanelLayout.setHorizontalGroup(
            advanceConfigPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(advanceConfigPanelLayout.createSequentialGroup()
                .add(advanceConfigPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(advanceConfigPanelLayout.createSequentialGroup()
                        .add(271, 271, 271)
                        .add(jLabel16))
                    .add(advanceConfigPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel9)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel11)
                        .add(2, 2, 2)
                        .add(monitorWidthPixelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel10)
                        .add(2, 2, 2)
                        .add(monitorHeightPixelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel18)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel12)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel13)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fullScreenWidthPixelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel14)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fullScreenHeightPixelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel24)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(advanceSetupButton)
                .addContainerGap())
        );
        advanceConfigPanelLayout.setVerticalGroup(
            advanceConfigPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(advanceConfigPanelLayout.createSequentialGroup()
                .add(jLabel16)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(advanceConfigPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel11)
                    .add(jLabel10)
                    .add(monitorWidthPixelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel9)
                    .add(jLabel18)
                    .add(monitorHeightPixelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel12)
                    .add(jLabel13)
                    .add(fullScreenWidthPixelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel14)
                    .add(fullScreenHeightPixelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel24)
                    .add(advanceSetupButton)))
            .add(advanceConfigPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        loadScreenImageButton.setText("Load Images");
        loadScreenImageButton.setActionCommand("Load Screen Images");

        reloadScreenInfoButton.setText("Reload Information");
        reloadScreenInfoButton.setActionCommand("Reload Screen Information");

        exportButton.setText("Export Data");

        computeScreenIlluminationButton.setText("Compute Screen Illumination");

        exportMoviesButton.setText("Export Movies");

        commentTextPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Comment"));
        jScrollPane1.setViewportView(commentTextPane);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel6)
                            .add(jLabel2)
                            .add(jLabel3)
                            .add(jLabel5)
                            .add(jLabel15))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(eyeInfoDirectoryTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(browseEyeInfoButton))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, fullScreenDirectoryTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, screenDirectoryTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, eyeDirectoryTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(browseEyeViewButton)
                                        .add(browseScreenViewButton))
                                    .add(browseScreenFullViewButton)))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(screenInfoDirectoryTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(browseScreenInfoButton))))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel8)
                            .add(jLabel7))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(screenFrameLoadedProgressBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                            .add(eyeFrameLoadedProgressBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(loadEyeImageButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(reloadEyeInfoButton))
                            .add(layout.createSequentialGroup()
                                .add(loadScreenImageButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(reloadScreenInfoButton))))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(computeScreenIlluminationButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(synchronizeButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(calibrateButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cleanDataButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(markTrialButton)
                        .add(6, 6, 6)
                        .add(exportButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(exportMoviesButton))
                    .add(advanceConfigPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(browseEyeViewButton)
                    .add(eyeDirectoryTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(browseScreenViewButton)
                    .add(screenDirectoryTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(fullScreenDirectoryTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(browseScreenFullViewButton)
                    .add(jLabel15))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(browseEyeInfoButton)
                    .add(jLabel6)
                    .add(eyeInfoDirectoryTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(browseScreenInfoButton)
                    .add(screenInfoDirectoryTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5))
                .add(12, 12, 12)
                .add(advanceConfigPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(loadEyeImageButton)
                    .add(reloadEyeInfoButton)
                    .add(jLabel7)
                    .add(eyeFrameLoadedProgressBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(26, 26, 26)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(loadScreenImageButton)
                    .add(reloadScreenInfoButton)
                    .add(jLabel8)
                    .add(screenFrameLoadedProgressBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(computeScreenIlluminationButton)
                    .add(synchronizeButton)
                    .add(calibrateButton)
                    .add(cleanDataButton)
                    .add(markTrialButton)
                    .add(exportButton)
                    .add(exportMoviesButton))
                .addContainerGap())
        );

        loadEyeImageButton.getAccessibleContext().setAccessibleName("Load Eye Images");
        reloadEyeInfoButton.getAccessibleContext().setAccessibleName("Reload Eye Information");
        loadScreenImageButton.getAccessibleContext().setAccessibleName("Load Screen Images");
        reloadScreenInfoButton.getAccessibleContext().setAccessibleName("Reload Screen Information");
    }// </editor-fold>//GEN-END:initComponents
    private void monitorWidthPixelTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_monitorWidthPixelTextFieldKeyTyped
        checkIntegerInput((monitorWidthPixelTextField.getText() + evt.getKeyChar()).trim());
}//GEN-LAST:event_monitorWidthPixelTextFieldKeyTyped

    private void browseEyeInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseEyeInfoButtonActionPerformed
        browseDirectory(eyeInfoDirectoryTextField);
    }//GEN-LAST:event_browseEyeInfoButtonActionPerformed

    private void browseScreenInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseScreenInfoButtonActionPerformed
        browseDirectory(screenInfoDirectoryTextField);
    }//GEN-LAST:event_browseScreenInfoButtonActionPerformed

    private void browseScreenViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseScreenViewButtonActionPerformed
        browseDirectory(screenDirectoryTextField);
    }//GEN-LAST:event_browseScreenViewButtonActionPerformed

    private void browseEyeViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseEyeViewButtonActionPerformed
        browseDirectory(eyeDirectoryTextField);
    }//GEN-LAST:event_browseEyeViewButtonActionPerformed

    private void browseScreenFullViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseScreenFullViewButtonActionPerformed
        browseDirectory(fullScreenDirectoryTextField);
}//GEN-LAST:event_browseScreenFullViewButtonActionPerformed

    private void advanceSetupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advanceSetupButtonActionPerformed

        final ProjectSelectAdvanceSetUpDialog dialog =
                new ProjectSelectAdvanceSetUpDialog(null, "Advance Configuration", true);

        dialog.setDistanceFromMonitor(this.distanceFromMeasuredScene);
        dialog.setSceneHeight(this.sceneHeightCM);
        dialog.setSceneWidth(this.sceneWidthCM);
        dialog.setLocationByPlatform(true);
        dialog.setCornerHintsDirectory(this.cornerHintsDirectory);

        dialog.addWindowListener(new java.awt.event.WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent e) {
                distanceFromMeasuredScene = dialog.getDistanceFromMonitor();
                sceneHeightCM = dialog.getSceneHeight();
                sceneWidthCM = dialog.getSceneWidth();
                cornerHintsDirectory = dialog.getCornerHintsDirectory();
            }
        });

        dialog.setVisible(true);

}//GEN-LAST:event_advanceSetupButtonActionPerformed

    private void browseDirectory(JTextField targetField) {
        // Set text box with directory that user chose.
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (targetField.getText().length() > 1) {
            // Get current selection from text field
            fileChooser.setSelectedFile(new File(targetField.getText()));
        } else {
            // Otherwise open to latest location if there is nothing in the field text
            fileChooser.setSelectedFile(lastSelectedLocation);
        }

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            // Save current position
            lastSelectedLocation = fileChooser.getSelectedFile();
            targetField.setText(lastSelectedLocation.getAbsolutePath());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel advanceConfigPanel;
    private javax.swing.JButton advanceSetupButton;
    private javax.swing.JButton browseEyeInfoButton;
    private javax.swing.JButton browseEyeViewButton;
    private javax.swing.JButton browseScreenFullViewButton;
    private javax.swing.JButton browseScreenInfoButton;
    private javax.swing.JButton browseScreenViewButton;
    private javax.swing.JButton calibrateButton;
    private javax.swing.JButton cleanDataButton;
    private javax.swing.JTextPane commentTextPane;
    private javax.swing.JButton computeScreenIlluminationButton;
    private javax.swing.JButton exportButton;
    private javax.swing.JButton exportMoviesButton;
    private javax.swing.JTextField eyeDirectoryTextField;
    private javax.swing.JProgressBar eyeFrameLoadedProgressBar;
    private javax.swing.JTextField eyeInfoDirectoryTextField;
    private javax.swing.JTextField fullScreenDirectoryTextField;
    private javax.swing.JTextField fullScreenHeightPixelTextField;
    private javax.swing.JTextField fullScreenWidthPixelTextField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton loadEyeImageButton;
    private javax.swing.JButton loadScreenImageButton;
    private javax.swing.JButton markTrialButton;
    private javax.swing.JTextField monitorHeightPixelTextField;
    private javax.swing.JTextField monitorWidthPixelTextField;
    private javax.swing.JButton reloadEyeInfoButton;
    private javax.swing.JButton reloadScreenInfoButton;
    private javax.swing.JTextField screenDirectoryTextField;
    private javax.swing.JProgressBar screenFrameLoadedProgressBar;
    private javax.swing.JTextField screenInfoDirectoryTextField;
    private javax.swing.JButton synchronizeButton;
    private buseylab.eyetrackercalibrator.gui.util.TextFieldEmptyPositiveIntInputVerifier textFieldEmptyPositiveIntInputVerifier1;
    // End of variables declaration//GEN-END:variables

    /**
     * Add listener to listen to "Load Image", "Reload Information",
     * "Synchronize", "Calibrate", "Clean data" and "Mark trials" commands
     */
    public void addActionListener(ActionListener listener) {
        loadEyeImageButton.addActionListener(listener);
        reloadEyeInfoButton.addActionListener(listener);
        loadScreenImageButton.addActionListener(listener);
        reloadScreenInfoButton.addActionListener(listener);
        synchronizeButton.addActionListener(listener);
        calibrateButton.addActionListener(listener);
        cleanDataButton.addActionListener(listener);
        markTrialButton.addActionListener(listener);
        exportButton.addActionListener(listener);
        computeScreenIlluminationButton.addActionListener(listener);
        exportMoviesButton.addActionListener(listener);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        Component[] components = getComponents();
        for (int i = 0; i < components.length; i++) {
            components[i].setEnabled(enabled);
        }
        components = this.advanceConfigPanel.getComponents();
        for (int i = 0; i < components.length; i++) {
            components[i].setEnabled(enabled);
        }
    }

    public FrameLoadingListener getEyeFrameLoadingListener() {
        return new FrameLoadingListener() {

            public void update(String updateText, int totalLoad, int totalFrame) {
                eyeFrameLoadedProgressBar.setString(updateText);
                eyeFrameLoadedProgressBar.setMaximum(totalFrame);
                eyeFrameLoadedProgressBar.setValue(totalLoad);
            }
        };
    }

    public String getEyeFrameDirectory() {
        return eyeDirectoryTextField.getText();
    }

    public String getScreenFrameDirectory() {
        return screenDirectoryTextField.getText();
    }

    public String getFullScreenFrameDirectory() {
        return fullScreenDirectoryTextField.getText();
    }

    public String getScreenInfoDirectory() {
        return screenInfoDirectoryTextField.getText();
    }

    public String getEyeInfoDirectory() {
        return eyeInfoDirectoryTextField.getText();
    }

    public String getCornerHintsDirectory() {
        return cornerHintsDirectory;
    }

    public void setEyeFrameDirectory(String dir) {
        eyeDirectoryTextField.setText(dir);
    }

    public void setScreenFrameDirectory(String dir) {
        screenDirectoryTextField.setText(dir);
    }

    public void setFullScreenFrameDirectory(String dir) {
        fullScreenDirectoryTextField.setText(dir);
    }

    public void setScreenInfoDirectory(String dir) {
        screenInfoDirectoryTextField.setText(dir);
    }

    public void setEyeInfoDirectory(String dir) {
        eyeInfoDirectoryTextField.setText(dir);
    }

    public void setCornerHintsDirectory(String cornerHintsDirectory) {
        this.cornerHintsDirectory = cornerHintsDirectory;
    }

    public FrameLoadingListener getScreenFrameLoadingListener() {
        return new FrameLoadingListener() {

            public void update(String updateText, int totalLoad, int totalFrame) {
                screenFrameLoadedProgressBar.setString(updateText);
                screenFrameLoadedProgressBar.setMaximum(totalFrame);
                screenFrameLoadedProgressBar.setValue(totalLoad);
            }
        };
    }

    /** Get monitor dimension in pixels */
    public Dimension getMonitorDimensionPX() {
        if (monitorWidthPixelTextField.getText().length() > 0 && monitorHeightPixelTextField.getText().length() > 0) {
            return new Dimension(
                    Integer.parseInt(monitorWidthPixelTextField.getText()),
                    Integer.parseInt(monitorHeightPixelTextField.getText()));
        } else {
            return null;
        }
    }

    /** Set monitor dimension in pixels */
    public void setMonitorDimensionPX(String width, String height) {
        monitorWidthPixelTextField.setText(width);
        monitorHeightPixelTextField.setText(height);
    }

    public void setFullSceneDimensionPX(String width, String height) {
        fullScreenHeightPixelTextField.setText(height);
        fullScreenWidthPixelTextField.setText(width);
    }

    public Dimension getFullSceneDimensionPX() {
        if (fullScreenHeightPixelTextField.getText().length() > 0 && fullScreenWidthPixelTextField.getText().length() > 0) {
            return new Dimension(
                    Integer.parseInt(fullScreenWidthPixelTextField.getText()),
                    Integer.parseInt(fullScreenHeightPixelTextField.getText()));
        } else {
            return null;
        }
    }

    public void setEyeLoadButtonsEnable(boolean b) {
        loadEyeImageButton.setEnabled(b);
        reloadEyeInfoButton.setEnabled(b);
    }

    public void setScreenLoadButtonsEnable(boolean b) {
        loadScreenImageButton.setEnabled(b);
        reloadScreenInfoButton.setEnabled(b);
        computeScreenIlluminationButton.setEnabled(b);
    }

    public void setComment(String comment) {
        this.commentTextPane.setText(comment);
    }

    public String getComment() {
        return this.commentTextPane.getText();
    }

    /**
     * @return the distanceFromMonitor
     */
    public double getDistanceFromMeasuredScene() {
        return distanceFromMeasuredScene;
    }

    /**
     * @param distanceFromMonitor the distanceFromMonitor to set
     */
    public void setDistanceFromMeasuredScene(String distanceFromMonitor) {
        try {
            this.distanceFromMeasuredScene = Double.parseDouble(distanceFromMonitor);
        } catch (NumberFormatException numberFormatException) {
            this.distanceFromMeasuredScene = 0;
        }
    }

    /**
     * @return the monitorHeightCM
     */
    public double getSceneHeightCM() {
        return sceneHeightCM;
    }

    /**
     * @param monitorHeightCM the monitorHeightCM to set
     */
    public void setSceneHeightCM(String monitorHeightCM) {
        try {
            this.sceneHeightCM = Double.parseDouble(monitorHeightCM);
        } catch (NumberFormatException numberFormatException) {
            this.sceneHeightCM = 0;
        }
    }

    /**
     * @return the monitorWidthCM
     */
    public double getSceneWidthCM() {
        return sceneWidthCM;
    }

    /**
     * @param monitorWidthCM the monitorWidthCM to set
     */
    public void setSceneWidthCM(String monitorWidthCM) {
        try {
            this.sceneWidthCM = Double.parseDouble(monitorWidthCM);
        } catch (NumberFormatException numberFormatException) {
            this.sceneHeightCM = 0;
        }
    }

    public void useDefaultCornerHintDir(String dir) {
        setCornerHintsDirectory(dir);
    }

    public void useDefaultScreenInfoDir(String dir) {
        setScreenInfoDirectory(dir);
    }

    public void useDefaultFullScreenFrameDir(String dir) {
        setFullScreenFrameDirectory(dir);
    }
}
