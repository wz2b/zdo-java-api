package com.autofrog.zcl.attributes;

import java.util.List;

/**
 * 6/15/17
 *
 * @author <a href="mailto:cepasp@rit.edu">Christopher Piggott</a>
 *         Rochester Institute of Technology
 */
public class ZclNumberArrayAttribute extends ZclArrayAttribute {
    private final List<Number> values;
    private final ZclAttributeType elementType;

    public ZclNumberArrayAttribute(short attributeId,
                                   ZclAttributeType elementType,
                                   List<Number> numbers) {
        super(attributeId);
        this.elementType = elementType;
        this.values = numbers;
    }


    public int count() {
        return values.size();
    }

    public List<Number> getValuez() {
        return values;
    }


    public ZclAttributeType getType() {
        return elementType;
    }
}
