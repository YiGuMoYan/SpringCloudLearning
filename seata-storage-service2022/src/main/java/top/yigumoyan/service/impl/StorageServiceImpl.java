package top.yigumoyan.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.yigumoyan.mapper.StorageMapper;
import top.yigumoyan.service.StorageService;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    /**
     * 扣减库存
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId, count);
        log.info("------->storage-service中扣减库存结束");
    }
}