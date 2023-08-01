package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ReservedSequenceTest {
    @Test
    void testReservedSequence() {
        String expected = "fedcba";
        ReversedSequence result = new ReversedSequence("abcdef");
        String res = result.toString();
        assertThat(res).isEqualTo(expected);
    }
    @Test
    void testLength() {
        ReversedSequence str = new ReversedSequence("abcdef");
        final int expected = 6;
        int result = str.length();
        assertThat(result).isEqualTo(expected);
    }
    @Test
    void testChatAt() {
        ReversedSequence str = new ReversedSequence("abcdef");
        char expected = 'd';
        char result = str.charAt(2);
        assertThat(result).isEqualTo(expected);
    }
    @Test
    void testSubSequence() {
        final int begin = 2;
        final int end = 3;
        CharSequence expected = "d";
        ReversedSequence str = new ReversedSequence("abcdef");
        CharSequence result = str.subSequence(begin, end);
        assertThat(result).isEqualTo(expected);
    }
}
