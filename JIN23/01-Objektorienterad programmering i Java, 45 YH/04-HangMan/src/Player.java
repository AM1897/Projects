class Player {
    private String name;    //lagra namnet på spelaren.
    private int guesses;    //antal gissningar
    private int points;    //antal rätt gissningar

    public Player(String name) {    //som tar in spelarens namn som parameter.
        this.name = name;
        guesses = 0;
        points = 0;
    }

    public String getName() {
        return name;
    }

    public int getGuesses() {
        return guesses;
    }

    public int getScore() {
        return points;
    }

    public void increaseGuesses() {
        guesses++;
    }

    public void increasePoints() {
        points++;
    }

    public String toString() {
        return name + " has made " + guesses + " guesses and has " + points + " correct guesses";
    }
}