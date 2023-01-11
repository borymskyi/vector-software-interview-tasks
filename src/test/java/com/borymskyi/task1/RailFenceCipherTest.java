package com.borymskyi.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RailFenceCipherTest {

    private final RailFenceCipher railFenceCipher = new RailFenceCipher();
    private final String expectedDecryptedStr = "WEAREDISCOVEREDFLEEATONCE";
    private final String expectedEncodedStr = "WECRLTEERDSOEEFEAOCAIVDEN";

    @Test
    public void testEncodingString() {
        var encodedStr = this.railFenceCipher.encodingString(3, this.expectedDecryptedStr);
        assertEquals(this.expectedEncodedStr, encodedStr);
    }

    @Test
    public void testEncodingEmptyString() {
        var encodedStr = this.railFenceCipher.encodingString(2, "");
        assertEquals("", encodedStr);
    }

    @Test
    public void testDecodingString() {
        var decryptedStr = this.railFenceCipher.decodingString(3, this.expectedEncodedStr);
        assertEquals(this.expectedDecryptedStr, decryptedStr);
    }

}