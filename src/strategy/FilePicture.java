package strategy;

import frames.DrawFrame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Class that is responsible to save draw as jpeg.
 */
public class FilePicture implements FileHandler {
	private DrawFrame frame;
	
	public FilePicture(DrawFrame frame) {
		this.frame = frame;
	}
	
	/**
	 * Save currently draw as picture.
	 */
	@Override
	public void save(File file) {
		 BufferedImage imagebuffer = null;
		    try {
		        imagebuffer = new Robot().createScreenCapture(frame.getView().getBounds());
		        frame.getView().paint(imagebuffer.createGraphics());
		        ImageIO.write(imagebuffer,"jpeg", new File(file + ".jpeg"));
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		    }
	}

	/**
	 * Not implemented.
	 */
	@Override
	public void open(File file) {}
}