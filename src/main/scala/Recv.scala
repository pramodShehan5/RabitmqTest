import Send.QUEUE_NAME
import com.rabbitmq.client.{AMQP, ConnectionFactory, DefaultConsumer, Envelope}

object Recv {

  private val QUEUE_NAME="hello"

  def main(args: Array[String]): Unit = {

      val factory = new ConnectionFactory
      factory.setHost("localhost")
          factory.setUsername("pagero")
          factory.setPassword("Pagdia1")
      val connection = factory.newConnection()
      val channel = connection.createChannel()

      channel.queueDeclare(QUEUE_NAME, false, false, false, null)
      println("[*] Waiting for messages. To exit press CTRL+C")
      val consumer=new DefaultConsumer(channel){
        override def handleDelivery( consumerTag:String,  envelope:Envelope,  properties:AMQP.BasicProperties,  body:Array[Byte]){
          val message = new String(body, "UTF-8")
          println(" [x] Received '" + message + "'")
        }
      }
    channel.basicConsume(QUEUE_NAME, true, consumer)
  }
}
