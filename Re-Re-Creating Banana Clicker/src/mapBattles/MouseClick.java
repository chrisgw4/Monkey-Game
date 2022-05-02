package mapBattles;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class MouseClick implements MouseInputListener{

    private boolean isClicked = false;
    private boolean inPanel = false;

    private JPanel panel;

    public MouseClick()
    {
        
    }

    public boolean isClicked() { 
        return isClicked; 
    }

    public boolean isInPanel() {
        return inPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        inPanel = true;
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        inPanel = false;
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        isClicked = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        isClicked = false;
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
