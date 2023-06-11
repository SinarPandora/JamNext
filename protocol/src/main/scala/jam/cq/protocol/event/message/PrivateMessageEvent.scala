//noinspection ScalaUnusedSymbol
package jam.cq.protocol.event.message

import jam.cq.protocol.event.base.Event

/**
 * 私聊消息事件
 *
 * Author: sinar 2023/6/11 23:53
 */
case class PrivateMessageEvent(
    time: Long,
    selfId: Long,
    postType: Event.PostType,
    messageType: "private",
    subType: MessageEvent.SubType,
    messageId: Int,
    userId: Long,
    message: String,
    rawMessage: String,
    font: Int,
    sender: MessageEvent.Sender,
    targetId: Long,
    /**
     * 临时会话来源
     */
    tempSource: Int
) extends MessageEvent
