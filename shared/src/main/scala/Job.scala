package shared

import java.io.{File, FileWriter, BufferedWriter}

object Job {
 def timed(f: =>Any): (Long, Long) = {
    val start = System.currentTimeMillis
    f
    val end = System.currentTimeMillis
    (start, end)
  }
  def loop: Unit =  {
      val file = new File("foo.txt")
      file.delete
      val bw = new BufferedWriter(new FileWriter(file))
      1 to 1000000 foreach bw.write
      bw.close
  }
}
