package com.autofrog.zcl.api;

import com.autofrog.zcl.attributes.*;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
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

public class ZclAttributeParser {

    /**
     * This is the main entry point for the API.  Send in a byte buffer, and if it
     * looks like a ZCL attribute you'll get it back parsed.  Only a few type are
     * currently supported (mostly numbers and strings).  Feel free to expand it.
     *
     * @param buf
     * @return
     */
    public static ZclAttribute parse(ByteBuffer buf) {
        int iTemp;
        byte[] bTemp;

        short attributeId = buf.getShort();

        byte typeByte = buf.get();
        // log.debug( String.format( "  attribute ID 0x%02x, type 0x%02x", attributeId, typeByte ) );

        ZclAttributeType type = ZclAttributeType.lookup(typeByte);
        if (type == null) {
            return null;
        }
        switch (type) {

            case INT8:
            case UINT8:
                return new ZclNumberAttribute(attributeId, type, buf.get());

            case INT16:
            case UINT16:
                return new ZclNumberAttribute(attributeId, type, buf.getShort());

            case INT32:
            case UINT32:
                return new ZclNumberAttribute(attributeId, type, buf.getInt());

            case INT64:
            case UINT64:
                return new ZclNumberAttribute(attributeId, type, buf.getLong());

            case SINGLE:
                return new ZclNumberAttribute(attributeId, type, buf.getFloat());

            case DOUBLE:
                return new ZclNumberAttribute(attributeId, type, buf.getDouble());

            case OCTET_STRING:
            case CHAR_STRING:
                iTemp = buf.get() & 0xFF;
                bTemp = new byte[iTemp];
                buf.get(bTemp, 0, iTemp);
                return new ZclUnknownAttribute(attributeId, type, bTemp);

            case LONG_OCTET_STRING:
            case LONG_CHAR_STRING:
                iTemp = buf.getShort() & 0xFF;
                bTemp = new byte[iTemp];
                buf.get(bTemp, 0, iTemp);
                return new ZclUnknownAttribute(attributeId, type, bTemp);

            case ARRAY:
                return parseArray(attributeId, buf);

        }

        if (type.getLength() == 0) {
            /* Whatever this is, it's 0 bytes long */
            return new ZclUnknownAttribute(attributeId, type, new byte[0]);
        } else if (type.getLength() > 0) {
			/*
			 * This message has a length that's a positive number.  Don't
			 * know what it is, but since we know how long it is we can
			 * read it in as just bytes.
			 */
            bTemp = new byte[type.getLength()];
            buf.get(bTemp, 0, type.getLength());
            return new ZclUnknownAttribute(attributeId, type, bTemp);
        } else {
            return null;
        }
    }

    private static ZclArrayAttribute parseArray(short attributeId, ByteBuffer buf) {

        byte elementTypeNum = buf.get();
        int elementCount = buf.getShort() & 0xFFFF;

        ZclAttributeType elementTYpe = ZclAttributeType.lookup(elementTypeNum);
        if (elementTYpe == null) {
            return null;
        }


        switch(elementTYpe) {

            case UINT16:
                return parseUINT16Array(attributeId, elementCount, buf);
            default:
                return null;
        }
    }

    private static ZclNumberArrayAttribute parseUINT16Array(short attributeId, int numExpectedElements, ByteBuffer buf) {
        int remaining = buf.remaining() / 2;
        if(remaining != numExpectedElements) {
            return null;
        }

        List<Number> numbers = new ArrayList<Number>(numExpectedElements);

        while(buf.hasRemaining()) {
            int n = buf.getShort() & 0xFFFF;
            numbers.add(n);
        }

        return new ZclNumberArrayAttribute(attributeId, numbers);




    }
}
