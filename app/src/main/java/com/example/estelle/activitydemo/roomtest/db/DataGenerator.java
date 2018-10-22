/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.estelle.activitydemo.roomtest.db;


import com.example.estelle.activitydemo.roomtest.db.entity.MyRecentContactEntity;
import com.example.estelle.activitydemo.roomtest.db.model.MyRecentContact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @Description: 造一些假数据😂
 * @Author: Estelle
 * @Time: 2018/10/22 18:40
 */

public class DataGenerator {
    public static MyRecentContactEntity generateMyRecentContactEntity() {
        MyRecentContactEntity entity = new MyRecentContactEntity(null, "发送账号"
                , "发送者昵称", "消息ID", 0, "内容"
                , 1L, 2L, new HashMap<>());
        return entity;
    }
    public static List<MyRecentContactEntity> generateMyRecentContactEntitys(Integer count) {
        List<MyRecentContactEntity> entityList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            MyRecentContactEntity entity = new MyRecentContactEntity("会话ID" + i, "发送账号"
                    , "发送者昵称", "消息ID", 0, "内容"
                    , 1L, 2L, new HashMap<>());
            entityList.add(entity);
        }

        return entityList;
    }

}
