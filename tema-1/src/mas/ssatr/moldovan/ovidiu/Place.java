package mas.ssatr.moldovan.ovidiu;

public class Place {
    private int Tokens;
    private String Name;

    public Place(int tokens, String name){
        this.Tokens = tokens;
        this.Name = name;
    }

    public boolean HasToken(){
        return Tokens>0;
    }

    public void AddToken(int number){
        this.Tokens = Tokens + number;
        FileHelper.Write("Added " + number + " tokens to place " + this.Name);
    }
    public void AddToken(){
        this.Tokens = Tokens + 1;
        FileHelper.Write("Added a token to place " + this.Name);
    }

    public void RemoveToken(int number){
        this.Tokens = Tokens - number;
        FileHelper.Write("Removed " + number + " tokens from place " + this.Name);
    }

    public void RemoveToken(){
        this.Tokens = Tokens - 1;
        FileHelper.Write("Removed a token from place " + this.Name);
    }

    public void DisplayPlace(){
        FileHelper.Write("Place " + this.Name + " with " + this.Tokens + " tokens.");
    }

    public String getName(){
        return this.Name;
    }

    public int getTokens(){
        return this.Tokens;
    }
}
