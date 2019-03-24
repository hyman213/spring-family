package hyman.spring.jpa.spingbucks.model;

import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 咖啡实体
 *
 * @author: huhan
 * @date: 2019/3/4 22:27
 */
@Entity
@Table(name = "t_coffee")
@Builder
@Data
@ToString(callSuper = true) // 如果不加callsuper，toString不会有父类的属性
@NoArgsConstructor
@AllArgsConstructor
public class Coffee extends BaseEntity implements Serializable {

    private String name;

    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyMinorAmount",
            parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")})
    private Money price;

}
