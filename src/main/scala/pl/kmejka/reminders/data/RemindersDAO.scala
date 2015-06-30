package pl.kmejka.reminders.data

import java.util.UUID
import scala.collection.concurrent.{TrieMap, Map}
import com.typesafe.scalalogging.LazyLogging
import pl.kmejka.reminders.model.Reminder

class RemindersDAO extends LazyLogging {

  val dataStore: Map[String, Reminder] = new TrieMap[String, Reminder]()

  def saveReminder(reminder: Reminder): String = {
    logger.info(s"Saving reminder object $reminder")
    val uuid = UUID.randomUUID.toString
    dataStore.putIfAbsent(uuid, reminder)
    logger.debug(s"Data store contents after saving new reminder object: $dataStore")
    uuid
  }

  def getReminder(reminderId: String): Option[Reminder] = {
    logger.info(s"Getting reminder by id $reminderId")
    val reminder = dataStore.get(reminderId)
    logger.debug(s"Found reminder in data store $reminder")
    reminder
  }

  def getAllReminders(): List[Reminder] = {
    logger.info("Getting all reminders from data store")
    val reminders = dataStore.values.toList
    logger.debug(s"Returning reminders $reminders")
    reminders
  }

  def getRemindersForUser(userId: Long): List[Reminder] = {
    logger.info(s"Getting all reminders for user $userId")
    val reminders = dataStore.values.filter(reminder => reminder.userId.equals(userId)).toList
    logger.debug(s"Returning user reminders $reminders")
    reminders
  }
}
