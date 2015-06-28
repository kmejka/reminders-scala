package pl.kmejka.reminders.resources

import javax.ws.rs._
import javax.ws.rs.core.{MediaType, Response}

import com.codahale.metrics.annotation.Timed
import com.typesafe.scalalogging.LazyLogging
import pl.kmejka.reminders.data.RemindersDAO
import pl.kmejka.reminders.model.{Reminder, ReminderRequest}

@Path("/users/{userId}")
class RemindersResource(val remindersDAO: RemindersDAO) extends LazyLogging {

  @GET
  @Produces(Array(MediaType.TEXT_PLAIN))
  @Timed
  @Path("/world")
  def helloWorld(): String = {
    "Hello world"
  }

  @POST
  @Produces(Array(MediaType.APPLICATION_JSON))
  @Timed
  @Consumes(Array(MediaType.APPLICATION_JSON))
  @Path("/reminders/")
  def createReminderForUser(@PathParam("userId") userId: Long,
                             reminderRequest: ReminderRequest): Response = {
    logger.info(s"Creating reminder for user $userId with request $reminderRequest")
    val reminder: Reminder = Reminder(userId, reminderRequest.title, null, null, null)
    Response.ok().entity(reminder).build()
  }
}

