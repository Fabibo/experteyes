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
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FindCornerProgressJDialog.java
 *
 * Created on Jan 3, 2009, 7:38:26 AM
 */
package eyetrackercalibrator.gui;

import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author SQ
 */
public class FindCornerProgressJDialog extends javax.swing.JDialog {

    /** Creates new form FindCornerProgressJDialog */
    public FindCornerProgressJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setLocationByPlatform(true);
        initComponents();
    }

    public void setMaximum(int maximum) {
        this.progressBar.setMaximum(maximum);
    }

    public void setProgress(int progress) {
        this.progressBar.setValue(progress);
    }

    public void setImage(BufferedImage img) {
        if (img == null) {
            this.markableJLabel.setIcon(null);
        } else {
            this.markableJLabel.setIcon(new ImageIcon(img));
        }
        repaint();
    }

    public void setCorners(Point topleft, Point topright, Point bottomleft,
            Point bottomright) {
        this.markableJLabel.setCorners(
                topleft, topright, bottomleft, bottomright,
                MarkableJLabel.CornerColor.GREEN);
        repaint();
    }

    public void setHints(Point topleft, Point topright, Point bottomleft,
            Point bottomright) {
        this.markableJLabel.setCorners(
                topleft, topright, bottomleft, bottomright,
                MarkableJLabel.CornerColor.RED);
        repaint();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        markableJLabel = new eyetrackercalibrator.gui.MarkableJLabel();
        stopButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));

        markableJLabel.setBackground(new java.awt.Color(0, 0, 0));
        markableJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        markableJLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        markableJLabel.setOpaque(true);
        jScrollPane1.setViewportView(markableJLabel);

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(progressBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(stopButton))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(progressBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, stopButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_stopButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                FindCornerProgressJDialog dialog = new FindCornerProgressJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private eyetrackercalibrator.gui.MarkableJLabel markableJLabel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}
