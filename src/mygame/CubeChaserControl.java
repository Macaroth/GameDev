/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.collision.CollisionResults;
import com.jme3.math.Ray;
import com.jme3.renderer.Camera;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import com.jme3.scene.control.Control;

/**
 *
 * @author mac
 */
public class CubeChaserControl extends AbstractControl{
    public CubeChaserControl(Camera cam, Node rootNode){}//contructor    
    @Override
    protected void controlUpdate(float tpf){
        spatial.rotate(tpf, tpf, tpf); //rotate spatial to see this control is attached
    }//controlUpdate
    protected void controlRender(RenderManager rm, ViewPort vp){}//controlRender
    public Control cloneForSpatial(Spatial spatial){
        throw new UnsupportedOperationException("Not supported yet.");
    }//cloneForSpatial
    
    public String hello(){
        return "Hello, my name is "+spatial.getName();
    }//hello
    
}//class
