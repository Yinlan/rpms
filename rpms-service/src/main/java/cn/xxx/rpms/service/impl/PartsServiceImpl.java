package cn.xxx.rpms.service.impl;

import cn.xxx.basic.mapper.BaseMapper;
import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.service.IBaseService;
import cn.xxx.basic.service.impl.BaseServiceImpl;
import cn.xxx.basic.utils.LuceneUtil;
import cn.xxx.basic.utils.PageList;
import cn.xxx.rpms.domain.Parts;
import cn.xxx.rpms.mapper.PartsMapper;
import cn.xxx.rpms.query.PartsQuery;
import cn.xxx.rpms.service.IPartsService;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.highlight.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static cn.xxx.basic.utils.LuceneUtil.createQuery;

@Service
public class PartsServiceImpl extends BaseServiceImpl<Parts> implements IPartsService {
    @Autowired
    private PartsMapper partsMapper;
    @Override
    protected BaseMapper<Parts> getMapper() {
        return partsMapper;
    }


    @Override
    public Boolean checkNameQuery(PartsQuery partsQuery)  {

        Parts partsCheck = partsMapper.checkNameQuery(partsQuery);

        //如果未查询到 直接返回true可以使用
        if(partsCheck==null){
            return true;
        }
        //有id为修改
        if(partsQuery.getPid()!=null&&!"".equals(partsQuery.getPid())){
            Parts parts1 = partsMapper.selectByPrimaryKey(partsQuery.getPid());
            System.out.println(parts1);
            //如果修改的数据与 本数据同名
            if(parts1.getPartsname().equals(partsCheck.getPartsname())){
                System.out.println(66666);
                return true;
            }
            return false;
        }

        return false;
    }
    //创建索引库
    @Override
    public void updateIndex() {

       //查收所有数据到日志库
        List<Parts> partsList = partsMapper.selectAll();
        //写索引库
        for (Parts parts : partsList) {
            Document document = new Document();
            document.add(new TextField("pid",String.valueOf(parts.getPid()), Field.Store.YES));
            document.add(new TextField("partsname",String.valueOf(parts.getPartsname()), Field.Store.YES));
            document.add(new TextField("num",String.valueOf(parts.getNum()), Field.Store.YES));
            document.add(new TextField("context",String.valueOf(parts.getContext()), Field.Store.YES));
            document.add(new TextField("createtime",String.valueOf(parts.getCreatetime()), Field.Store.YES));
            document.add(new TextField("price",String.valueOf(parts.getPrice()), Field.Store.YES));
            document.add(new TextField("warnum",String.valueOf(parts.getWarnnum()), Field.Store.YES));
            LuceneUtil.addIndex(document);
        }
        //关闭资源
//        LuceneUtil.closeAll();
    }

    @Override
    public PageList<Parts> getByQuery(PartsQuery partsQuery) throws Exception{
//        IndexReader indexReader = LuceneUtil.getIndexReader();

//        LuceneUtil.deleteAllIndex();
//        updateIndex();

        PageList<Parts> pageList = new PageList<>();
        //查询字段 在创建的索引库里面的列
        String[] fields = {"partsname","context"};
        //关键字 比如 function字段里面 Login
        String q = partsQuery.getPartsname();
        //设置条数
        pageList.setTotal(LuceneUtil.totalHits(fields,q));

        //命中的document
        List<Document> hitDocuments = LuceneUtil.getHitDocuments(fields, q, partsQuery.getPage(), partsQuery.getLimit());

        List<Parts> logList = new ArrayList<>();

        Query query= createQuery(fields,q);
        Highlighter hightLiaght = LuceneUtil.getHightLiaght(query);

        for (Document hitdocument : hitDocuments) {
            //把每一个doucment转换成SystemLog
            Parts part = new Parts();

            for(int m=0;m<fields.length;m++){
                String s = hitdocument.get(fields[m]);
                if(s != null) {
                    Analyzer analyzer1 = LuceneUtil.getAnalyzer();
                    TokenStream tokenStream = analyzer1.tokenStream(s, new StringReader(s));
                    //取高亮后的content字段的值
                    String summary = null;
                    if("partsname".equals(fields[m])){
                        try {
                            summary = hightLiaght.getBestFragment(tokenStream, s);
                            part.setPartsname(summary);
                        } catch (InvalidTokenOffsetsException e) {
                            e.printStackTrace();
                        }

                    }
                    if("context".equals(fields[m])){
                        try {
                            summary = hightLiaght.getBestFragment(tokenStream, s);
                            part.setContext(summary);
                        } catch (InvalidTokenOffsetsException e) {
                            e.printStackTrace();
                        }

                    }



                }
            }

            part.setPid(Long.valueOf(hitdocument.get("pid")));
//            part.setPartsname(hitdocument.get("partsname"));
            part.setNum(Integer.valueOf(hitdocument.get("num")));
//            part.setContext(hitdocument.get("context"));
            part.setCreatetime(new Date((hitdocument.get("createtime"))));
            part.setPrice(Long.valueOf(hitdocument.get("price")));
            part.setWarnnum(Integer.valueOf(hitdocument.get("warnum")));
            logList.add(part);
        }
        pageList.setRows(logList);


        //高亮显示
//        QueryScorer queryScorer = new QueryScorer(q);
        //1:创建一个IndexSearcher:从哪里读取索引
//        IndexSearcher indexSearcher = LuceneUtil.getIndexSearcher();
//        //词法分析器
//        Analyzer analyzer = new SimpleAnalyzer();
//        QueryParser queryParser = new QueryParser(, analyzer);
//        String queryCondition = "content:hello";//查询条件
//        Query query = queryParser.parse(queryCondition);


        return pageList;
    }
}
