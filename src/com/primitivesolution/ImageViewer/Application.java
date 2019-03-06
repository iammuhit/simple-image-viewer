package com.primitivesolution.ImageViewer;

import com.primitivesolution.ImageViewer.Controllers.ImageController;

public class Application {

    public static ImageController app = new ImageController();

    public static void main(String[] args) {
        app.run();
    }

}
