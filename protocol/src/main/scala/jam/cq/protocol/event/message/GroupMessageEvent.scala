package jam.cq.protocol.event.message

import jam.cq.protocol.event.base.Event
import jam.cq.protocol.event.message.GroupMessageEvent.Anonymous

/**
 * 群消息事件
 *
 * Author: sinar 2023/6/12 19:42
 */
case class GroupMessageEvent(
    time: Long,
    selfId: Long,
    postType: Event.PostType,
    messageType: "group",
    subType: MessageEvent.SubType,
    messageId: Int,
    userId: Long,
    message: String,
    rawMessage: String,
    font: Int,
    sender: MessageEvent.Sender,
    groupId: Long,
    anonymous: GroupMessageEvent.Anonymous
) extends MessageEvent

object GroupMessageEvent:
  case class Anonymous(id: Long, name: String, flag: String)
