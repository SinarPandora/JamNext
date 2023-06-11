//noinspection ScalaUnusedSymbol
package jam.cq.protocol.event.message

import jam.cq.protocol.event.base.Event

/**
 * 基础消息事件
 *
 * Author: sinar 2023/6/11 23:12
 */
abstract class MessageEvent extends Event:
  def messageType: "private" | "group"
  def subType: MessageEvent.SubType
  def messageId: Int
  def userId: Long
  def message: String
  def rawMessage: String
  def font: Int
  def sender: MessageEvent.Sender

object MessageEvent:
  enum SubType(val raw: String):
    case Friend extends SubType("friend")
    case Normal extends SubType("normal")
    case Anonymous extends SubType("anonymous")
    case GroupSelf extends SubType("group_self")
    case Group extends SubType("group")
    case Notice extends SubType("notice")

  abstract class Sender:
    def userId: Long
    def nickname: String
    def sex: "male" | "female" | "unknown"
    def age: Int

  case class PrivateSender(
      userId: Long,
      nickname: String,
      sex: "male" | "female" | "unknown",
      age: Int
  ) extends Sender

  case class GroupTempSender(
      userId: Long,
      nickname: String,
      sex: "male" | "female" | "unknown",
      age: Int,
      groupId: Long
  ) extends Sender

  case class GroupSender(
      userId: Long,
      nickname: String,
      sex: "male" | "female" | "unknown",
      age: Int,
      card: String,
      area: String,
      level: String,
      role: "owner" | "admin" | "member",
      title: String
  ) extends Sender
