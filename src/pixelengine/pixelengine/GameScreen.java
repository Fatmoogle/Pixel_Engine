package pixelengine;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class GameScreen {
	
	private Frame frame;
    private Canvas canvas;
    
    private final int canvasWidth = 640;
    private final int canvasHeight = 360;
    
    private BufferedImage bufferedImage;
	
    public GameScreen() {
    	frame = new Frame();
        canvas = new Canvas();

        canvas.setPreferredSize(new Dimension(canvasWidth * 2 , canvasHeight * 2));
        
        frame.add(canvas);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Closed");
                System.exit(0);
            }
        });
        
        frame.setVisible(true);
        
        bufferedImage = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
    }
	
    public int[] getIntBuffer() {
    	return ((DataBufferInt) bufferedImage.getRaster().getDataBuffer()).getData();
    }
    
    public int getH() {
		return canvasHeight;
	}
    
    public int getW() {
		return canvasWidth;
	}
    
 	public void update() {
        Graphics g = canvas.getGraphics();
        g.drawImage(bufferedImage, 0, 0, canvasWidth * 2, canvasHeight * 2, null);
        g.dispose();
	}
}
