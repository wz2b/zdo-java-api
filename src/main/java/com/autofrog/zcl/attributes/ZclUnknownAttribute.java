package com.autofrog.zcl.attributes;

/**
 * A ZCL attribute of some unknown or unsupported type.
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

public class ZclUnknownAttribute extends ZclAttribute {

    private final ZclAttributeType attributeType;
    byte[] data;

    public ZclUnknownAttribute(short attributeId, ZclAttributeType attributeType, byte[] bytes) {
        super(attributeId);
        data = bytes;
        this.attributeType = attributeType;
    }

    public byte[] getData() {
        return data;
    }

}
