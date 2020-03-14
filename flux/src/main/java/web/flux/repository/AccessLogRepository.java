package web.flux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.flux.entity.AccessLog;

import java.math.BigInteger;

/**
 * @author z
 */
public interface AccessLogRepository extends JpaRepository<AccessLog, BigInteger> {
    public enum TYPE {
        /**
         * access
         */
        API,
        /**
         * request error
         */
        OTHER,
    }

    public enum STATE {
        /**
         * ok
         */
        OK {
            @Override
            public String toString() {
                return "ok";
            }
        },
        /**
         * error
         */
        ERROR {
            @Override
            public String toString() {
                return "error";
            }
        }
    }
}
