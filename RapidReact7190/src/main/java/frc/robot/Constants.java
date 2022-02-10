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
    
    public static final double NORMAL_SPEED = 0;
    public static final double BOOSTED_SPEED = 0;
    
  }
  
  public final class HangerConstants {
  }

  public final class IntakeConstants {
    public static final int CONTROLLER = 0;

  }

  public final class LimeLightConstants {
    public static final float SHIFT_CONTR = -0.1f;
  }
}
