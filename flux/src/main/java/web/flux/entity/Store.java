package web.flux.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author z
 */
@Entity
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String companyName;

    @Column
    private Integer state;

    @Column
    private Timestamp createdAt;

    @Column
    private Timestamp deletedAt;

}
