package org.traccar.protocol;


import org.junit.jupiter.api.Test;
import org.traccar.ProtocolTest;

public class Gl100ProtocolDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        var decoder = inject(new Gl100ProtocolDecoder(null));

        verifyPosition(decoder, text(
                "+RESP:GTLGL,359464030492644,1,2,1,0,0.4,0,299.7,1,5.455551,51.449776,20160311083229,0204,0016,03EC,BD94,00,0036,0102090501"));

        verifyPosition(decoder, text(
                "+RESP:GTTRI,359464030439249,1,0,61,1,0.0,346,-2.7,2,-80.392825,26.122424,20151214000354,0310,0260,72BC,35F5,00,04B6,0102070407"));

        verifyPosition(decoder, text(
                "+RESP:GTTRI,135790246811220,1,0,0,1,4.3,92,70.0,1,121.354335,31.222073,20090101000000,0460,0000,18d8,6141,00,11F0,0102070202"));

        verifyPosition(decoder, text(
                "+RESP:GTTRI,135790246811220,2,0,0,1,4.3,92,70.0,1,121.354335,31.222073,20090101000000,0460,0000,18d8,6141,00,1,-3.6,145,30.0,2,121.354442,31.221940,20090101000100,0460,0000,18d8,6141,00,11F0,0102070202"));

        verifyNull(decoder, text(
                "AT+GTHBD=HeartBeat,359231030000010,20090101000000,11F0,0102120204"));

        verifyPosition(decoder, text(
                "+RESP:GTSOS,359231030000010,0,0,0,1,4.3,92,70.0,1,121.354335,31.222073,20090101000000,0460,0000,18d8,6141,00,11F0,0102120204"),
                position("2009-01-01 00:00:00.000", false, 31.22207, 121.35434));

        verifyPosition(decoder, text(
                "+RESP:GTRTL,359231030000010,0,0,0,1,4.3,92,70.0,1,121.354335,31.222073,20090101000000,0460,0000,18d8,6141,00,11F0,0102120204"));

        verifyPosition(decoder, text(
                "+RESP:GTEST,359231030000010,0,0,0,1,4.3,92,70.0,1,121.354335,31.222073,20090101000000,0460,0000,18d8,6141,00,11F0,0102120204"));

        verifyPosition(decoder, text(
                "+RESP:GTSZI,359231030000010,0,3,0,1,4.3,92,70.0,1,121.354335,31.222073,20090101000000,0460,0000,18d8,6141,00,11F0,0102120204"));

        verifyPosition(decoder, text(
                "+RESP:GTLBC,359231030000010,02132523415,1,4.3,92,70.0,1,121.354335,31.222073,20090101000000,0460,0000,18d8,6141,00,11F0,0102120204"));

        verifyPosition(decoder, text(
                "+RESP:GTTRI,359231030000010,1,0,0,1,4.3,92,70.0,1,121.354335,31.222073,20090101000000,0460,0000,18d8,6141,00,11F0,0102120204"));

        verifyPosition(decoder, text(
                "+RESP:GTTRI,359231030000010,2,0,0,1,4.3,92,70.0,1,121.354335,31.222073,20090101000000,0460,0000,18d8,6141,00,0,0,1,-3.6,145,30.0,2,121.354442,31.221940,20090101000100,0460,0000,18d8,6141,00,11F0,0102120204"));

        verifyPosition(decoder, text(
                "+RESP:GTTRI,359464030073766,1,0,0,0,1.7,254,-27.8,3,30.474475,50.488383,20131107155511,0255,0003,6995,4761,00,0071,0103090402"));

    }

}
