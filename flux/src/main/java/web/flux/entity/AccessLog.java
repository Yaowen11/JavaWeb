package web.flux.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author z
 */
@Entity
@Data
public class AccessLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Column
    private String uri;
    @Column
    private Integer type;
    @Column
    private String method;
    @Column
    private Long clientIp;
    @Column
    private Integer httpCode;
    @Column
    private Long useTime;
    @Column
    private String errors;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd H:i:s")
    private Timestamp recordAt;
}
