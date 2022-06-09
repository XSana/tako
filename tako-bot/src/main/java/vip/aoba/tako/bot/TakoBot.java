package vip.aoba.tako.bot;

import lombok.extern.slf4j.Slf4j;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.utils.BotConfiguration;
import vip.aoba.tako.properties.BotProperties;

import java.io.File;


/**
 * 机器人方法类
 *
 * @author XSana
 */
@Slf4j
public class TakoBot {

    private static Bot bot;

    public static Bot getBot() {
        return bot;
    }

    /**
     * 创建一个新Bot实例并登陆
     *
     * @param botProperties bot登陆信息
     * @return Bot实例
     */
    public static Bot createBot(BotProperties botProperties) {
        // 旧bot存在则关闭
        try {
            if (bot != null) bot.close();
        } catch (Exception e) {
            log.warn("旧Bot关闭出错", e);
        }

        // 创建工作目录，创建失败则使用默认目录
        String path = "data";
        if (!createBotDataDir(path)) path = "data";

        // 创建实例
        String finalPath = path;
        bot = BotFactory.INSTANCE.newBot(botProperties.getQq(), botProperties.getPassword(), new BotConfiguration() {
            {
                // 使用默认心跳策略，如果出现问题这里切换
                setHeartbeatStrategy(HeartbeatStrategy.STAT_HB);
                // 设置工作目录
                setWorkingDir(new File(finalPath));
                // 覆盖默认设备信息,工作目录下
                fileBasedDeviceInfo("deviceInfo.json");
                // 标识登录
                setProtocol(botProperties.getType());
            }
        });
        // 登陆bot
        new Thread(() -> {
            bot.login();
        }).start();
        return bot;
    }

    /**
     * 创建bot工作目录
     *
     * @param path 路径
     * @return 创建结果 ture/false
     */
    private static boolean createBotDataDir(String path) {
        var dataDir = new File(path);
        if (!dataDir.exists() && !dataDir.isDirectory()) {
            if (dataDir.mkdirs()) {
                log.info("创建数据目录：" + dataDir.getPath());
            } else {
                log.warn("数据目录创建失败，将使用默认目录.");
                return false;
            }
        }
        return true;
    }
}
