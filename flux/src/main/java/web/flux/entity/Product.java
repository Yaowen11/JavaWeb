package web.flux.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author z
 */
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String image;

    @Column
    private Integer onSale;

    @Column Integer soldCount;

    @Column
    private Integer category;

    @Column
    private BigDecimal price;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd H:i:s")
    private Timestamp createdAt;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd H:i:s")
    private Timestamp updatedAt;

}
