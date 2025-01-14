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

package dev.miku.r2dbc.mysql.message.server;

/**
 * A synthetic message for trigger SSL handshake complete handler.
 */
public final class SyntheticSslResponseMessage implements ServerMessage {

    private static final SyntheticSslResponseMessage INSTANCE = new SyntheticSslResponseMessage();

    private SyntheticSslResponseMessage() {
    }

    @Override
    public String toString() {
        return "SyntheticSslResponseMessage{}";
    }

    public static SyntheticSslResponseMessage getInstance() {
        return INSTANCE;
    }
}
