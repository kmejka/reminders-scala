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
    val remindersDao = new RemindersDAO
    val reminder = new Reminder(1L, "some title", "someStart", "someEnd", "someChannel")

    //WHEN
    val reminderId = remindersDao.saveReminder(reminder)

    //THEN
    assert(reminderId != null, "received reminderId is null!")
    assert(remindersDao.dataStore.contains(reminderId), "data store does not contain the provided reminder! ")
  }

  test("Getting from data store works") {
    //GIVEN
    val remindersDao = new RemindersDAO
    val reminder = new Reminder(1L, "some title", "someStart", "someEnd", "someChannel")
    val reminderId = remindersDao.saveReminder(reminder)
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

  test("Getting all reminders from data store") {
    //GIVEN
    val remindersDao = new RemindersDAO
    val reminder1 = new Reminder(1L, "some title", "someStart", "someEnd", "someChannel")
    val reminder2 = new Reminder(1L, "some title", "someStart", "someEnd", "someChannel")
    val reminderId1 = remindersDao.saveReminder(reminder1)
    assert(reminderId1 != null, "saving failed, received reminderId1 is null!")
    val reminderId2 = remindersDao.saveReminder(reminder2)
    assert(reminderId2 != null, "saving failed, received reminderId2 is null!")

    //WHEN
    val allReminders = remindersDao.getAllReminders()

    //THEN
    assert(allReminders.size == 2, "not all reminders were returned!")
  }

  test("Getting reminders for one user from data store") {
    //GIVEN
    val remindersDao = new RemindersDAO
    val reminders = List(
      new Reminder(1L, "some title", "someStart", "someEnd", "someChannel"),
      new Reminder(1L, "some title", "someStart", "someEnd", "someChannel"),
      new Reminder(2L, "some title", "someStart", "someEnd", "someChannel")
    )
    reminders.foreach(reminder => remindersDao.saveReminder(reminder))

    //WHEN
    val remindersForUser = remindersDao.getRemindersForUser(1L)

    //THEN
    assert(remindersForUser.size == 2, "incorrect number of reminders returned for user!")
  }

}
