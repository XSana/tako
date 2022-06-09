package vip.aoba.tako.bot.listener;

import kotlin.coroutines.CoroutineContext;
import lombok.extern.slf4j.Slf4j;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FriendEventHandler extends SimpleListenerHost {

    /**
     * 好友昵称改变
     *
     * @param event FriendRemarkChangeEvent
     */
    @EventHandler
    public void onFriendRemarkChangeEvent(@NotNull FriendRemarkChangeEvent event) {

    }

    /**
     * 成功添加了一个新好友
     *
     * @param event FriendAddEvent
     */
    @EventHandler
    public void onFriendAddEvent(@NotNull FriendAddEvent event) {

    }

    /**
     * 好友已被删除
     *
     * @param event FriendDeleteEvent
     */
    @EventHandler
    public void onFriendDeleteEvent(@NotNull FriendDeleteEvent event) {

    }

    /**
     * 一个账号请求添加机器人为好友
     *
     * @param event NewFriendRequestEvent
     */
    @EventHandler
    public void onNewFriendRequestEvent(@NotNull NewFriendRequestEvent event) {

    }

    /**
     * 好友头像改变
     *
     * @param event FriendAvatarChangedEvent
     */
    @EventHandler
    public void onFriendAvatarChangedEvent(@NotNull FriendAvatarChangedEvent event) {

    }

    /**
     * 好友昵称改变
     *
     * @param event FriendNickChangedEvent
     */
    @EventHandler
    public void onFriendNickChangedEvent(@NotNull FriendNickChangedEvent event) {

    }

    /**
     * 好友输入状态改变
     *
     * @param event FriendInputStatusChangedEvent
     */
    @EventHandler
    public void onFriendInputStatusChangedEvent(@NotNull FriendInputStatusChangedEvent event) {

    }

    @Override
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        // 处理事件处理时抛出的异常
    }
}
