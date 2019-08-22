import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Stream;

class HandshakeCalculator {

    private static final int REVERSE = 16;

	List<Signal> calculateHandshake(int number) {
        List<Signal> handshakeSignals = new ArrayList<Signal>();
        
        Stream.of(Signal.values()).forEach(signal -> {
            if (Signal.isBitSetInNumber(number, signal.getValue())) {
                handshakeSignals.add(signal);
            }
        });

        if (Signal.isBitSetInNumber(number, REVERSE)) {
            Collections.reverse(handshakeSignals);
        }

        return handshakeSignals;
    }

}
