package pl.kmejka.reminders.data

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import pl.kmejka.reminders.model.Reminder

@RunWith(classOf[JUnitRunner])
class RemindersDAOTest extends FunSuite {

  //POSITIVE TEST CASES
  test("Adding to data store works") {
    //GIVEN
    val remindersDao: RemindersDAO = new RemindersDAO
    val reminder: Reminder = new Reminder(1L, "some title", "someStart", "someEnd", "someChannel")

    //WHEN
    val reminderId: String = remindersDao.saveReminder(reminder)

    //THEN
    assert(reminderId != null, "received reminderId is null!")
    assert(remindersDao.dataStore.contains(reminder), "data store does not contain the provided reminder!")
  }

  test("Getting from data store works") {
    //GIVEN
    val remindersDao: RemindersDAO = new RemindersDAO
    val reminder: Reminder = new Reminder(1L, "some title", "someStart", "someEnd", "someChannel")
    val reminderId: String = remindersDao.saveReminder(reminder)
    assert(reminderId != null, "saving failed, received reminderId is null!")

    //WHEN
    val optionalReminder: Option[Reminder] = remindersDao.getReminder(reminderId)

    //THEN
    optionalReminder match {
      case None => fail("did not receive a reminder")
      case x: Some[Reminder] =>
        assert(x.get.userId == 1L, "the received reminder is not the reminder stored previously")
    }
  }
}
