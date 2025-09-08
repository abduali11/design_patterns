public enum Action {
    TRAIN, MEDITATE, FIGHT, EXIT;

    public boolean isAvailable(State state) {
        return switch (this) {
            case TRAIN ->
                    state instanceof NoviceState || state instanceof IntermediateState || state instanceof ExpertState;
            case MEDITATE -> state instanceof IntermediateState || state instanceof ExpertState;
            case FIGHT -> state instanceof ExpertState;
            case EXIT -> true;
        };
    }
}