import com.acmerobotics.roadrunner.geometry.Pose2d
import com.acmerobotics.roadrunner.geometry.Vector2d
import com.acmerobotics.roadrunner.path.heading.ConstantInterpolator
import com.acmerobotics.roadrunner.path.heading.HeadingInterpolator
import com.acmerobotics.roadrunner.path.heading.SplineInterpolator
import com.acmerobotics.roadrunner.trajectory.Trajectory
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder
import com.acmerobotics.roadrunner.trajectory.constraints.DriveConstraints

object TrajectoryGen {
    private val constraints = DriveConstraints(50.0, 60.0, 0.0, 270.0.toRadians, 270.0.toRadians, 0.0)
    private val startPose = Pose2d(-36.0, 62.75, 180.0.toRadians)

    fun createTrajectory(): ArrayList<Trajectory> {
        val list = ArrayList<Trajectory>()

        val builder1 = TrajectoryBuilder(startPose, constraints)

        // dump routine
        /* builder1
            .setReversed(true)
            .splineTo(Pose2d(-12.0, -42.0, 180.0.toRadians))// y = -39 is halfway between the skybridge and partner with 6" on either side, y = -42 gives 3" of room for other robot
            .splineTo(Pose2d(28.0, -42.0, 180.0.toRadians))
            .splineTo(Pose2d(48.0, -33.0, -90.0.toRadians))
            .lineTo(Vector2d(48.0, -26.0), ConstantInterpolator(-90.0.toRadians)) */
            //.splineTo(Pose2d(.0,.0,.0.toRadians)).reverse()
        builder1
            .lineTo(Vector2d(-20.0, 37.0), ConstantInterpolator(180.0.toRadians)) //start strafe
            .splineTo(Pose2d(-24.0,26.0,225.0.toRadians)).reverse() //first stone
            .splineTo(Pose2d(-5.0,34.0,90.0.toRadians)).reverse()
            .lineTo(Vector2d(50.0,32.5),ConstantInterpolator(90.0.toRadians)) //marker for foundation
            .splineTo(Pose2d(50.0,37.0,90.0.toRadians)) //release hooks
            .splineTo(Pose2d(30.0,48.0,180.0.toRadians))
            .lineTo(Vector2d(20.0,34.0),ConstantInterpolator(180.0.toRadians))
            .splineTo(Pose2d(-47.0,27.0,225.0.toRadians)).reverse()
            .splineTo(Pose2d(24.0,36.0,180.0.toRadians)).reverse()
            .lineTo(Vector2d(38.0,50.5),ConstantInterpolator(180.0.toRadians))
            .lineTo(Vector2d(20.0,34.0),ConstantInterpolator(180.0.toRadians))
            .splineTo(Pose2d(-32.0,24.0,225.0.toRadians)).reverse()
            .splineTo(Pose2d(20.0,36.0,180.0.toRadians))
            .lineTo(Vector2d(38.0,50.5),ConstantInterpolator(180.0.toRadians))
            .lineTo(Vector2d(0.0,34.0),ConstantInterpolator(180.0.toRadians))

        // weird reversed profiles
        /* builder
             .setReversed(true)
             .splineTo(Pose2d(-12.0, -42.0, 180.0.toRadians), SplineInterpolator(180.0.toRadians, startPose.heading))// y = 39 is halfway between the skybridge and partner with 6" on either side
             .splineTo(Pose2d(28.0, -42.0, 180.0.toRadians), SplineInterpolator(180.0.toRadians, 180.0.toRadians))
             .splineTo(Pose2d(48.0, -33.0, -90.0.toRadians), SplineInterpolator(180.0.toRadians, -90.0.toRadians))
             .lineTo(Vector2d(48.0, -26.0), ConstantInterpolator(-90.0.toRadians))*/


        list.add(builder1.build())
        return list
    }

    fun drawOffbounds() {
        GraphicsUtil.fillRect(Vector2d(0.0, -63.0), 17.75, 17.75) // robot against the wall
    }
}

val Double.toRadians get() = (Math.toRadians(this))