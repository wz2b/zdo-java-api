package com.autofrog.zcl.attributes;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * A ZCL attribute of a numeric type.  These are attributes that can be parsed into a
 * java.lang.Number which is the base class of most things numeric in java.  Parsing
 * to this type allows the end user to examine the actual desired type and use
 * Number's conversion facilities.  This can be useful because a lot of the time we don't
 * really care how the number went across the wire, we just want to store it or do some kind
 * of math on it.
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

public class ZclNumberAttribute extends ZclAttribute {

    private final Number value;

    public ZclNumberAttribute(short attributeId, ZclAttributeType attributeType, double value) {
        super(attributeId, attributeType);
        this.value = value;
    }

    public ZclNumberAttribute(short attributeId, ZclAttributeType attributeType, long value) {
        super(attributeId, attributeType);
        this.value = value;
    }

    public ZclNumberAttribute(short attributeId, ZclAttributeType attributeType, int value) {
        super(attributeId, attributeType);
        this.value = value;
    }

    public ZclNumberAttribute(short attributeId, ZclAttributeType attributeType, byte value) {
        super(attributeId, attributeType);
        this.value = value;
    }

    public ZclNumberAttribute(short attributeId, ZclAttributeType attributeType, short value) {
        super(attributeId, attributeType);
        this.value = value;
    }

    public ZclNumberAttribute(short attributeId, ZclAttributeType attributeType, BigInteger value) {
        super(attributeId, attributeType);
        this.value = value;
    }

    public ZclNumberAttribute(short attributeId, ZclAttributeType attributeType, BigDecimal value) {
        super(attributeId, attributeType);
        this.value = value;
    }

    public Number getValue() {
        return value;
    }
}
