package com.liuyi;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 测试实体类
 * Created by looye on 2017/11/12.
 */
public class Demo {
    private int id;
    private String name;

    /**
     * 不需要序列换的参数属性
     */
    @JSONField(serialize = false)
    private String remark;

    @JSONField(format = "yyy-MM-dd HH")
    private Date createTime;

    private String hotMessage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHotMessage() {
        return hotMessage;
    }

    public void setHotMessage(String hotMessage) {
        this.hotMessage = hotMessage;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
