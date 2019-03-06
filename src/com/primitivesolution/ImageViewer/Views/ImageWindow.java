package com.primitivesolution.ImageViewer.Views;

import com.primitivesolution.ImageViewer.Panels.ButtonPanel;
import com.primitivesolution.ImageViewer.Panels.ImagePanel;
import com.primitivesolution.ImageViewer.Controllers.ImageController;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class ImageWindow extends JFrame {

    protected ImageController controller;
    protected ImagePanel imagePanel;
    protected ButtonPanel buttonPanel;

    public ImageWindow(ImageController controller) {
        this.controller = controller;
        this.imagePanel = new ImagePanel();
        this.buttonPanel = new ButtonPanel(controller);

        super.add(this.imagePanel, BorderLayout.CENTER);
        super.add(this.buttonPanel, BorderLayout.SOUTH);
    }

    public void setImage(BufferedImage image) {
        this.imagePanel.setSize(image.getWidth(), image.getHeight());
        this.imagePanel.setImage(image);

        int width = super.getInsets().left + super.getInsets().right + this.imagePanel.getWidth();
        int height = super.getInsets().top + super.getInsets().bottom + this.imagePanel.getHeight() + this.buttonPanel.getHeight();

        super.setSize(width, height);
    }

    public File chooseImageFile() {
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Only Image Files", "JPG", "JPEG", "PNG", "GIF");
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(extensionFilter);

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }

        return null;
    }

}
