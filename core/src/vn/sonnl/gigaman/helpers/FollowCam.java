/*
package vn.sonnl.gigaman.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;

import vn.sonnl.gigaman.entities.GigaMan;

public class FollowCam {

    public Camera camera;
    // Character as target
    public GigaMan target;
    private Boolean following;

    public FollowCam () {
        following = true;
    }

    public void update(float delta) {
        if(Gdx.input.isKeyJustPressed(Keys.F)){
            following = !following;
        }
        if(following){
            // If following, update the camera's position to match the target
            camera.position.x = target.getPosition().x;
            camera.position.y = target.getPosition().y;
        } else {
            if(Gdx.input.isKeyPressed(Keys.A)){
                camera.position.x -= delta * Constants.FOLLOW_CAM_MOVE_SPEED;
            }
            if (Gdx.input.isKeyPressed(Keys.D)) {
                camera.position.x += delta * Constants.FOLLOW_CAM_MOVE_SPEED;
            }

            if (Gdx.input.isKeyPressed(Keys.W)) {
                camera.position.y += delta * Constants.FOLLOW_CAM_MOVE_SPEED;
            }

            if (Gdx.input.isKeyPressed(Keys.S)) {
                camera.position.y -= delta * Constants.FOLLOW_CAM_MOVE_SPEED;
            }
        }

    }
}
*/
