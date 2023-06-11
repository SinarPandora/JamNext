//noinspection ScalaUnusedSymbol
package jam.cq.protocol.event.base

/**
 * 基础元数据事件
 *
 * Author: sinar 2023/6/11 23:49
 */
abstract class MetaEvent extends Event:
  def metaEventType: "lifecycle" | "heartbeat"
