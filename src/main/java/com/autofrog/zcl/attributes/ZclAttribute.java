package com.autofrog.zcl.attributes;

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

public abstract class ZclAttribute {
    private final ZclAttributeType type;
    private final short attributeId;

    protected ZclAttribute(short attributeId, ZclAttributeType type) {
        this.attributeId = attributeId;
        this.type = type;
    }

    public ZclAttributeType getType() {
        return type;
    }

    public short getAttributeId() {
        return attributeId;
    }
}