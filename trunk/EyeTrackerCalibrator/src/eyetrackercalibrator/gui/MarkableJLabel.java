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
 * MarkableJLabel.java
 *
 * Created on September 19, 2007, 2:20 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package eyetrackercalibrator.gui;

import eyetrackercalibrator.gui.util.RotatedEllipse2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.util.Arrays;
import javax.swing.JLabel;

/**
 *
 * @author SQ
 */
public class MarkableJLabel extends JLabel {

    static public final int DEFAULT_CORNER_MARK_LENGTH = 10;
    static public final int DEFAULT_POINT_MARK_LENGTH = 2;
    /**
     * Array of corner points.  Arranges in TopLeft, BottomLeft, BottomRight, TopRight
     */
    static final int TOPLEFT = 0;
    static final int BOTTOMLEFT = 1;
    static final int BOTTOMRIGHT = 2;
    static final int TOPRIGHT = 3;
    private int cornerMarkLength = 10;
    private int pointMarkLength = 2; // length extending from marked point in a cross
    private Point[] greenCorners = new Point[4];
    private Point[] redCorners = new Point[4];
    private Point[] yellowMarkedPoints = null;
    private Point[] blueMarkedPoints = null;
    private Point[] greenMarkedPoints = null;
    private Point[] redMarkedPoints = null;
    private Color color = Color.GREEN;
    private RotatedEllipse2D greenEllisp = null;
    private RotatedEllipse2D redEllisp = null;

    private void drawRoratedEllisp(RotatedEllipse2D ellisp,
            AffineTransform oldTransform, Graphics2D g2d) {
        if (ellisp != null) {
            if (ellisp.angle > 0) {
                AffineTransform aff = AffineTransform.getTranslateInstance(oldTransform.getTranslateX(), oldTransform.getTranslateY());
                aff.rotate(ellisp.angle, ellisp.getCenterX(), ellisp.getCenterY());
                g2d.setTransform(aff);
            }

            g2d.draw(ellisp);

            if (ellisp.angle > 0) {
                g2d.setTransform(oldTransform);
            }
        }
    }

    public enum MarkColor {

        GREEN, RED, BLUE, YELLOW
    }

    public enum CornerColor {

        GREEN, RED
    }

    /** Creates a new instance of MarkableJLabel */
    public MarkableJLabel() {
        cornerMarkLength = DEFAULT_CORNER_MARK_LENGTH;
        pointMarkLength = DEFAULT_POINT_MARK_LENGTH;

        // Clear all corners
        Arrays.fill(greenCorners, null);
        Arrays.fill(redCorners, null);
    }

    @Override
    public void paint(Graphics g) {
        // Do whatever label normally does.
        super.paint(g);

        drawCorners(g, Color.GREEN, greenCorners);
        drawCorners(g, Color.RED, redCorners);

        drawMarks(g, Color.GREEN, greenMarkedPoints);
        drawMarks(g, Color.RED, redMarkedPoints);
        drawMarks(g, Color.BLUE, blueMarkedPoints);
        drawMarks(g, Color.YELLOW, yellowMarkedPoints);

        Graphics2D g2d = (Graphics2D) g;
        AffineTransform oldTransform = g2d.getTransform();
        if (greenEllisp != null) {
            g2d.setColor(Color.GREEN);
            drawRoratedEllisp(greenEllisp, oldTransform, g2d);
        }

        if (redEllisp != null) {
            g2d.setColor(Color.RED);
            drawRoratedEllisp(redEllisp, oldTransform, g2d);
        }
    }

