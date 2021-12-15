/**
 * Copyright © 2021-2021 The Thingsboard Authors
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
package org.thingsboard.server.udp.conf;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.InetAddress;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LbUpstreamProperties {

    private String name;
    private String bindAddress;
    private int bindPort;
    private boolean bindSeparately;
    private String targetAddress;
    private int targetPort;
    private LbUpstreamConnectionProperties connections;
    private String rateLimits;

    public LbUpstreamProperties copy(InetAddress ip) {
        return LbUpstreamProperties.builder()
                .name(name + "-" + ip.getHostAddress())
                .bindAddress(ip.getHostAddress())
                .bindPort(bindPort)
                .bindSeparately(bindSeparately)
                .targetAddress(targetAddress)
                .targetPort(targetPort)
                .connections(connections)
                .rateLimits(rateLimits)
                .build();
    }
}
