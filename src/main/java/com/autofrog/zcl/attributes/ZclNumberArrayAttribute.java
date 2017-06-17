package com.autofrog.zcl.attributes;

import java.nio.ByteBuffer;
import java.util.List;

/**
 * 6/15/17
 *
 * @author <a href="mailto:cepasp@rit.edu">Christopher Piggott</a>
 *         Rochester Institute of Technology
 */
public class ZclNumberArrayAttribute extends ZclArrayAttribute {
    private final List<Number> numbers;

    public ZclNumberArrayAttribute(short attributeId, List<Number> numbers) {
        super(attributeId);
        this.numbers = numbers;
    }


    public int count() {
        return numbers.size();
    }

}
