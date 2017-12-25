package scala.com.alex

import org.apache.spark.{SparkConf, SparkContext}

object Rdds extends App {
	val conf = new SparkConf().setAppName("Rdds").setMaster("local")
	val sc = new SparkContext(conf)
	val array = 1 to 1000
	val distData = sc.parallelize(array)
	val reVal = distData.reduce((x, y) => x + y)
	print(reVal)
}
