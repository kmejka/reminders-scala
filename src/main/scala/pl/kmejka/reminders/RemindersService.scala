package pl.kmejka.reminders

import com.massrelevance.dropwizard.ScalaApplication
import io.dropwizard.setup.{Bootstrap, Environment}
import pl.kmejka.reminders.configuration.RemindersConfiguration
import pl.kmejka.reminders.resources.RemindersResource


object RemindersService extends ScalaApplication[RemindersConfiguration] {

  override def getName = "RemindersService"

  override def initialize(bootstrap: Bootstrap[RemindersConfiguration]): Unit = {

  }

  override def run(conf: RemindersConfiguration, env: Environment): Unit = {
    env.jersey().register(new RemindersResource)
//    env.jersey().disable()
  }
}
