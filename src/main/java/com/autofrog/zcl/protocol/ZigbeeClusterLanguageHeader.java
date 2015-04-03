package com.autofrog.zcl.protocol;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * The ZCL header, which contains a profile id, direction, frame type, and a few other
 * things from the spec.
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

public class ZigbeeClusterLanguageHeader {

    private FrameType frameType;
    private Direction direction;
    private boolean disableDefaultResponse;
    private boolean manufacturerSpecific;
    private short manufacturerCode;
    private byte transactionSequenceNumber;
    private byte commandIdentifier;

    public ZigbeeClusterLanguageHeader() {
    }

    public ZigbeeClusterLanguageHeader(ByteBuffer bb) {


        byte frameControlByte = bb.get();

        if ((frameControlByte & 0x03) == 0) {
            frameType = FrameType.Profile;
        } else if ((frameControlByte & 03) == 1) {
            frameType = FrameType.ClusterSpecific;
        } else {
            frameType = FrameType.Unknown;
        }

        manufacturerSpecific = ((frameControlByte & 0x04) != 0);

        if (manufacturerSpecific) {
            /*
			 * Since this is the only multi-byte value in the
			 * header, we'll modify then restore the byte
			 * buffer endian ordering right hre
			 */
            ByteOrder oldOrder = bb.order();
            bb.order(ByteOrder.LITTLE_ENDIAN);
            manufacturerCode = bb.getShort();
            bb.order(oldOrder);
        } else {
            manufacturerCode = 0;
        }

        if ((frameControlByte & 0x08) == 0) {
            direction = Direction.ClientToServer;
        } else {
            direction = Direction.ServerToClient;
        }
        disableDefaultResponse = ((frameControlByte & 0x10) == 0);


        transactionSequenceNumber = bb.get();
        commandIdentifier = bb.get();


    }

    public FrameType getFrameType() {
        return frameType;
    }

    public void setFrameType(FrameType frameType) {
        this.frameType = frameType;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isDisableDefaultResponse() {
        return disableDefaultResponse;
    }

    public void setDisableDefaultResponse(boolean disableDefaultResponse) {
        this.disableDefaultResponse = disableDefaultResponse;
    }

    public boolean isManufacturerSpecific() {
        return manufacturerSpecific;
    }

    public void setManufacturerSpecific(boolean manufacturerSpecific) {
        this.manufacturerSpecific = manufacturerSpecific;
    }

    public short getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(short manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public byte getTransactionSequenceNumber() {
        return transactionSequenceNumber;
    }

    public void setTransactionSequenceNumber(byte transactionSequenceNumber) {
        this.transactionSequenceNumber = transactionSequenceNumber;
    }

    public byte getCommandIdentifier() {
        return commandIdentifier;
    }

    public void setCommandIdentifier(byte commandIdentifier) {
        this.commandIdentifier = commandIdentifier;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.frameType != null ? this.frameType.hashCode() : 0);
        hash = 59 * hash + (this.direction != null ? this.direction.hashCode() : 0);
        hash = 59 * hash + (this.disableDefaultResponse ? 1 : 0);
        hash = 59 * hash + (this.manufacturerSpecific ? 1 : 0);
        hash = 59 * hash + this.manufacturerCode;
        hash = 59 * hash + this.transactionSequenceNumber;
        hash = 59 * hash + this.commandIdentifier;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ZigbeeClusterLanguageHeader other = (ZigbeeClusterLanguageHeader) obj;
        if (this.frameType != other.frameType) {
            return false;
        }
        if (this.direction != other.direction) {
            return false;
        }
        if (this.disableDefaultResponse != other.disableDefaultResponse) {
            return false;
        }
        if (this.manufacturerSpecific != other.manufacturerSpecific) {
            return false;
        }
        if (this.manufacturerCode != other.manufacturerCode) {
            return false;
        }
        if (this.transactionSequenceNumber != other.transactionSequenceNumber) {
            return false;
        }
        if (this.commandIdentifier != other.commandIdentifier) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName())
                .append(" { frameType=")
                .append(frameType)
                .append(", direction=")
                .append(direction)
                .append(", disableDefaultResponse=")
                .append(disableDefaultResponse)
                .append(", manufacturerSpecific=")
                .append(manufacturerSpecific)
                .append(", manufacturer=")
                .append(String.format("0x%04x", manufacturerCode))
                .append(", transactionSequenceNumber=")
                .append(transactionSequenceNumber)
                .append(", commandIdentifier=")
                .append(String.format("0x%02x", commandIdentifier))
                .append(" }");
        return sb.toString();
    }

    public enum FrameType {

        Profile,
        ClusterSpecific,
        Unknown
    }

    public enum Direction {

        ServerToClient,
        ClientToServer
    }
}
