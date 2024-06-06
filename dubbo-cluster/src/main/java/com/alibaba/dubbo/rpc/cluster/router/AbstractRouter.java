/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.rpc.cluster.router;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.cluster.Router;

public abstract class AbstractRouter implements Router {
    /**
     * 路由规则 URL
     */
    protected URL url;
    /**
     * 路由规则的优先级，用于排序，优先级越大越靠前执行，可不填，缺省为 0 。
     */
    protected int priority;

    @Override
    public URL getUrl() {
        return url;
    }

    @Override
    public int compareTo(Router o) {
        return (this.getPriority() < o.getPriority()) ? -1 : ((this.getPriority() == o.getPriority()) ? 0 : 1);
    }

    public int getPriority() {
        return priority;
    }
}
