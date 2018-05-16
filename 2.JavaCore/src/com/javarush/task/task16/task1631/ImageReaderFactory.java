package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory implements ImageReader{
    public static ImageReader getImageReader(ImageTypes s) {
        /*switch (s) {
            case JPG: return new JpgReader(); break;
            case BMP: return new BmpReader(); break;
            case PNG: return new PngReader(); break;
            default: return null;
        }*/
        if (s == ImageTypes.JPG) return new JpgReader();
        if (s == ImageTypes.BMP) return new BmpReader();
        if (s == ImageTypes.PNG) return new PngReader();
        else throw new IllegalArgumentException();
    }
}
