package pl.kmejka.reminders

import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.massrelevance.dropwizard.ScalaApplication
import com.massrelevance.dropwizard.scala.inject.ScalaCollectionsQueryParamInjectableProvider
import io.dropwizard.setup.{Bootstrap, Environment}
import pl.kmejka.reminders.configuration.RemindersConfiguration
import pl.kmejka.reminders.data.RemindersDAO
import pl.kmejka.reminders.resources.RemindersResource


object RemindersService extends ScalaApplication[RemindersConfiguration] {

  override def getName = "RemindersService"

  override def initialize(bootstrap: Bootstrap[RemindersConfiguration]): Unit = {
    bootstrap.getObjectMapper.registerModule(new DefaultScalaModule())
  }

  override def run(conf: RemindersConfiguration, env: Environment): Unit = {
    env.jersey.getResourceConfig.getClasses.add(classOf[ScalaCollectionsQueryParamInjectableProvider])
    env.jersey().register(new RemindersResource(new RemindersDAO))
  }
}
