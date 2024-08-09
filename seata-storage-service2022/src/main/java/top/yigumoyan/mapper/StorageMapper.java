package top.yigumoyan.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import top.yigumoyan.entities.Storage;

public interface StorageMapper extends Mapper<Storage> {
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}