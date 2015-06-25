package pl.kmejka.reminders.resources

import javax.ws.rs.core.MediaType
import javax.ws.rs.{Path, Produces, GET}

import com.codahale.metrics.annotation.Timed

@Path("/hello")
class RemindersResource {

  @GET
  @Produces(Array(MediaType.TEXT_PLAIN))
  @Timed
  @Path("/world")
  def helloWorld(): String = {
    "Hello world"
  }
}

