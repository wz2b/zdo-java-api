package com.autofrog.zcl.messages;

import com.autofrog.zcl.protocol.ZigbeeClusterMessage;

import java.nio.ByteBuffer;

/**
 * An unknown ZCL message - if we can't parse it, it turns into one of these.
 * Created by ${USER} on ${DATE}.
 * <pre>
 * (C) Copyright 2015 Christopher Piggott (cpiggott@gmail.com)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * </pre>
 */

public class ZigbeeUnknownMessage extends ZigbeeClusterMessage {
    protected byte[] data;

    @Override
    protected void parseData(ByteBuffer buf) {

    }
}
