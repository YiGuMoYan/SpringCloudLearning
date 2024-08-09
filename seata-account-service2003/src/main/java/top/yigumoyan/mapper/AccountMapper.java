package top.yigumoyan.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import top.yigumoyan.entities.Account;

public interface AccountMapper extends Mapper<Account> {
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}