package com.example.estelle.activitydemo.roomtest.db.entity;



import com.example.estelle.activitydemo.roomtest.db.model.MyRecentContact;

import java.util.Map;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * @Description: 会话类（用于存储历史会话）
 * @Author: wb.huhuimin
 * @Time: 2018/10/22 14:09
 * @update: wb.huhuimin 2018/10/22 14:09
 */
@Entity(tableName = "MyRecentContactEntity")
public class MyRecentContactEntity implements MyRecentContact {
    @PrimaryKey
    String contactId;

    String fromAccount;

    String fromNick;

    String recentMessageId;

    int unreadCount;

    String content;

    long time;

    long tag;

    Map<String, Object> Extension;

    public MyRecentContactEntity() {
    }

    @Ignore
    public MyRecentContactEntity(String contactId, String fromAccount, String fromNick
            , String recentMessageId, int unreadCount, String content, long time, long tag
            , Map<String, Object> extension) {
        this.contactId = contactId;
        this.fromAccount = fromAccount;
        this.fromNick = fromNick;
        this.recentMessageId = recentMessageId;
        this.unreadCount = unreadCount;
        this.content = content;
        this.time = time;
        this.tag = tag;
        Extension = extension;
    }

    public MyRecentContactEntity(MyRecentContact myRecentContact) {
        this.contactId = myRecentContact.getContactId();
        this.fromAccount = myRecentContact.getFromAccount();
        this.fromNick = myRecentContact.getFromNick();
        this.recentMessageId = myRecentContact.getRecentMessageId();
        this.unreadCount = myRecentContact.getUnreadCount();
        this.content = myRecentContact.getContent();
        this.time = myRecentContact.getTime();
        this.tag = myRecentContact.getTag();
        this.Extension = myRecentContact.getExtension();
    }

    @Override
    public String getContactId() {
        return null;
    }

    @Override
    public String getFromAccount() {
        return null;
    }

    @Override
    public String getFromNick() {
        return null;
    }

//    @Override
//    public SessionTypeEnum getSessionType() {
//        return null;
//    }

    @Override
    public String getRecentMessageId() {
        return null;
    }

//    @Override
//    public MsgTypeEnum getMsgType() {
//        return null;
//    }

//    @Override
//    public MsgStatusEnum getMsgStatus() {
//        return null;
//    }

//    @Override
//    public void setMsgStatus(MsgStatusEnum var1) {
//
//    }

    @Override
    public int getUnreadCount() {
        return 0;
    }

    @Override
    public String getContent() {
        return null;
    }

    @Override
    public long getTime() {
        return 0;
    }

//    @Override
//    public MsgAttachment getAttachment() {
//        return null;
//    }

    @Override
    public void setTag(long var1) {

    }

    @Override
    public long getTag() {
        return 0;
    }

    @Override
    public Map<String, Object> getExtension() {
        return null;
    }

    @Override
    public void setExtension(Map<String, Object> var1) {

    }
}
