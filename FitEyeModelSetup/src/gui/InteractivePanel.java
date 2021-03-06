/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import logic.RotatedEllipse2D;

/**
 *
 * @author   dwyatte
 *
 * This class draws images as they are presented via setImage
 *
 * Also, it maintains a list of 4 drawing shapes -- 2 ellipses and 2 squares
 * that represent the cr/pupil and background/searchspace
 */
public class InteractivePanel  extends javax.swing.JLabel {

    final static int COLOR_SAMPLING_SIZE = 2;
    RotatedEllipse2D cr, pupil;
    //Rectangle backgroundRect;
    Rectangle searchRect;
    Shape shapeToMove;
    int BG_RECT_SIZE = 25;
    // the image to paint initialized to prevent null point execption
    BufferedImage img = null;
    // Highlight to paint
    LinkedList<BufferedImage> highlightImgList = new LinkedList<BufferedImage>();
    private Point mousePos;
    private ColorCaptureListener colorCaptureListener;
    private ChangeListener searchAreaChangeListener = null;

    @Override
    public void paint(Graphics g) {
        super.paint(g);

//        // draw the image
//        g.drawImage(img, 0, 0, null);

        // draw the highlight
        for (Iterator<BufferedImage> it = highlightImgList.iterator(); it.hasNext();) {
            BufferedImage highlightImg = it.next();
            g.drawImage(highlightImg, 0, 0, null);
        }

        // draw shapes
        g.setXORMode(Color.PINK);

        g.setColor(Color.GREEN);

        Graphics2D g2d = (Graphics2D) g;
        AffineTransform oldTransform = g2d.getTransform();
        if (cr != null) {
            // Somehow there is some translation in the old trandform so we have to observe it
            AffineTransform aff = AffineTransform.getTranslateInstance(
                    oldTransform.getTranslateX(),
                    oldTransform.getTranslateY());
            aff.rotate(cr.getAngle(),
                    cr.getCenterX(),
                    cr.getCenterY());
            g2d.setTransform(aff);

            g2d.draw(cr);
            g2d.drawLine((int) cr.getX(), (int) cr.getCenterY(), (int) cr.getMaxX(), (int) cr.getCenterY());
            g2d.setTransform(oldTransform);
        }

        if (pupil != null) {
            // Somehow there is some translation in the old trandform so we have to observe it
            AffineTransform aff = AffineTransform.getTranslateInstance(
                    oldTransform.getTranslateX(),
                    oldTransform.getTranslateY());
            aff.rotate(pupil.getAngle(),
                    pupil.getCenterX(),
                    pupil.getCenterY());

            g2d.setTransform(aff);
            g2d.draw(pupil);
            g2d.drawLine((int) pupil.getX(), (int) pupil.getCenterY(),
                    (int) pupil.getMaxX(), (int) pupil.getCenterY());
            g2d.setTransform(oldTransform);
        }
        g2d.draw(searchRect);
        g2d.setColor(Color.YELLOW);
    }

    /** Creates new form EyeImagePanel */
    public InteractivePanel() {
        initComponents();
        setText(null);
        setHorizontalAlignment(LEFT);
        setVerticalAlignment(TOP);
        this.searchRect = new Rectangle(125, 25, 100, 100);
    }

    public Rectangle getSearchRect() {
        return searchRect;
    }

    public BufferedImage getImage() {
        return img;
    }

    public void addHighlight(BufferedImage img) {
        this.highlightImgList.add(img);
    }

    public void removeHighlight(BufferedImage img) {
        this.highlightImgList.remove(img);
    }

    public void clearHighlight() {
        this.highlightImgList.clear();
    }

    /**
     * shape/img setters
     */
    public void setSearchRect(Rectangle r) {
        searchRect = r;
        if (this.searchAreaChangeListener != null) {
            this.searchAreaChangeListener.stateChanged(new ChangeEvent(this));
        }
        repaint();
    }

    public void setPupil(RotatedEllipse2D e) {
        pupil = e;
    }

    public void setCR(RotatedEllipse2D e) {
        cr = e;
    }

    public void setImage(BufferedImage img) {
        this.img = img;
        setIcon(new ImageIcon(img));
        repaint();
    }

  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                handleMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                handleMousePressed(evt);
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                handleMouseReleased(evt);
            }
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                handleMouseClicked(evt);
            }
        });

    }
    
    private void handleMouseDragged(java.awt.event.MouseEvent evt) {
        // move the selected shape; note that search rect has the lowest priority, since it is the biggest
        if (shapeToMove != null) {
            if (shapeToMove.equals(searchRect)) {
                this.searchRect.translate(
                        evt.getX() - this.mousePos.x,
                        evt.getY() - this.mousePos.y);
                setSearchRect(searchRect);
                shapeToMove = searchRect;
            }
            // Update mouse position
            this.mousePos = evt.getPoint();
        }
    }

    private void handleMousePressed(java.awt.event.MouseEvent evt) {
        // Remember the last place we click
        this.mousePos = evt.getPoint();
        // Remember the last

        // select the shape; note that search rect has lowest priority because it is the biggest
        if (searchRect.contains(evt.getX(), evt.getY())) {
            shapeToMove = searchRect;
        } else {
            shapeToMove = null;
        }
    }

    private void handleMouseReleased(java.awt.event.MouseEvent evt) {
        // unselect the shape
        shapeToMove = null;
    }

    private void handleMouseClicked(java.awt.event.MouseEvent evt) {
        if (this.colorCaptureListener != null && this.img != null) {
            // Capture gray color
            Point center = evt.getPoint();

            int topBound = Math.max(0, center.y - COLOR_SAMPLING_SIZE);
            int bottomBound = Math.min(img.getHeight(), center.y + COLOR_SAMPLING_SIZE);
            int leftBound = Math.max(0, center.x - COLOR_SAMPLING_SIZE);
            int rightBound = Math.min(img.getWidth(), center.x + COLOR_SAMPLING_SIZE);

            int totalPix = 0;
            int sumPix = 0;
            for (int x = leftBound; x <= rightBound; x++) {
                for (int y = topBound; y <= bottomBound; y++) {
                    sumPix += (img.getRGB(x, y) & 0xff);
                    totalPix++;
                }
            }

            this.colorCaptureListener.setColor(sumPix / totalPix);
        }
    }

    public void setColorCaptureListener(ColorCaptureListener listener) {
        this.colorCaptureListener = listener;
    }

    public void setSearchAreaChangeListener(ChangeListener listener) {
        this.searchAreaChangeListener = listener;
    }
}
