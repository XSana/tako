package vip.aoba.tako.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import vip.aoba.tako.po.base.BasePO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Bot事件日志
 *
 * @author XSana
 */
@Entity
@Table(name = "bot_event_log")
@Getter
@Setter
@ToString
public class BotEventLog extends BasePO  {

    /**
     * QQ
     */
    @Column(name = "qq", nullable = false)
    private Long qq;

    /**
     * 类型
     * <p>
     * 0：主动登陆
     * 1：主动离线
     * 2：被挤下线
     * 3：被服务器断开或因网络问题而掉线
     * 4：服务器主动要求更换另一个服务器
     * 5：未知原因离线
     * 6：重新登录
     * 7：头像改变
     * 8：昵称改变
     */
    @Column(name = "type", nullable = false)
    private Integer type;
}
