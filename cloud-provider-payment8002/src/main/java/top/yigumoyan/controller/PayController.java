package top.yigumoyan.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import top.yigumoyan.entities.Pay;
import top.yigumoyan.entities.PayDTO;
import top.yigumoyan.resp.ResultData;
import top.yigumoyan.service.PayService;

@RestController
@Slf4j
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay)
    {
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值: " + i);
    }

    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id)
    {
        int i = payService.delete(id);
        return ResultData.success(i);
    }

    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO)
    {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);

        int i = payService.update(pay);
        return ResultData.success("成功修改记录，返回值: " + i);
    }

    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public ResultData<Pay> getById(@PathVariable("id") Integer id)
    {
        System.out.println("id: " + id);
        if(id == -4) throw new RuntimeException("id不能为负数");

        //暂停62秒钟线程,故意写bug，测试出feign的默认调用超时时间
        // try { TimeUnit.SECONDS.sleep(62); } catch (InterruptedException e) { e.printStackTrace(); }

        Pay pay = payService.getPayById(id);

        return ResultData.success(pay);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/pay/get/info")
    public String getInfoByConsul(@Value("${yigumoyan.info}") String info)
    {
        return "consul端口号: " + port + "，info: " + info;
    }
}
