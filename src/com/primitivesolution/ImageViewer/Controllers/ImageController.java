package com.primitivesolution.ImageViewer.Controllers;

import com.primitivesolution.ImageViewer.Panels.ButtonPanel;
import com.primitivesolution.ImageViewer.Views.ImageWindow;
import com.primitivesolution.ImageViewer.Models.ImageModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFrame;

public class ImageController implements ActionListener {

    private static ImageWindow view;
    private static ImageModel model;

    public void run() {
        view = new ImageWindow(this);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setTitle("Image Viewer");
        view.setResizable(false);
        view.pack(); //view.setSize(500, 300);
        view.setVisible(true);

        model = new ImageModel(view);
    }

    public void openImage() {
        File file = view.chooseImageFile();

        model.addFile(file);
        model.loadImage(file);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();

        switch (action) {
            case ButtonPanel.OPEN_BUTTON_LABEL: {
                this.openImage();
                break;
            }
            case ButtonPanel.GO_BACK_BUTTON_LABEL: {
                model.loadImage(model.getPrevFile());
                break;
            }
            case ButtonPanel.GO_FORWARD_BUTTON_LABEL: {
                model.loadImage(model.getNextFile());
                break;
            }
        }
    }

}
