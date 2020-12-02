/*
 * Copyright (C) 2019 The Time2DB Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.harbby.time2db;

import com.github.harbby.gadtry.ioc.IocFactory;
import com.github.harbby.time2db.bean.JdbcMetricDBDao;

public class SqlAnalyze
{
    private SqlAnalyze() {}

    public static void main(String[] args)
            throws Exception
    {
        IocFactory aopFactory = IocFactory.create(binder -> {
            binder.bind(JettyServer.class).withSingle();
            binder.bind(SqlAnalyzeContext.class).by(SqlAnalyzeContextImpl.class).withSingle();
            binder.bind(MetricDBDao.class).by(JdbcMetricDBDao.class).withSingle();
        });
        aopFactory.getInstance(JettyServer.class).start();
    }
}
