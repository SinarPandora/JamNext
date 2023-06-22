//noinspection ScalaUnusedSymbol
package jam.cq.protocol.event.notice

import jam.cq.protocol.event.base.Event

/**
 * 基础通知消息
 *
 * Author: sinar 2023/6/11 23:45
 */
abstract class NoticeEvent extends Event:
  def noticeType: NoticeEvent.NoticeType

object NoticeEvent:
  enum NoticeType(val raw: String):
    case GroupUpload extends NoticeType("group_upload")
    case GroupAdmin extends NoticeType("group_admin")
    case GroupDecrease extends NoticeType("group_decrease")
    case GroupIncrease extends NoticeType("group_increase")
    case GroupBan extends NoticeType("group_ban")
    case FriendAdd extends NoticeType("friend_add")
    case GroupRecall extends NoticeType("group_recall")
    case FriendRecall extends NoticeType("friend_recall")
    case GroupCard extends NoticeType("group_card")
    case OfflineFile extends NoticeType("offline_file")
    case ClientStatus extends NoticeType("client_status")
    case Essence extends NoticeType("essence")
    case Notify extends NoticeType("notify")
