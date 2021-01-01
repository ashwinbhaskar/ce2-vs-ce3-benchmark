import cats.effect.IO
import cats.effect.IOApp
import cats.effect.ExitCode
import shared.Job
object Ce2Benchmark extends IOApp{

    override def run(args: List[String]): IO[ExitCode] = {
        val ioJob: IO[Unit] = IO {Job.loop}
        val (start, end) = Job.timed(ioJob.unsafeRunSync)
        println(s"Time taken in milliseconds: ${end - start}")
        IO(ExitCode.Success)
    }
  
}
