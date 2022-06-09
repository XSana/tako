package vip.aoba.tako.bot.listener;

import kotlin.coroutines.CoroutineContext;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class GroupEventHandler extends SimpleListenerHost {

    /**
     * 机器人被踢出群或在其他客户端主动退出一个群
     *
     * @param event BotLeaveEvent
     * @see BotLeaveEvent.Active
     * @see BotLeaveEvent.Kick
     */
    @EventHandler
    public void onBotLeaveEvent(@NotNull BotLeaveEvent event) {

    }

    /**
     * 机器人在群里的权限被改变
     *
     * @param event BotGroupPermissionChangeEvent
     */
    @EventHandler
    public void onBotGroupPermissionChangeEvent(@NotNull BotGroupPermissionChangeEvent event) {

    }

    /**
     * 机器人被禁言
     *
     * @param event BotMuteEvent
     */
    @EventHandler
    public void onBotMuteEvent(@NotNull BotMuteEvent event) {

    }

    /**
     * 机器人被取消禁言
     *
     * @param event BotUnmuteEvent
     */
    @EventHandler
    public void onBotUnmuteEvent(@NotNull BotUnmuteEvent event) {

    }

    /**
     * 机器人成功加入了一个新群
     *
     * @param event BotJoinGroupEvent
     */
    @EventHandler
    public void onBotJoinGroupEvent(@NotNull BotJoinGroupEvent event) {

    }

    @Override
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        // 处理事件处理时抛出的异常
    }
}
