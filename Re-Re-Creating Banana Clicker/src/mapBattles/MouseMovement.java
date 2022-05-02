package mapBattles;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMovement implements MouseMotionListener{


    private int myX = 0;
    private int myY = 0;

    


    @Override
    public void mouseDragged(MouseEvent e) {
        
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        myX = e.getX();
        myY = e.getY();
        
    }

    public int getX() {
        return myX;
    }

    public int getY() {
        return myY;
    }
    
}
