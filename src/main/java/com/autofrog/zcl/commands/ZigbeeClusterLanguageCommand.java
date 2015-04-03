package com.autofrog.zcl.commands;

/**
 * List of ZCL's generic commands with thier command IDs.  This list is not complete yet,
 * and it consists of the generic ZDO message types.  If extended this list, consider whether
 * or not what you're doing really belongs here rather than some cluster or profile
 * specific location.
 * <p/>
 * Created by ${USER} on ${DATE}.
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

public class ZigbeeClusterLanguageCommand {

    public static final byte READ_ATTRIBUTES = (byte) 0x00;
    public static final byte READ_ATTRIBUTES_RESPONSE = (byte) 0x01;
    public static final byte WRITE_ATTRBUTES = (byte) 0x02;
    public static final byte WRITE_ATTRIBUTES_UNDIVIDED = (byte) 0x03;
    public static final byte WRITE_ATTRIBUTES_RESPONSE = (byte) 0x04;
    public static final byte WRITE_ATTRIBUTES_NO_RESPONSE = (byte) 0x05;
    public static final byte CONFIGURE_REPORTING = (byte) 0x06;
    public static final byte CONFIGURE_REPORTING_RESPONSE = (byte) 0x07;
    public static final byte READ_REPORTING_CONFIGURATION = (byte) 0x08;
    public static final byte READ_REPORTING_CONFIGURATION_RESPONSE = (byte) 0x09;
    public static final byte REPORT_ATTRIBUTES = (byte) 0x0A;
}
