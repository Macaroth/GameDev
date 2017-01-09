package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);
        settings.setTitle("Macs Game");
        Main app = new Main();
        app.setSettings(settings);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        Box b = new Box(1, 1, 1);
        Geometry geom = new Geometry("Box", b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);
        geom.setLocalScale(0.5f,3f,0.75f);
        rootNode.attachChild(geom);
        
        //second cube
        Vector3f v = new Vector3f(2.0f, 1.0f, -3.0f); //location for second cube
        Box b2 = new Box(1, 1, 1);
        Geometry geom2 = new Geometry("Box", b2);
        Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", ColorRGBA.Yellow);
        geom2.setMaterial(mat2);
        geom2.setLocalTranslation(v);
        geom2.scale(2.0f,0.33f,2.0f);
        rootNode.attachChild(geom2);
        
        float r = FastMath.DEG_TO_RAD*45;
        geom.rotate(0.0f, r, 0.0f);
        
        
        Quaternion roll045 = new  Quaternion();
        roll045.fromAngleAxis(45*FastMath.DEG_TO_RAD, Vector3f.UNIT_X);
        geom2.setLocalRotation(roll045);
        
        Node pivot = new Node("pivot node");
        pivot.attachChild(geom);
        pivot.attachChild(geom2);
        pivot.rotate(00, 0, FastMath.DEG_TO_RAD*45);
        rootNode.attachChild(pivot);
        
                
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
