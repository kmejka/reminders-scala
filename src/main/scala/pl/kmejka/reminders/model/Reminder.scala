package pl.kmejka.reminders.model

import java.util.UUID

import com.fasterxml.jackson.annotation.JsonProperty

class Reminder (@JsonProperty("userId") val userId: Long,
                @JsonProperty("reminderId") val reminderId: String,
                @JsonProperty("title") val title: String,
                @JsonProperty("start") val start: String,
                @JsonProperty("end") val end: String,
                @JsonProperty("channel") val channel: String) {

  override def toString = s"Reminder(userId: $userId, reminderId: $reminderId, title: $title, start: $start, end: $end, channel: $channel)"
}

object Reminder {
  def apply(userId: Long, title: String, start: String, end: String, channel: String) = {
    val uuid = UUID.randomUUID.toString
    new Reminder(userId, uuid, title, start, end, channel)
  }
}
