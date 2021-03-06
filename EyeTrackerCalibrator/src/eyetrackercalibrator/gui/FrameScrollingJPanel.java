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
 * A frame play control.  !!!IMPORTANT!!! The class assume that the first frame is 1.
 * Created on September 10, 2007, 9:27 AM
 */

package eyetrackercalibrator.gui;

/**
 *
 * @author  eeglab
 */
public class FrameScrollingJPanel extends javax.swing.JPanel
        implements FrameControlInterface{
    
    /** Creates new form FrameScrollingJPanel */
    public FrameScrollingJPanel() {
        initComponents();
    }
    
    /**
     * Frame change property name.  The Integer class is the value used
     */
    public static final String CURRENT_FRAME_CHANGE = "currentFrame";
    /**
     * Speed change property name. The Integer class is the value used
     */
    public static final String SPEED_CHANGE = "speed";
    
    
    private int totalFrame = 1;
    private int maximumSpeed = 60;
    /**
     * Holds value of property speed.
     */
    private int speed = 0;
    /**
     * Holds value of property currentFrame.
     */
    private int currentFrame = 1;
    
    // For setting frame number in all interface to display correctly
    
    /**
     * Setting maximum speed (both forward and rewind)
     */
    public int getMaximumSpeed() {
        return maximumSpeed;
    }
    
    public void setMaximumSpeed(int maximumSpeed) {
        if(maximumSpeed < 1){
            System.err.print("Maximum speed cannot be less than 1: revert to default value.");
        }else{
            this.maximumSpeed = maximumSpeed;
        }
    }
    
    public int getTotalFrame() {
        return totalFrame;
    }
    
    public void setTotalFrame(int totalFrame) {
        this.totalFrame = totalFrame;
        frameViewSlider.setMaximum(totalFrame);
        // Cap current frame to total frame if the current is larger
        if(this.getCurrentFrame() > totalFrame){
            setCurrentFrame(totalFrame);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frameSpeedSlider = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        frameNumberTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        frameSpeedTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        frameViewSlider = new javax.swing.JSlider();

        frameSpeedSlider.setPaintLabels(true);
        frameSpeedSlider.setPaintTicks(true);
        frameSpeedSlider.setValue(0);
        frameSpeedSlider.setMaximum(maximumSpeed);
        frameSpeedSlider.setMinimum(-maximumSpeed);
        frameSpeedSlider.setMajorTickSpacing(10);
        frameSpeedSlider.setMinorTickSpacing(1);
        frameSpeedSlider.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                frameSpeedSliderMouseWheelMoved(evt);
            }
        });
        frameSpeedSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                frameSpeedSliderMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                frameSpeedSliderMouseReleased(evt);
            }
        });
        frameSpeedSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                frameSpeedSliderStateChanged(evt);
            }
        });
        frameSpeedSlider.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                frameSpeedSliderFocusLost(evt);
            }
        });

        jLabel1.setText("Frame");
        jLabel1.setFocusable(false);

        frameNumberTextField.setText("1");
        frameNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frameNumberTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Speed");
        jLabel2.setFocusable(false);

        frameSpeedTextField.setEditable(false);
        frameSpeedTextField.setText("0");
        frameSpeedTextField.setFocusable(false);

        jLabel3.setText("Frames/sec");
        jLabel3.setFocusable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        frameViewSlider.setMinimum(1);
        frameViewSlider.setMaximum(totalFrame);
        frameViewSlider.setValue(1);
        frameViewSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                frameViewSliderStateChanged(evt);
            }
        });
        frameViewSlider.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                frameViewSliderMouseWheelMoved(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(frameViewSlider, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(frameViewSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(frameNumberTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(frameSpeedTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(frameSpeedSlider, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(jLabel1)
                    .add(frameNumberTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(jLabel2)
                    .add(frameSpeedTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3)
                    .add(frameSpeedSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void frameSpeedSliderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameSpeedSliderMouseExited
        // Stop the play.  (Set speed to 0)
        frameSpeedTextField.setText("0");
        frameSpeedSlider.setValue(0);
        setFrameRate(0); // This call will take long.. so don't  call it earlier
    }//GEN-LAST:event_frameSpeedSliderMouseExited
    
    private void frameNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frameNumberTextFieldActionPerformed
        frameViewSlider.setValue(Integer.parseInt(frameNumberTextField.getText()));
    }//GEN-LAST:event_frameNumberTextFieldActionPerformed
    
    private void frameSpeedSliderFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_frameSpeedSliderFocusLost
        // Stop the play.  (Set speed to 0)
        frameSpeedTextField.setText("0");
        frameSpeedSlider.setValue(0);
        setFrameRate(0); // This call will take long.. so don't  call it earlier
    }//GEN-LAST:event_frameSpeedSliderFocusLost
    
    private void frameSpeedSliderMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_frameSpeedSliderMouseWheelMoved
        frameSpeedSlider.setValue(frameSpeedSlider.getValue()-evt.getWheelRotation());
    }//GEN-LAST:event_frameSpeedSliderMouseWheelMoved
    
    private void frameViewSliderMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_frameViewSliderMouseWheelMoved
        frameViewSlider.setValue(frameViewSlider.getValue()-evt.getWheelRotation());
    }//GEN-LAST:event_frameViewSliderMouseWheelMoved
    
    private void frameViewSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_frameViewSliderStateChanged
        int frame = frameViewSlider.getValue();
        frameNumberTextField.setText(String.valueOf(frame));
        setCurrentFrame(frame);
    }//GEN-LAST:event_frameViewSliderStateChanged
    
    private void frameSpeedSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameSpeedSliderMouseReleased
        // Stop the play.  (Set speed to 0)
        frameSpeedTextField.setText("0");
        frameSpeedSlider.setValue(0);
        setFrameRate(0); // This call will take long.. so don't  call it earlier
    }//GEN-LAST:event_frameSpeedSliderMouseReleased
    
    private void frameSpeedSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_frameSpeedSliderStateChanged
        // Change speed
        int newSpeed = frameSpeedSlider.getValue();
        frameSpeedTextField.setText(String.valueOf(newSpeed));
        setFrameRate(newSpeed); // This call will take long.. so don't  call it earlier
    }//GEN-LAST:event_frameSpeedSliderStateChanged
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField frameNumberTextField;
    private javax.swing.JSlider frameSpeedSlider;
    private javax.swing.JTextField frameSpeedTextField;
    private javax.swing.JSlider frameViewSlider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Getter for property currentFrame.
     * @return Value of property currentFrame.
     */
    public int getCurrentFrame() {
        return this.currentFrame;
    }
    
    /**
     * Setter for property currentFrame.
     * @param currentFrame New value of property currentFrame.
     */
    public void setCurrentFrame(int currentFrame) {
        // Only response when there is a change
        if(this.currentFrame != currentFrame){
            // Cap the frame
            if(currentFrame > totalFrame){
                currentFrame = totalFrame;
            }
            if(currentFrame < 1){
                currentFrame = 1;
            }
            frameNumberTextField.setText(String.valueOf(currentFrame));
            frameViewSlider.setValue(currentFrame);
            int oldCurrentFrame = this.currentFrame;
            this.currentFrame = currentFrame;
            firePropertyChange(CURRENT_FRAME_CHANGE,
                    new Integer(oldCurrentFrame),
                    new Integer(currentFrame));
        }
    }
    
    /**
     * Getter for property speed.
     * @return Value of property speed.
     */
    public int getFrameRate() {
        return this.speed;
    }
    
    /**
     * Setter for property speed.
     * @param speed New value of property speed.
     */
    private void setFrameRate(int speed) {
        // Only response when there is a change
        if(this.speed != speed){
            int oldSpeed = this.speed;
            this.speed = speed;
            firePropertyChange(
                    SPEED_CHANGE, new Integer(oldSpeed), new Integer(speed));
        }
    }
}
