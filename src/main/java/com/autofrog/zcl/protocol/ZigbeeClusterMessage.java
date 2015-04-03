package com.autofrog.zcl.protocol;

import com.autofrog.zcl.commands.ZigbeeClusterLanguageCommand;
import com.autofrog.zcl.commands.ZigbeeReportAttributesCommand;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * A base class representing a ZCL message, which contains at least a header.  The intent
 * is that a more specific ZCL message extends this one.
 * <p/>
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

public abstract class ZigbeeClusterMessage {
    protected ZigbeeClusterLanguageHeader header;

    public static ZigbeeClusterMessage parse(ByteBuffer bb) {
        ByteOrder oldOrder = bb.order();
        bb.order(ByteOrder.LITTLE_ENDIAN);

		/*
         * Read the frame control byte
		 */
        ZigbeeClusterLanguageHeader header = new ZigbeeClusterLanguageHeader(bb);

        ZigbeeClusterMessage msg = null;

        switch (header.getCommandIdentifier()) {
            case ZigbeeClusterLanguageCommand.REPORT_ATTRIBUTES:
                msg = new ZigbeeReportAttributesCommand();
                break;
            default:
                break;
        }


        if (msg != null) {
            msg.header = header;
            msg.parseData(bb);
        }

        bb.order(oldOrder);
        return msg;
    }

    protected abstract void parseData(ByteBuffer buf);

    public ZigbeeClusterLanguageHeader getHeader() {
        return header;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName())
                .append("{ ")
                .append(header.toString())
                .append(" }");

        return sb.toString();
    }
}