    private void drawCorners(Graphics g, Color color, Point[] points) {
        // Set color
        g.setColor(color);

        // Paint corners when possible
        if (points[TOPLEFT] != null) {
            g.drawLine(
                    points[TOPLEFT].x,
                    points[TOPLEFT].y,
                    points[TOPLEFT].x,
                    points[TOPLEFT].y + cornerMarkLength);
            g.drawLine(
                    points[TOPLEFT].x,
                    points[TOPLEFT].y,
                    points[TOPLEFT].x + cornerMarkLength,
                    points[TOPLEFT].y);
        }
        if (points[TOPRIGHT] != null) {
            g.drawLine(
                    points[TOPRIGHT].x,
                    points[TOPRIGHT].y,
                    points[TOPRIGHT].x,
                    points[TOPRIGHT].y + cornerMarkLength);
            g.drawLine(
                    points[TOPRIGHT].x,
                    points[TOPRIGHT].y,
                    points[TOPRIGHT].x - cornerMarkLength,
                    points[TOPRIGHT].y);
        }
        if (points[BOTTOMRIGHT] != null) {
            g.drawLine(
                    points[BOTTOMRIGHT].x,
                    points[BOTTOMRIGHT].y,
                    points[BOTTOMRIGHT].x,
                    points[BOTTOMRIGHT].y - cornerMarkLength);
            g.drawLine(
                    points[BOTTOMRIGHT].x,
                    points[BOTTOMRIGHT].y,
                    points[BOTTOMRIGHT].x - cornerMarkLength,
                    points[BOTTOMRIGHT].y);
        }
        if (points[BOTTOMLEFT] != null) {
            g.drawLine(
                    points[BOTTOMLEFT].x,
                    points[BOTTOMLEFT].y,
                    points[BOTTOMLEFT].x,
                    points[BOTTOMLEFT].y - cornerMarkLength);
            g.drawLine(
                    points[BOTTOMLEFT].x,
                    points[BOTTOMLEFT].y,
                    points[BOTTOMLEFT].x + cornerMarkLength,
                    points[BOTTOMLEFT].y);
        }
    }

    private void drawMarks(Graphics g, Color color, Point[] points) {
        g.setColor(color);
        if (points != null) {
            for (int i = 0; i < points.length; i++) {
                if (points[i] != null) {
                    g.drawLine(
                            points[i].x - pointMarkLength,
                            points[i].y,
                            points[i].x + pointMarkLength,
                            points[i].y);
                    g.drawLine(
                            points[i].x,
                            points[i].y - pointMarkLength,
                            points[i].x,
                            points[i].y + pointMarkLength);
                }
            }

        }
    }

    public Point[] getCorners(MarkColor color) {
        switch (color) {
            case RED:
                return redCorners;
            default: // Green by default
                return greenCorners;
        }
    }

    public void clearCorners() {
        Arrays.fill(redCorners, null);
        Arrays.fill(greenCorners, null);
    }

    public void clearMarks() {
        this.greenMarkedPoints = null;
        this.redMarkedPoints = null;
    }

    /** Set corner to paint.  If null is given that particular corner won't be shown */
    public void setCorners(
            Point topleft, Point topright, Point bottomleft, Point bottomright, MarkableJLabel.CornerColor color) {

        Point[] corners = null;

        switch (color) {
            case RED:
                corners = redCorners;
                break;
            default: // Green by default
                corners = greenCorners;
        }

        corners[TOPLEFT] = topleft;
        corners[TOPRIGHT] = topright;
        corners[BOTTOMLEFT] = bottomleft;
        corners[BOTTOMRIGHT] = bottomright;
    }

    /**
     * Return points which are used to mark specific color (null will give green)
     */
    public Point[] getMarkedPoints(MarkableJLabel.MarkColor color) {
        switch (color) {
            case RED:
                return redMarkedPoints;
            case BLUE:
                return blueMarkedPoints;
            case YELLOW:
                return yellowMarkedPoints;
            default: // Green by default
                return greenMarkedPoints;
        }
    }

    public void setMarkedPoints(Point[] markedPoints, MarkableJLabel.MarkColor color) {
        switch (color) {
            case RED:
                this.redMarkedPoints = markedPoints;
                break;
            case BLUE:
                this.blueMarkedPoints = markedPoints;
                break;
            case YELLOW:
                this.yellowMarkedPoints = markedPoints;
                break;
            default: // Green by default
                this.greenMarkedPoints = markedPoints;
        }
    }

    public int getCornerMarkLength() {
        return cornerMarkLength;
    }

    public void setCornerMarkLength(int cornerMarkLength) {
        this.cornerMarkLength = cornerMarkLength;
    }

    public int getPointMarkLength() {
        return pointMarkLength;
    }

    public void setPointMarkLength(int pointMarkLength) {
        this.pointMarkLength = pointMarkLength;
    }

    /**
     * Get ellisp bounding topleft point and size (represented by point)
     */
    public RotatedEllipse2D getGreenEllisp() {
        return greenEllisp;
    }

    /**
     * Set ellisp by specify topleft point and size (represented by point)
     */
    public void setGreenEllisp(RotatedEllipse2D greenEllisp) {
        this.greenEllisp = greenEllisp;
    }

    /**
     * Get ellisp bounding topleft point and size (represented by point)
     */
    public RotatedEllipse2D getRedEllisp() {
        return redEllisp;
    }

    /**
     * Set ellisp by specify topleft point and size (represented by point)
     */
    public void setRedEllisp(RotatedEllipse2D redEllisp) {
        this.redEllisp = redEllisp;
    }
}
