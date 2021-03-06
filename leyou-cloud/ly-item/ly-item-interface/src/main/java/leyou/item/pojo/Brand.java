package leyou.item.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author bystander
 * @date 2018/9/15
 */
@Table(name = "tb_brand")
@Data
public class Brand {

    @Id
    @KeySql(useGeneratedKeys = true)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private Character letter;
}