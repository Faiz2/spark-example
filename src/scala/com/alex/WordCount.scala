package scala.com.alex

import org.apache.spark.{SparkConf, SparkContext}

object WordCount extends App {

	val conf = new SparkConf().setAppName("wordCount").setMaster("local")
	val sc = new SparkContext(conf)
	val input = sc.textFile("src/resources/test.txt")
	val words = input.flatMap(line => line.split(","))
	val counts = words.map(word => (word, 1)).reduceByKey((x, y) => x + y, 2)
//	val counts2 = words.map(word => (word, 1)).sortByKey(ascending = false, 2)
	counts.persist()
	counts.foreach(println(_))
//	counts2.foreach(println(_))
}
