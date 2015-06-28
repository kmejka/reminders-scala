package pl.kmejka.reminders.model

import com.fasterxml.jackson.annotation.JsonProperty

class Reminder (@JsonProperty("userId") val userId: Long,
                @JsonProperty("title") val title: String,
                @JsonProperty("start") val start: String,
                @JsonProperty("end") val end: String,
                @JsonProperty("channel") val channel: String) {

  override def toString = s"Reminder(userId: $userId, title: $title, start: $start, end: $end, channel: $channel)"
}

object Reminder {
  def apply(userId: Long, title: String): Reminder = new Reminder(userId, title, null, null, null)
}