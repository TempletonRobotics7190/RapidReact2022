/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

package frc.robot;


public final class Constants {
  public final class DriveConstants {
    public static final int FRONT_LEFT_CONTROLLER = 3;
    public static final int FRONT_RIGHT_CONTROLLER = 1;
    public static final int BACK_LEFT_CONTROLLER = 4;
    public static final int BACK_RIGHT_CONTROLLER = 2;
    
    public static final float NORMAL_MOVE_SPEED = 0.43f;
    public static final float NORMAL_ROT_SPEED = 0.6f;
    
    public static final float BOOST_SPEED = 0.7f;
    
  }
  
  public final class HangerConstants {
  }

  public final class IntakeConstants {
    public static final int CONTROLLER = 2;

    public static final float SPEED = 1.0f;

  }
  public final class BarrelConstants {
    public static final int CONTROLLER = 1;
    public static final float SPEED = -0.75f;
  }

  public final class ShooterConstants {
    public static final int CONTROLLER = 0;

    public static final float SPEED = -0.75f;
  }

  public final class LimeLightConstants {
    public static final float SHIFT_CONTR = -0.1f;
    public static final float ROT_THRESHOLD = 0.1f;
    public static final float ROT_BLIND_SPEED = 0.2f;
    public static final float MOVE_SPEED = 0.2f;
    public static final float MOVE_THRESHOLD = 0.1f;
  }
}

