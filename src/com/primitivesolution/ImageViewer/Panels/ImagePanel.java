package com.primitivesolution.ImageViewer.Panels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    protected BufferedImage image;

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(this.image, 0, 0, this);
    }

}
