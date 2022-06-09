package vip.aoba.tako.properties;

import lombok.Data;
import net.mamoe.mirai.utils.BotConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author XSana
 */
@Component
@ConfigurationProperties(
        prefix = "bot"
)
@Data
public class BotProperties {

    /**
     * 机器人登录使用的QQ号
     */
    private Long qq;

    /**
     * 机器人登录使用的密码
     */
    private String password;

    /**
     * 设备类型，默认 android_phone
     *
     * <ul>
     *     <li>安卓手机：android_phone</li>
     *     <li>安卓平板：android_pad</li>
     *     <li>安卓手表：android_watch</li>
     * </ul>
     */
    private BotConfiguration.MiraiProtocol type = BotConfiguration.MiraiProtocol.ANDROID_PHONE;
}
