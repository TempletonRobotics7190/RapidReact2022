/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

package frc.robot;

import java.util.HashMap;
import java.util.Map;

public final class Constants {
  public static final class DriveConstants {
    public static final int FRONT_LEFT_CONTROLLER = 3;
    public static final int FRONT_RIGHT_CONTROLLER = 1;
    public static final int BACK_LEFT_CONTROLLER = 4;
    public static final int BACK_RIGHT_CONTROLLER = 2;
    
    public static final float ROT_SPEED = 0.35f;

    public static final float NORMAL_MOVE_SPEED = 0.50f;
    public static final float BOOST_MOVE_SPEED = 1.0f;
    
  }
  
  public static final class HangerConstants {
  }

  public final class IntakeConstants {
    public static final int CONTROLLER = 2;

    public static final float SPEED = -1.0f;
    public static final float REVERSE_SPEED = 0.5f;


  }
  public static final class BarrelConstants {
    public static final int CONTROLLER = 3;
    public static final float SPEED = 0.35f;
    public static final float REVERSE_SPEED = -0.35f;
  }

  public static final class ShooterConstants {
    public static final int BIG_CONTROLLER = 0;
    public static final int SMALL_CONTROLLER = 1;

    public static final float BIG_WHEEL_SPEED = -0.55f;
    public static final float SMALL_WHEEL_SPEED = -0.55f; // 55

    public static final float REVERSE_SPEED = 0.45f;
  }

  public static final class LimeLightConstants {

    // Rotate
    public static final HashMap<String, Float> ROT_SETTINGS_PRECISE = new HashMap<String, Float>(Map.of(
      // does not see tape? move at constant spee
      "blind speed", 0.2f,

      // sees tape and not within threshold
      "offset fraction", 0.2f,

      // within this threshold? move at small speed
      "small threshold", 10.0f,
      "small speed", 0.1f,

      // within the stop threshold? stop
      "stop threshold", 0.1f
    ));
    public static final HashMap<String, Float> ROT_SETTINGS_ROUGH = new HashMap<String, Float>(Map.of(
      // does not see tape? move at constant spee
      "blind speed", 0.4f,

      // sees tape and not within threshold
      "offset fraction", 0.5f,

      // within this threshold? move at small speed
      "small threshold", 20.0f,
      "small speed", 0.2f,

      // within the stop threshold? stop
      "stop threshold", 0.3f
    ));

    // Move
    public static final HashMap<String, Float> MOVE_SETTINGS_DEFAULT = new HashMap<String, Float>(Map.of(
      // sees the tape far away
      "default speed", 0.4f,

      // within this threshold? move at small speed
      "small threshold", 10.0f,
      "small speed", 0.2f,

      // within the stop threshold? stop
      "stop threshold", 0.2f
    ));
  }
}

