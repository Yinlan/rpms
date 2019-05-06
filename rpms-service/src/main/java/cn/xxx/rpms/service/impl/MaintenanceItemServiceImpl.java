package cn.xxx.rpms.service.impl;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.basic.service.impl.BaseServiceImpl;
import cn.xxx.rpms.domain.Maintenance;
import cn.xxx.rpms.domain.MaintenanceItem;
import cn.xxx.rpms.domain.Opt;
import cn.xxx.rpms.domain.Parts;
import cn.xxx.rpms.mapper.MaintenanceItemMapper;
import cn.xxx.rpms.mapper.OptMapper;
import cn.xxx.rpms.mapper.PartsMapper;
import cn.xxx.rpms.service.IMaintenanceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MaintenanceItemServiceImpl extends BaseServiceImpl<MaintenanceItem> implements IMaintenanceItemService {
    @Autowired
    private MaintenanceItemMapper maintenanceItemMapper;
    @Autowired
    private PartsMapper partsMapper;
    @Autowired
    private OptMapper optMapper;
    @Override
    protected BaseMapper<MaintenanceItem> getMapper() {
        return maintenanceItemMapper;
    }

    @Override
    public void delete(Long id) {
        MaintenanceItem maintenanceItem = maintenanceItemMapper.selectByPrimaryKey(id);
        //将零件清空
        maintenanceItem.setParts(null);

        maintenanceItemMapper.deleteByPrimaryKey(id);

    }
    @Override
    public void addItem(MaintenanceItem maintenanceItem) throws Exception{
        //拿到维修零件
        Long pid = maintenanceItem.getPid();
        Integer partNum = maintenanceItem.getNum();

        Parts parts = partsMapper.selectByPrimaryKey(pid);
        Integer stockNum = parts.getNum();
        if(stockNum<partNum){

                throw  new Exception("库存不足，请联系管理员");

        }else{
            stockNum=stockNum-partNum;
        }
        parts.setNum(stockNum);
        maintenanceItem.setParts(parts);
        partsMapper.updateByPrimaryKey(parts);
        //配件价格
        BigDecimal amt1 = maintenanceItem.getAmt1();
        //配件数量
        Integer num = maintenanceItem.getNum();
        BigDecimal multiply = amt1.multiply(BigDecimal.valueOf(num));
        //工时费
        BigDecimal amt2 = maintenanceItem.getAmt2();
        BigDecimal add = multiply.add(amt2);
        maintenanceItem.setTotalamt(add);

        maintenanceItemMapper.insert(maintenanceItem);
    }
    @Override
    public void updateItem(MaintenanceItem maintenanceItem) throws Exception {
        //拿到维修零件
        Long pid = maintenanceItem.getPid();
        //查询数据库配件 库存数量
        Parts parts = partsMapper.selectByPrimaryKey(pid);
        Integer numInParts = parts.getNum();
        //根据id查询明细单原来里面的数量
        MaintenanceItem maintenanceItem1 = maintenanceItemMapper.selectByPrimaryKey(maintenanceItem.getItemid());
        Integer numInItem = maintenanceItem1.getNum();
        //将原来的数量还给配件
        numInParts+=numInItem;
        parts.setNum(numInParts);
        partsMapper.updateByPrimaryKey(parts);

        //拿到维修零件
//        Long pid = maintenanceItem.getPid();
        Integer partNum = maintenanceItem.getNum();

        Parts partsInUpdate = partsMapper.selectByPrimaryKey(pid);
        Integer stockNum = partsInUpdate.getNum();
        if(stockNum<partNum){

            throw  new Exception("库存不足，请联系管理员");

        }else{
            stockNum=stockNum-partNum;
        }
        partsInUpdate.setNum(stockNum);
        maintenanceItem.setParts(partsInUpdate);
        partsMapper.updateByPrimaryKey(partsInUpdate);



        maintenanceItem.setParts(parts);
        //配件价格
        BigDecimal amt1 = maintenanceItem.getAmt1();
        //配件数量
        Integer num = maintenanceItem.getNum();
        BigDecimal multiply = amt1.multiply(BigDecimal.valueOf(num));
        //工时费
        BigDecimal amt2 = maintenanceItem.getAmt2();
        BigDecimal add = multiply.add(amt2);
        maintenanceItem.setTotalamt(add);

        maintenanceItemMapper.updateByPrimaryKey(maintenanceItem);
    }
}
