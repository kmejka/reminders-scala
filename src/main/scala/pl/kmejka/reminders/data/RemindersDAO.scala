package pl.kmejka.reminders.data

import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

import com.typesafe.scalalogging.LazyLogging
import pl.kmejka.reminders.model.Reminder

class RemindersDAO extends LazyLogging {

  val dataStore: ConcurrentHashMap[String, Reminder] = new ConcurrentHashMap[String, Reminder]()

  def saveReminder(reminder: Reminder): String = {
    logger.info(s"Saving reminder object $reminder")
    val uuid: String = UUID.randomUUID.toString
    dataStore.putIfAbsent(uuid, reminder)
    logger.debug(s"Data store contents after saving new reminder object: $dataStore")
    uuid
  }

  def getReminder(reminderId: String): Option[Reminder] = {
    logger.info(s"Getting reminder by id $reminderId")
    val reminder: Reminder = dataStore.get(reminderId)
    logger.debug(s"Found reminder in data store $reminder")
    Option.apply(reminder)
  }

  def getAllReminders(): List[Reminder] = {
    logger.info("Getting all reminders from data store")
    logger.warn("Not implemented")
    List.empty
  }

  def getRemindersForUser(userId: Long): List[Reminder] = {
    logger.info(s"Getting all reminders for user")
    logger.warn("Not implemented")
    List.empty
  }
}
