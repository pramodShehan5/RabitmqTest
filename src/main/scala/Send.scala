import com.rabbitmq.client.{Channel, Connection, ConnectionFactory}

object Send {

  private val QUEUE_NAME="hello"

  def main(args: Array[String]): Unit = {
     val factory = new ConnectionFactory
    factory.setHost("localhost")
    factory.setUsername("pagero")
    factory.setPassword("Pagdia1")
    val connection = factory.newConnection()
    val channel = connection.createChannel()

    channel.queueDeclare(QUEUE_NAME, false, false, false, null)
    val message = "Hello World!"
    channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"))
    println(" [x] Sent '" + message + "'")

    channel.close()
    connection.close()
  }
}
