# JamNext(4)

> 下一代 Jam（果酱，基于 GoCQHTTP 协议的聊天机器人），使用 Scala 主流函数式技术栈 ZIO 对 Jam3 进行重写

## Modules 模块

### Protocol

GoCQHTTP 协议定义层，使用纯 Scala 实现

### CQServer

GoCQHTTP 协议运行时，提供与 GoCQHTTP 客户端直接交互的能力

### SXDLParser

SXDL（建议扩展定义语言）解析器，用以解析果酱的行为定义脚本

### Jam

果酱本体，基于 GoCQHTTP 协议，可动态更改行为的聊天机器人

## Installation 安装

### Prepare 预准备

1. 果酱是一个 Java 程序，因此您需要先安装 JRE/JDK。您可以在 [Download Java (bell-sw.com)](https://bell-sw.com/pages/downloads/) 或其他 Java 发行版主页下载到它。推荐版本：17.x
2. 果酱需要 GoCQHTTP 客户端来与 QQ 服务器进行交互，您可以在 [Releases · Mrs4s/go-cqhttp (github.com)](https://github.com/Mrs4s/go-cqhttp/releases) 获取它的最新版本

### Deploy 部署

TODO // 当发行第一个版本后，此处会被更新

## Roadmap 路线图

目前仍在起步阶段，当前的目标是将 Jam3 的全部功能使用新技术重新实现
