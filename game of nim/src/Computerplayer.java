class Computerplayer extends Player{
    boolean smart = false;

    @Override
    public int play (Pile pile){
        if(smart) {
            int x = pile.getCurrentNumberOfMarbles();
            int limit = x / 2, count = 1;
            while (x > limit + 1 && !Utilities.isPowerOfTwo(x) && count < limit ) {
                x--;
                count++;
            }
            return count;
        }
        else{
            int mar = Utilities.randomInteger(1, pile.getCurrentNumberOfMarbles() - pile.getCurrentNumberOfMarbles() / 2);
            return mar;
        }
    }



    public Computerplayer(String name, boolean smart)
    {
        this.name = name;
        this.smart = smart;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}