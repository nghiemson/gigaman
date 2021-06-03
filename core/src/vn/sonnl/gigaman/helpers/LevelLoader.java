/*
package vn.sonnl.gigaman.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.Comparator;

import vn.sonnl.gigaman.Level;
import vn.sonnl.gigaman.entities.Enemy;
import vn.sonnl.gigaman.entities.GigaMan;
import vn.sonnl.gigaman.entities.Platform;
import vn.sonnl.gigaman.entities.Powerup;
import vn.sonnl.gigaman.entities.ExitPortal;

public class LevelLoader {
    public static final String TAG = LevelLoader.class.toString();

    public static Level load(String path) {

        Level level = new Level();
        FileHandle file = Gdx.files.internal(path);
        JSONParser parser = new JSONParser();
        try {
            // TODO: get the root JSONObject by parsing the level file
            // Use file.reader() to pass a file reader into parse() on the parser, then cast the result to a JSONObject
            JSONObject rootJsonObject = (JSONObject) parser.parse(file.reader());

            // TODO: Get the 'composite' object within the rootJsonObject
            JSONObject composite = (JSONObject) rootJsonObject.get(Constants.LEVEL_COMPOSITE);

            // TODO: Get the JSONArray behind the LEVEL_9PATCHES key
            JSONArray platforms = (JSONArray) composite.get(Constants.LEVEL_9PATCHES);

            loadPlatforms(platforms, level);
            // TODO: Get the non-platform level objects from composite (using the Constants.LEVEL_IMAGES key)
            JSONArray nonPlatformObjects = (JSONArray) composite.get(Constants.LEVEL_IMAGES);

            // TODO: Call loadNonPlatformEntities()
            loadNonPlatformEntities(level, nonPlatformObjects);
        } catch (Exception ex) {
            Gdx.app.error(TAG, ex.getMessage());
            Gdx.app.error(TAG, Constants.LEVEL_ERROR_MESSAGE);
        }

        return level;
    }

    private static float safeGetFloat(JSONObject object, String key) {
        Number number = (Number) object.get(key);
        return (number == null) ? 0 : number.floatValue();
    }

    private static void loadPlatforms(JSONArray array, Level level) {

        Array<Platform> platformArray = new Array<>();

        for (Object object : array) {
            final JSONObject platformObject = (JSONObject) object;

            final float x = safeGetFloat(platformObject, Constants.LEVEL_X_KEY);

            // TODO: Get the y position of the platform
            // Use the LEVEL_Y_KEY constant we defined
            // Not that this is the BOTTOM of the platform, not the top
            // Also note that if the platform is at (0, 0), the x and y keys will be missing from the JSON
            // Hence the need for the safeGetFloat() method defined above
            final float y = safeGetFloat(platformObject, Constants.LEVEL_Y_KEY);

            final float width = ((Number) platformObject.get(Constants.LEVEL_WIDTH_KEY)).floatValue();
            //Get the platform height
            final float height = ((Number) platformObject.get(Constants.LEVEL_HEIGHT_KEY)).floatValue();

            // TODO: Optional, log the location and dimensions of the platform
            Gdx.app.log(TAG,
                    "Loaded a platform at x = " + x + " y = " + (y + height) + " w = " + width + " h = " + height);

            // TODO: Make a new platform with the dimensions we loaded
            // Remember that the y position we loaded is the platform bottom, not top
            final Platform platform = new Platform(x, y + height, width, height);

            // TODO: Add the platform to the platformArray
            platformArray.add(platform);

            // TODO: Get the platform identifier
            // Use the LEVEL_IDENTIFIER_KEY constant
            final String identifier = (String) platformObject.get(Constants.LEVEL_IDENTIFIER_KEY);

            // TODO: Check if the platform identifier equals the LEVEL_ENEMY_TAG
            if (identifier != null && identifier.equals(Constants.LEVEL_ENEMY_TAG)) {
                Gdx.app.log(TAG, "Loaded an enemy on that platform");
                // TODO: If so, create a new enemy on the platform
                final Enemy enemy = new Enemy(platform);
                // TODO: Add that enemy to the list of enemies in the level
                level.getEnemies().add(enemy);
            }
        }

        // TODO: Sort the platform array by descending position of the top of the platform
        // We're doing this so lower platforms aren't hidden by higher platforms
        // This one is tough. Check out the solution project if you run into trouble
        platformArray.sort(new Comparator<Platform>() {
            @Override
            public int compare(Platform o1, Platform o2) {
                if (o1.top < o2.top) {
                    return 1;
                } else if (o1.top > o2.top) {
                    return -1;
                }
                return 0;
            }
        });

        // TODO: Add all the platforms from platformArray to the level
        level.getPlatforms().addAll(platformArray);
    }

    private static void loadNonPlatformEntities(Level level, JSONArray nonPlatformObjects) {
        for (Object o : nonPlatformObjects) {

            // First we need to cast the object to a JSONObject
            JSONObject item = (JSONObject) o;

            // TODO: Get the lower left corner of the object
            // Remember to use safeGetFloat()
            Vector2 lowerLeftCorner = new Vector2();

            final float x = safeGetFloat(item, Constants.LEVEL_X_KEY);
            final float y = safeGetFloat(item, Constants.LEVEL_Y_KEY);

            lowerLeftCorner = new Vector2(x, y);

            // Check if this object is GigaGal
            if (item.get(Constants.LEVEL_IMAGENAME_KEY).equals(Constants.STANDING_RIGHT)) {

                // If so, add GigaGal's eye position to find her spawn position
                final Vector2 gigaGalPosition = lowerLeftCorner.add(Constants.GIGAMAN_EYE_POSITION);
                Gdx.app.log(TAG, "Loaded GigaGal at " + gigaGalPosition);

                // Add our new GigaGal to the level
                level.setGigaMan(new GigaMan(gigaGalPosition, level));
            }

            // TODO: Go through the same process to load the Exit Portal
            else if (item.get(Constants.LEVEL_IMAGENAME_KEY).equals(Constants.EXIT_PORTAL_SPRITE_1)) {
                final Vector2 exitPortalPosition = lowerLeftCorner.add(Constants.EXIT_PORTAL_CENTER);
                Gdx.app.log(TAG, "Loaded the exit portal at " + exitPortalPosition);
                level.setExitPortal(new ExitPortal(exitPortalPosition));
            }

            // TODO: Load the Powerups
            else if (item.get(Constants.LEVEL_IMAGENAME_KEY).equals(Constants.POWERUP)) {
                final Vector2 powerupPosition = lowerLeftCorner.add(Constants.POWERUP_CENTER);
                Gdx.app.log(TAG, "Loaded a powerup at " + powerupPosition);
                level.getPowerups().add(new Powerup(powerupPosition));
            }
        }
    }
}
*/
