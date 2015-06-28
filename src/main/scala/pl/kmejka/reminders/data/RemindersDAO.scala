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
  def getReminder() = ???
  def getAllReminders() = ???
  def getRemindersForUser() = ???

}
