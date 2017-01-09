package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.renderer.RenderManager;
import com.jme3.system.AppSettings;

/**
 * test
 * @author normenhansen
 */
public class CubeChaser extends SimpleApplication {

    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);
        settings.setTitle("Macs Game");
        settings.setResolution(1366, 768);
        CubeChaser app = new CubeChaser();
        app.setSettings(settings);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        flyCam.setMoveSpeed(25f);
        CubeChaserState state = new CubeChaserState();
        stateManager.attach(state);
    }//simpleInit

    @Override
    public void simpleUpdate(float tpf) {
        System.out.println("Chase Counter: "
                +stateManager.getState(CubeChaserState.class)
                .getCounter() );
    }//simpleUpdate

    @Override
    public void simpleRender(RenderManager rm) {

    }//simpleRender
    
    
}//class
