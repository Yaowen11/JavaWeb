package web.flux.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author z
 */
@Entity
@Data
public class ProductSku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Integer stock;

    @Column
    private BigDecimal price;

    @Column
    private Integer storeId;

    @Column
    private BigInteger productId;

    @Column
    private Integer depotId;

    @Column
    private Timestamp createdAt;

    @Column
    private Timestamp updatedAt;
}
