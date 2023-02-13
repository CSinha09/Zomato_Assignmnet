package Hello
import com.github.tototoshi.csv._

import java.util.TreeMap
import java.util.PriorityQueue
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Main {

  def main(args: Array[String]) {
    val reader = CSVReader.open("src/main/Resources/testfile.csv");
    val rowList = ListBuffer[Seq[String]]()
    reader.iterator.take(10).foreach(row => rowList += row)
    val finalList = Array[Array[String]]()
    val id_name = new TreeMap[String, String]()
    val top_rest = new mutable.PriorityQueue[String]()
    for (row <- rowList) {
      val res = row.flatMap {
        case s: String => "start" :: s.split(", ").toList ::: List("end")
        case x => List(x.toString)
      }
      val res1: String = res.map(_.toString).mkString(", ")
      val req: Array[String] = res1.split(", ")
      id_name.put(req(1), req(4))
      top_rest.enqueue(req(7) + " " + req(4))
    }
  }

  def topNRest ( pq:  mutable.PriorityQueue[String], sz: Int): Unit = {
      var ct = 0;
      while (ct < sz) {
        println(pq.dequeue());
        ct = ct + 1
      }
  }

}
