package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.collision.CollisionResults;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.input.controls.Trigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

/**
 * test
 * @author normenhansen
 */
public class TargetPickCursor extends SimpleApplication {
    private final static Trigger TRIGGER_ROTATE = new MouseButtonTrigger(MouseInput.BUTTON_LEFT);
    private final static String MAPPING_ROTATE = "Rotate";
    private static Box mesh = new Box(Vector3f.ZERO, 1, 1, 1);
    
    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);
        settings.setTitle("Macs Game");
        settings.setResolution(1366, 768);
        TargetPickCursor app = new TargetPickCursor();
        app.setSettings(settings);
        app.start();
    }

    @Override
    public void simpleInitApp() {       
        //setup for click based target picking
        flyCam.setDragToRotate(true);
        inputManager.setCursorVisible(true);
        
        //input mappings
        inputManager.addMapping(MAPPING_ROTATE, TRIGGER_ROTATE);
        inputManager.addListener(analogListener, new String[]{MAPPING_ROTATE});
        
        rootNode.attachChild(myBox(
                "Red Cube", new Vector3f(0, 1.5f, 0), ColorRGBA.Red));
        rootNode.attachChild(myBox(
                "Blue Cube", new Vector3f(0, -1.5f, 0), ColorRGBA.Blue));
        
    
                
    }//SimipleInit
    
    private AnalogListener analogListener = new AnalogListener() {

        public void onAnalog(String name, float value, float tpf) {
            if(name.equals(MAPPING_ROTATE)){
                CollisionResults results = new CollisionResults();
                Vector2f clicked2d = inputManager.getCursorPosition();
                Vector3f clicked3d = cam.getWorldCoordinates(
                        new Vector2f(clicked2d.getX(), clicked2d.getY()), 0);
                Vector3f dir = cam.getWorldCoordinates(
                        new Vector2f(clicked2d.getX(), clicked2d.getY()), 1f)
                        .subtractLocal(clicked3d);
                Ray ray = new Ray(clicked3d, dir);
                rootNode.collideWith(ray, results);
                
                if(results.size() > 0){
                    Geometry target = results.getClosestCollision().getGeometry();
                    if(target.getName().equals("Red Cube")){
                        target.rotate(0, -value, 0);//rotate left
                    } else if(target.getName().equals("Blue Cube")){
                        target.rotate(0, value, 0);//rotate right
                    }//else if
                } else{
                    System.out.println("Selection: Nothing");
                }//else             
            }//if
        }//onAnalog
    };//analogListener

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }//simpleRender
    
    public Geometry myBox(String name, Vector3f loc, ColorRGBA color){
        Geometry geom = new Geometry(name, mesh);
        Material mat = new Material(assetManager,
            "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", color);
        geom.setMaterial(mat);
        geom.setLocalTranslation(loc);
        
        return geom;
    }//myBox
}//Class
