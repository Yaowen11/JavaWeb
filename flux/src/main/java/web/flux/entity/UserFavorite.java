package web.flux.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author z
 */
@Entity
@Data
public class UserFavorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column
    private BigInteger userId;

    @Column
    private BigInteger productSkuId;

    @Column
    private Timestamp createdAt;

    @Column
    private Timestamp deletedAt;

}
