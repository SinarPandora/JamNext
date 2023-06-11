//noinspection ScalaUnusedSymbol
package jam.cq.protocol.event.base

/**
 * 基础请求事件（好友，群）
 *
 * Author: sinar 2023/6/11 23:35
 */
abstract class RequestEvent extends Event:
  val requestType: "friend" | "group"
