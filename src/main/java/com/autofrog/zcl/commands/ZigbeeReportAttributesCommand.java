package com.autofrog.zcl.commands;


import com.autofrog.zcl.api.ZclAttributeParser;
import com.autofrog.zcl.attributes.ZclAttribute;
import com.autofrog.zcl.protocol.ZigbeeClusterMessage;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/**
 * A ZCL "Report Attributes" response - a header plus a collection of attributes,
 * including attribute id, type, and value.
 * <p/>
 * Created by ${USER} on ${DATE}.
 * <p/>
 * <p/>
 * <p/>
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

public class ZigbeeReportAttributesCommand extends ZigbeeClusterMessage {

    private final List<ZclAttribute> attributes = new ArrayList<ZclAttribute>();

    @Override
    protected void parseData(ByteBuffer buf) {
        byte[] temp;
        BigInteger bigInt;
        ByteOrder saveOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);


        while (buf.remaining() > 0) {
            ZclAttribute attribute = ZclAttributeParser.parse(buf);
            if (attribute != null) {
                attributes.add(attribute);
            }
        }
        buf.order(saveOrder);
    }

    public List<ZclAttribute> getAttributes() {
        return attributes;
    }
}
