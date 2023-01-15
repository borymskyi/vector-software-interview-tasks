package com.borymskyi.task1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RailFenceCipherTest {

    private final RailFenceCipher railFenceCipher = new RailFenceCipher();

    @Test
    public void testEncodingString() {
        var encoded1 = this.railFenceCipher.encodingString(3, getExpectedDecryptedStrings().get(0));
        var encoded2 = this.railFenceCipher.encodingString(4, getExpectedDecryptedStrings().get(1));
        var encoded3 = this.railFenceCipher.encodingString(7, getExpectedDecryptedStrings().get(0));
        var encoded4 = this.railFenceCipher.encodingString(6, getExpectedDecryptedStrings().get(1));
        var encoded5 = this.railFenceCipher.encodingString(50, getExpectedDecryptedStrings().get(2));
        assertAll(() -> {
            assertEquals("WECRLTEERDSOEEFEAOCAIVDEN", encoded1);
            assertEquals("bkosyrmiy", encoded2);
            assertEquals("WREEEECAVDNROFOECLTDSEAIE", encoded3);
            assertEquals("boriyymks", encoded4);
            assertEquals("vectorSoftware", encoded5);
        });

    }

    @Test
    public void testDecodingString() {
        var decrypted1 = this.railFenceCipher.decodingString(3, "WECRLTEERDSOEEFEAOCAIVDEN");
        var decrypted2 = this.railFenceCipher.decodingString(4, "bkosyrmiy");
        var decrypted3 = this.railFenceCipher.decodingString(7, "WREEEECAVDNROFOECLTDSEAIE");
        var decrypted4 = this.railFenceCipher.decodingString(50, "vectorSoftware");

        assertEquals(getExpectedDecryptedStrings().get(0), decrypted1);
        assertEquals(getExpectedDecryptedStrings().get(1), decrypted2);
        assertEquals(getExpectedDecryptedStrings().get(0), decrypted3);
        assertEquals(getExpectedDecryptedStrings().get(2), decrypted4);
    }

    @Test
    public void testEncodingEmptyString() {
        var encodedStr = this.railFenceCipher.encodingString(2, "");
        assertEquals("", encodedStr);
    }

    public List<String> getExpectedDecryptedStrings(){
        return List.of(
                "WEAREDISCOVEREDFLEEATONCE",
                "borymskyi",
                "vectorSoftware"
        );
    }

}