package vip.aoba.tako.bot;

import net.mamoe.mirai.event.GlobalEventChannel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vip.aoba.tako.bot.listener.BotEventHandler;
import vip.aoba.tako.bot.listener.FriendEventHandler;
import vip.aoba.tako.bot.listener.GroupEventHandler;
import vip.aoba.tako.bot.listener.MessageEventHandler;
import vip.aoba.tako.properties.BotProperties;

/**
 * <h3>Bot 初始化方法</h3>
 * <p>项目启动后，用来自动登陆bot的方法</p>
 *
 * @author XSana
 */
@Component
public class BotInitialization implements CommandLineRunner {

    /**
     * 配置项
     */
    private final BotProperties botProperties;
    /**
     * 监听类
     */
    private final BotEventHandler botEventHandler;
    private final FriendEventHandler friendEventHandler;
    private final GroupEventHandler groupEventHandler;
    private final MessageEventHandler messageEventHandler;

    public BotInitialization(BotProperties botProperties, BotEventHandler botEventHandler, FriendEventHandler friendEventHandler, GroupEventHandler groupEventHandler, MessageEventHandler messageEventHandler) {
        this.botProperties = botProperties;
        this.botEventHandler = botEventHandler;
        this.friendEventHandler = friendEventHandler;
        this.groupEventHandler = groupEventHandler;
        this.messageEventHandler = messageEventHandler;
    }

    @Override
    public void run(String... args) throws Exception {
        // 注册监听
        GlobalEventChannel.INSTANCE.registerListenerHost(botEventHandler);
        GlobalEventChannel.INSTANCE.registerListenerHost(friendEventHandler);
        GlobalEventChannel.INSTANCE.registerListenerHost(groupEventHandler);
        GlobalEventChannel.INSTANCE.registerListenerHost(messageEventHandler);
        // 启动bot
        TakoBot.createBot(botProperties);
    }
}
