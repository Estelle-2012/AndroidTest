package com.example.estelle.activitydemo.roomtest.db.model;

import java.util.Map;

/**
 * @Description: 会话类（用于存储历史会话）
 * @Author: wb.huhuimin
 * @Time: 2018/10/22 14:09      
 * @update: wb.huhuimin 2018/10/22 14:09
 */
public interface MyRecentContact {
    String getContactId();

    String getFromAccount();

    String getFromNick();

//    SessionTypeEnum getSessionType();

    String getRecentMessageId();

//    MsgTypeEnum getMsgType();

//    MsgStatusEnum getMsgStatus();

//    void setMsgStatus(MsgStatusEnum var1);

    int getUnreadCount();

    String getContent();

    long getTime();

//    MsgAttachment getAttachment();

    void setTag(long var1);

    long getTag();

    Map<String, Object> getExtension();

    void setExtension(Map<String, Object> var1);


}
