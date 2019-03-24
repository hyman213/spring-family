package hyman.spring.data.mybatisdemo.mapper;

import hyman.spring.data.mybatisdemo.model.Coffee;
import org.apache.ibatis.annotations.*;

/**
 * @author: huhan
 * @date: 19/03/23 19:30
 */
@Mapper
public interface CoffeeMapper {

    @Insert("insert into t_coffee(name, price, create_time, update_time) " +
            "values (#{name}, #{price}, now(), now())")
    @Options(useGeneratedKeys = true)
    Long save(Coffee coffee);

    @Select("select * from t_coffee where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
            //map-underscore-to-camel-case = true 可以实现一样的效果
    })
    Coffee findById(@Param("id") Long id);
}
