package com.autofrog.zcl.attributes;

import java.nio.ByteBuffer;

/**
 * 6/15/17
 *
 * @author <a href="mailto:cepasp@rit.edu">Christopher Piggott</a> Rochester Institute of Technology
 */
public abstract class ZclArrayAttribute extends ZclAttribute {

    protected ZclArrayAttribute(short attributeId) {
        super(attributeId);
    }
}
