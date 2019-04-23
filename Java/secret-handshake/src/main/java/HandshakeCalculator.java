import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Stream;

class HandshakeCalculator {

    private static final int REVERSE = 16;

	List<Signal> calculateHandshake(int number) {
        List<Signal> handshakeSignals = new ArrayList<Signal>();
        
        Stream.of(Signal.values()).forEach(signal -> {
            if ((number & signal.getValue()) > 0) {
                handshakeSignals.add(signal);
            }
        });

        if ((number & REVERSE) > 0) {
            Collections.reverse(handshakeSignals);
        }

        return handshakeSignals;
    }

}
