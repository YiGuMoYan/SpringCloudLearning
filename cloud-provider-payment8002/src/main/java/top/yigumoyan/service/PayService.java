package top.yigumoyan.service;

import top.yigumoyan.entities.Pay;

import java.util.List;

public interface PayService {
    public int add(Pay pay);
    public int delete(Integer id);
    public int update(Pay pay);

    public Pay getPayById(Integer id);
    public List<Pay> getAll();
}
