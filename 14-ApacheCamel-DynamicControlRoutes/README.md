# 动态控制Apache Camel路由

在了解动态控制 Apache Camel 路由之前，首先要了解两个细节，这有助于更好地使用、管理路由。

## 1.设置路由ID
    通过路由ID，可以动态的控制路由启动与关闭。
    有助于在日志中更快的查找问题。
    如果应用程序庞大，可以将路由ID，注册至ZooKeeper或其他管理平台，以此更好地管理

    使用方式:
        Java DSL:
            from("xxx").routeId("xxxID").process(...).to(...);

        XML DSL:
            <camelContext id="CamelContextID" xmlns="http://camel.apache.org/schema/spring">
                <route id="xxxID">
                    <from uri="xxx"/>
                    <process ref="..."/>
                    <to uri="..."/>
                </route>
            </camelContext>

## 2.禁止自动启动
    一般情况，将路由添加到CamelContext中之后，随着camelContext的启动，它会自动启动路由。
    既然咱们想动态控制，那就先将其设置为'禁止自动启动'

    使用方式:
        Java DSL:
            from("xxx").routeId("xxxID").autoStartup(false).to(...);

        XML DSL:
            <camelContext id="CamelContextID" xmlns="http://camel.apache.org/schema/spring">
                <route id="xxxID" autoStartup="false">
                    <from uri="..."/>
                    <to uri="..."/>
                </route>
            </camelContext>

