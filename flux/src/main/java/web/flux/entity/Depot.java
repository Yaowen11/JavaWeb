package web.flux.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author z
 */
@Entity
@Data
public class Depot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column
    private String country;

    @Column
    private String province;

    @Column
    private String city;

    @Column
    private String area;

    @Column
    private Integer category;

    @Column
    private String address;

    @Column
    private String description;

    @Column
    private String zipCode;

    @Column
    private Date usedAt;

    @Column
    private Integer state;

    @Column
    private Timestamp timestamp;
}
