package vip.aoba.tako.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import vip.aoba.tako.po.BotEventLog;

/**
 * @author XSana
 */
@Repository
public interface BotEventLogRepository extends JpaRepository<BotEventLog, Long> {

}
