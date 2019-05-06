package cn.xxx.rpms.service.impl;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.basic.service.impl.BaseServiceImpl;
import cn.xxx.basic.utils.PageList;
import cn.xxx.rpms.domain.Opt;
import cn.xxx.rpms.mapper.OptMapper;
import cn.xxx.rpms.query.OptQuery;
import cn.xxx.rpms.service.IOptService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OptServiceImpl extends BaseServiceImpl<Opt> implements IOptService {
    @Autowired
    private OptMapper optMapper;
    @Override
    protected BaseMapper<Opt> getMapper() {
        return optMapper;
    }

    @Override
    public PageList<Opt> loadDataByQueryLimt(OptQuery optQuery) throws Exception {

        Page<Opt> objects = PageHelper.startPage(optQuery.getPage(), optQuery.getLimit());
        //拿到分页后的总数据
        Date endDate = optQuery.getEndDate();
        if(endDate!=null&&!"".equals(endDate)){
            Calendar c = Calendar.getInstance();
            c.setTime(endDate);
            int day=c.get(Calendar.DATE);
            c.set(Calendar.DATE,day+1);
            System.out.println();
            Date afterTime = c.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
            String format = sdf.format(c.getTime());
            Date parse = sdf.parse(format);
            optQuery.setEndDate(parse);
        }


        optMapper.loadDataByQueryLimt(optQuery);

        return new PageList<>(objects.getTotal(), objects.getResult());
    }
}
