import cats.effect.IO
import cats.effect.std.Dispatcher
import cats.effect.IOApp
import cats.effect.ExitCode
import shared.Job
object Ce3Benchmark extends IOApp {

    override def run(args: List[String]): IO[ExitCode] = {
        val ioJob: IO[Unit] = IO {Job.loop}
        Dispatcher[IO].use {dispatcher => 
            val (start, end) = Job.timed(dispatcher.unsafeRunSync(ioJob))
            println(s"Time taken in milliseconds: ${end - start}")
            IO(ExitCode.Success)
        }
    }

  
}
