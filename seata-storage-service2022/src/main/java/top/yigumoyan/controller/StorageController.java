package top.yigumoyan.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yigumoyan.resp.ResultData;
import top.yigumoyan.service.StorageService;

@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/storage/decrease")
    public ResultData decrease(Long productId, Integer count) {

        storageService.decrease(productId, count);
        return ResultData.success("扣减库存成功!");
    }
}
