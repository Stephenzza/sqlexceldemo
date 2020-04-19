package com.sqlexcel.sqlexceldemo.Listener;

import java.util.ArrayList;
import java.util.List;

import com.sqlexcel.sqlexceldemo.entity.UploadData;
import com.sqlexcel.sqlexceldemo.repository.UploadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 模板的读取类
 *
 * @author Jiaju Zhuang
 */
// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
public class UploadDataListener extends AnalysisEventListener<UploadData> {


    @Autowired
    private UploadRepository uploadRepository;

    public UploadDataListener(UploadRepository uploadRepository) {
        this.uploadRepository = uploadRepository;
    }

    private static final Logger LOGGER =
            LoggerFactory.getLogger(com.sqlexcel.sqlexceldemo.Listener.UploadDataListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<UploadData> list = new ArrayList<UploadData>();


    @Override
    public void invoke(UploadData data, AnalysisContext context) {
        LOGGER.info("解析到一条数据:{}",JSON.toJSONString(data));
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */

    private List<UploadData> saveData() {

        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        uploadRepository.saveAll(list);
        LOGGER.info("存储数据库成功！");
        return list;
    }

}