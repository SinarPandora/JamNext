//noinspection ScalaUnusedSymbol
package jam.cq.protocol.event.base

import jam.cq.protocol.event.base.Event.PostType

/**
 * 事件基础
 *
 * Author: sinar 2023/6/11 22:48
 */
abstract class Event:
  def time: Long
  def selfId: Long
  def postType: Event.PostType

object Event:
  /**
   * 上报类型
   *
   * @param raw
   *   类型原始字符串
   */
  enum PostType(val raw: String):
    case Message extends PostType("message")
    case MessageSent extends PostType("message_sent")
    case Request extends PostType("request")
    case Notice extends PostType("notice")
    case MetaEvent extends PostType("meta_event")
