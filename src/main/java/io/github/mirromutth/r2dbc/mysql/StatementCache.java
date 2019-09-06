/*
 * Copyright 2018-2019 the original author or authors.
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

package io.github.mirromutth.r2dbc.mysql;

import io.github.mirromutth.r2dbc.mysql.client.Client;
import io.github.mirromutth.r2dbc.mysql.constant.CacheType;
import reactor.core.publisher.Mono;

/**
 * A cache interface considers statement-mapped caches for one connection.
 * <p>
 * MySQL does not support prepare statements across multiple connections.
 * <p>
 * WARNING: It is NOT thread-safety.
 */
interface StatementCache {

    Mono<Integer> getOrPrepare(String sql);

    static StatementCache create(Client client, CacheConfiguration configuration) {
        CacheType type = configuration.getType();

        switch (type) {
            case INDEFINITE:
                return new IndefiniteStatementCache(client);
            case W_TINY_LFU:
                return new WindowTinyLfuStatementCache(client, configuration.getSize());
            default:
                throw new IllegalStateException("Unsupported cache type " + type);
        }
    }
}
