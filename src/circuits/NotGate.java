package circuits;

public class NotGate extends Gate {

    public NotGate(Gate in) {
        super(new Gate[]{in});
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {

        if (inValues == null) {
            throw new CircuitException("Error! Not all gates contain values");
        }
        return inValues[0] = !inValues[0];
    }

    @Override
    public String getName() {
        return "NOT";
    }

    @Override
    public Gate simplify() {
        return inGates[0] == TrueGate.instance() ? FalseGate.instance() : TrueGate.instance();
    }
}
