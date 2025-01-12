/*
 * Copyright 2023 Ververica Inc.
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

package com.ververica.cdc.connectors.base.relational.connection;

import java.io.Serializable;
import java.util.Objects;

/** The connection pool identifier. */
public class ConnectionPoolId implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String host;
    private final int port;
    private final String username;

    /** the identifier of a data source pool factory is its class name. */
    private final String dataSourcePoolFactoryIdentifier;

    public ConnectionPoolId(
            String host, int port, String username, String dataSourcePoolFactoryIdentifier) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.dataSourcePoolFactoryIdentifier = dataSourcePoolFactoryIdentifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConnectionPoolId)) {
            return false;
        }
        ConnectionPoolId that = (ConnectionPoolId) o;
        return Objects.equals(host, that.host)
                && Objects.equals(port, that.port)
                && Objects.equals(username, that.username)
                && Objects.equals(
                        dataSourcePoolFactoryIdentifier, that.dataSourcePoolFactoryIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port, username, dataSourcePoolFactoryIdentifier);
    }

    @Override
    public String toString() {
        return username + '@' + host + ':' + port;
    }

    public String getDataSourcePoolFactoryIdentifier() {
        return dataSourcePoolFactoryIdentifier;
    }
}
