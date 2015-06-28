package pl.kmejka.reminders.model

import com.fasterxml.jackson.annotation.JsonProperty

class ReminderRequest (@JsonProperty("title") val title: String) {

  override def toString = s"ReminderRequest(title: $title)"
}

