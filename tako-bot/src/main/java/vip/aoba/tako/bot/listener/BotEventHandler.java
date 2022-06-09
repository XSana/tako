package vip.aoba.tako.bot.listener;

import kotlin.coroutines.CoroutineContext;
import lombok.extern.slf4j.Slf4j;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import vip.aoba.tako.po.BotEventLog;
import vip.aoba.tako.repository.BotEventLogRepository;

/**
 * Bot事件
 *
 * @author XSana
 */
@Component
@Slf4j
public class BotEventHandler extends SimpleListenerHost {

    private final BotEventLogRepository botEventLogRepository;

    public BotEventHandler(BotEventLogRepository botEventLogRepository) {
        this.botEventLogRepository = botEventLogRepository;
    }

    /**
     * Bot 登录完成
     *
     * @param event BotOnlineEvent
     */
    @EventHandler
    public void onBotOnlineEvent(@NotNull BotOnlineEvent event) {
        var qq = event.getBot().getId();
        log.info("Bot {} 登录完成", qq);

        var eventLog = new BotEventLog();
        eventLog.setQq(qq);
        eventLog.setType(0);
        botEventLogRepository.save(eventLog);
    }

    /**
     * Bot 离线
     *
     * @param event BotOfflineEvent
     * @see BotOfflineEvent.Active 主动离线
     * @see BotOfflineEvent.Force 被挤下线
     * @see BotOfflineEvent.Dropped 因网络问题而掉线
     * @see BotOfflineEvent.RequireReconnect 服务器主动要求更换另一个服务器
     */
    @EventHandler
    public void onBotOfflineEvent(@NotNull BotOfflineEvent event) {
        var qq = event.getBot().getId();

        var eventLog = new BotEventLog();
        eventLog.setQq(qq);
        if (event instanceof BotOfflineEvent.Active) {
            log.info("Bot {} 主动离线", qq);
            eventLog.setType(1);
        } else if (event instanceof BotOfflineEvent.Force) {
            log.info("Bot {} 被挤下线", qq);
            eventLog.setType(2);
        } else if (event instanceof BotOfflineEvent.Dropped) {
            log.info("Bot {} 因网络问题而掉线", qq);
            eventLog.setType(3);
        } else if (event instanceof BotOfflineEvent.RequireReconnect) {
            log.info("Bot {} 服务器主动要求更换另一个服务器", qq);
            eventLog.setType(4);
        } else {
            log.info("Bot {} 未知原因离线", qq);
            eventLog.setType(5);
        }
        botEventLogRepository.save(eventLog);
    }

    /**
     * Bot 重新登录
     *
     * @param event BotReloginEvent
     */
    @EventHandler
    public void onBotReLoginEvent(@NotNull BotReloginEvent event) {
        var qq = event.getBot().getId();
        log.info("Bot {} 重新登录", qq);

        var eventLog = new BotEventLog();
        eventLog.setQq(qq);
        eventLog.setType(6);
        botEventLogRepository.save(eventLog);
    }

    /**
     * Bot 头像改变
     *
     * @param event BotAvatarChangedEvent
     */
    @EventHandler
    public void onBotAvatarChangedEvent(@NotNull BotAvatarChangedEvent event) {
        var qq = event.getBot().getId();
        log.info("Bot {} 头像改变，新头像URL: {}", qq, event.getBot().getAvatarUrl());

        var eventLog = new BotEventLog();
        eventLog.setQq(qq);
        eventLog.setType(7);
        botEventLogRepository.save(eventLog);
    }

    /**
     * Bot 昵称改变
     *
     * @param event BotNickChangedEvent
     */
    @EventHandler
    public void onBotNickChangedEvent(@NotNull BotNickChangedEvent event) {
        var qq = event.getBot().getId();
        log.info("Bot {} 昵称改变，新昵称为: {}", qq, event.getBot().getNick());

        var eventLog = new BotEventLog();
        eventLog.setQq(qq);
        eventLog.setType(8);
        botEventLogRepository.save(eventLog);
    }

    @Override
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        // 处理事件处理时抛出的异常
        log.error("BotEvent出现异常", exception);
    }
}
