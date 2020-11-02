package net.println.kotlinnew.chapter08.eg


/**
 * 泛型的使用
 */
typealias OnConfirm = () -> Unit
typealias OnCancel = () -> Unit

private val EmptyFunction = {}

open class Notification(
    val title: String,
    val content: String
)

class ConfirmNotification(
    title: String,
    content: String,
    val onConfirm: OnConfirm,
    val onCancel: OnCancel
) : Notification(title, content)


open class NotificationBuilderOld {
    protected var title: String = ""
    protected var content: String = ""

    fun title(title: String): NotificationBuilderOld {
        this.title = title
        // 返回this, 如果子类继承NotificationBuilderOld，那么子类调用title时，this 指的是子类，但是返回的是父类，所以调用不到子类自己的方法。
        // 用于优化，返回明确返回子类的类型
        return this
    }

    fun content(content: String): NotificationBuilderOld {
        this.content = content
        return this
    }

    open fun build() = Notification(this.title, this.content)
}


//
interface SelfType<Self> {
    // 不安全的
    val self: Self
        get() = this as Self
}

// 添加泛型约束
open class NotificationBuilder<Self : NotificationBuilder<Self>> : SelfType<Self> {
    protected var title: String = ""
    protected var content: String = ""

    fun title(title: String): Self {
        this.title = title
        return self
    }

    fun content(content: String): Self {
        this.content = content
        return self
    }

    open fun build() = Notification(this.title, this.content)
}

class ConfirmNotificationBuilder : NotificationBuilder<ConfirmNotificationBuilder>() {
    private var onConfirm: OnConfirm = EmptyFunction
    private var onCancel: OnCancel = EmptyFunction

    fun onConfirm(onConfirm: OnConfirm): ConfirmNotificationBuilder {
        this.onConfirm = onConfirm
        return this
    }

    fun onCancel(onCancel: OnCancel): ConfirmNotificationBuilder {
        this.onCancel = onCancel
        return this
    }

    override fun build() = ConfirmNotification(title, content, onConfirm, onCancel)
}

fun main() {
    ConfirmNotificationBuilder()
        .title("Hello")
        .onCancel {
            println("onCancel")
        }.content("World")
        .onConfirm {
            println("onConfirmed")
        }
        .build()
        .onConfirm()
}
