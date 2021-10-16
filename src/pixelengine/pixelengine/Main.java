package pixelengine;

public class Main {
    
    public static GameScreen screen;
    
    // Function to generate a random set of numbers with a min and max range
    public static int rand(int min, int max) {
        return (int) (min + (Math.random() * ((max + 1) - min)));
    }
    
    public static void main(String[] args) {
        screen = new GameScreen();
        PixelBuffer buffer = new PixelBuffer(screen);
        
        while(true) {
            buffer.clear();

            int xMid = buffer.getW() / 2;
            int yMid = buffer.getH() / 2;
            
            for(float i = 0; i < 360; i += 1) {
                int xDelta = (int) (Math.cos(Math.toRadians(i)) * 100);
                int yDelta = (int) (Math.sin(Math.toRadians(i)) * 100);
                
                buffer.drawLine(xMid + xDelta, yMid + yDelta, xMid + xDelta, yMid + yDelta, Pixel.white);
//                public void drawLine(int x1, int y1, int x2, int y2, Pixel pixel) {

            }
            
            screen.update();
        }
    }
    
}