package com.primitivesolution.ImageViewer.Models;

import com.primitivesolution.ImageViewer.Views.ImageWindow;
import com.primitivesolution.ImageViewer.Views.ImageWindow;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ImageModel {

    protected BufferedImage image;
    protected ImageWindow view;
    protected List<File> files = new ArrayList<>();
    protected int historyPosition;

    public ImageModel(ImageWindow view) {
        this.view = view;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void loadImage(File file) {
        if (file != null) {
            try {
                image = ImageIO.read(file.getAbsoluteFile());

                view.setImage(image);

                setHistoryPosition(file);
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(view, "Error Opening File.", "Invalid File", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void addFile(File file) {
        files.add(file);
    }

    public List<File> getFiles() {
        return files;
    }

    public File getFile(int index) {
        if (index >= 0 && index < files.size()) {
            return files.get(index);
        }

        return null;
    }

    public File getCurrentFile() {
        return getFile(historyPosition);
    }

    public File getPrevFile() {
        return getFile(historyPosition - 1);
    }

    public File getNextFile() {
        return getFile(historyPosition + 1);
    }

    public void setHistoryPosition(File file) {
        if (files.contains(file)) {
            historyPosition = files.indexOf(file);
        }
    }

    public int getHistoryPosition() {
        return (historyPosition >= 0) ? historyPosition : -1;
    }

    public int getLastFilePosition() {
        return files.size() - 1;
    }

}
