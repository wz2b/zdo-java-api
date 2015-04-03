package com.autofrog.zcl.attributes;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a ZCL attrbute type - the byte that goes across the wire and tells us what
 * kind of value is being sent.
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

public enum ZclAttributeType {

    /*
     * null type
     */
    NULL(0, 0, false, false),

    /*
     * general data
     */
    GEN8(0x08, 1, false, false),
    GEN16(0x09, 2, false, false),
    GEN24(0x0a, 3, false, false),
    GEN32(0x0b, 4, false, false),
    GEN40(0x0c, 5, false, false),
    GEN48(0x0d, 6, false, false),
    GEN56(0x0e, 7, false, false),
    GEN64(0x0f, 8, false, false),

    /*
     * Logical
     */
    BOOLEAN(0x10, 1, false, false),

    /*
     * Bitmaps
     */
    BITMAP8(0x18, 1, false, true),
    BITMAP16(0x19, 2, false, true),
    BITMAP24(0x1a, 3, false, true),
    BITMAP32(0x1b, 4, false, true),
    BITMAP40(0x1c, 5, false, true),
    BITMAP48(0x1d, 6, false, true),
    BITMAP56(0x1e, 7, false, true),
    BITMAP64(0x1f, 8, false, true),

    /*
     * Unsigned ints
     */
    UINT8(0x20, 1, true, false),
    UINT16(0x21, 2, true, false),
    UINT24(0x22, 3, true, false),
    UINT32(0x23, 4, true, false),
    UINT40(0x24, 5, true, false),
    UINT48(0x25, 6, true, false),
    UINT56(0x26, 7, true, false),
    UINT64(0x27, 8, true, false),

    /*
     * Signed ints
     */
    INT8(0x28, 1, true, false),
    INT16(0x29, 2, true, false),
    INT24(0x2a, 3, true, false),
    INT32(0x2b, 4, true, false),
    INT40(0x2c, 5, true, false),
    INT48(0x2d, 6, true, false),
    INT56(0x2e, 7, true, false),
    INT64(0x2f, 8, true, false),
    HALF_FLOAT(0x38, 2, true, false),
    SINGLE(0x39, 4, true, false),
    DOUBLE(0x3a, 8, true, false),

    /*
     * Enumerations
     */
    ENUM8(0x30, 1, false, false),
    ENUM16(0x31, 2, false, false),

    /*
     * Strings
     */
    OCTET_STRING(0x41, -1, false, false),
    CHAR_STRING(0x42, -1, false, false),
    LONG_OCTET_STRING(0x43, -2, false, false),
    LONG_CHAR_STRING(0x44, -2, false, false),

    /*
     * Ordered sequences
     */
    ARRAY(0x48, -1, false, false),
    STRUCTURE(0x4c, -1, false, false),

    /*
     * Collections
     */
    SET(0x50, -1, false, false),
    BAG(0x51, -1, false, false),

    /*
     * Date and Time
     */
    TIME_OF_DAY(0xe0, 4, false, false),
    DATE(0xe1, 4, false, false),
    UTC_TIME(0xe2, 4, true, false),

    /*
     * Identifiers
     */
    CLUSTER_ID(0xe8, 2, true, false),
    ATTRIBUTE_ID(0xe9, 2, true, false),
    BACNET_OID(0xea, 4, true, false),

    /*
     * Miscellaneous
     */
    IEEE_ADDRESS(0xf0, 8, false, false),
    KEY128(0xf1, 16, false, false),
    UNKNOWN(0xFF, 0, false, false);


    static final Map<Byte, ZclAttributeType> reverse;

    static {
        reverse = new HashMap<Byte, ZclAttributeType>();
        for (ZclAttributeType value : EnumSet.allOf(ZclAttributeType.class)) {
            reverse.put(value.getTag(), value);
        }
    }

    private final byte tag;
    private final int length;
    private final boolean isNumeric;
    private final boolean isBitField;

    ZclAttributeType(int tag, int length, boolean isNumeric, boolean isBitField) {
        this.tag = (byte) tag;
        this.length = length;
        this.isNumeric = isNumeric;
        this.isBitField = isBitField;

    }

    public static ZclAttributeType lookup(byte b) {
        return reverse.get(b);
    }

    public byte getTag() {
        return tag;
    }

    public int getLength() {
        return length;
    }

    public boolean isIsNumeric() {
        return isNumeric;
    }

    public boolean isIsBitField() {
        return isBitField;
    }
}
