/**
 * Created by Administrator on 2016/5/22.
 */
package AI;

public class Position {
    private int Id;
    private int Pos_X;
    private int Pos_Y;
    private boolean isActive;
    private boolean setDilei;
    private boolean setZhadan;
    private boolean isXingying;
    private boolean isOnTheRoad;
    private int RedorBlue;
    private String Name;

    public Position() {};

    public Position(int id, int x,int y) {
        this.Id = id;
        this.Pos_X = x;
        this.Pos_Y = y;
        this.isActive = true;
        this.setDilei = false;
        this.setZhadan = true;
        this.isXingying = false;
    }

    public Position Clone() {
        Position newP = new Position(Id,Pos_X,Pos_Y);
        newP.isActive = isActive;
        newP.isOnTheRoad = isOnTheRoad;
        newP.isXingying = isXingying;
        newP.Name = Name;
        newP.setDilei = setDilei;
        newP.setZhadan = setZhadan;
        newP.RedorBlue = RedorBlue;
        return newP;
    }

    public String getName() {
        return this.Name;
    }

    public Position setName(String name){
        this.Name = name;
        return this;
    }

    public int getRedorBlue() {
        return this.RedorBlue;
    }

    public Position setRedorBlue(int redorBlue) {
        this.RedorBlue = redorBlue;
        return this;
    }

    public boolean getSetDilei() {
        return this.setDilei;
    }

    public Position setDilei(boolean dilei) {
        this.setDilei = dilei;
        return this;
    }

    public boolean getSetZhadan() {
        return this.setZhadan;
    }

    public Position setZhadan(boolean zhadan) {
        this.setZhadan = zhadan;
        return this;
    }

    public boolean getIsAtive() {
        return this.isActive;
    }

    public Position setIsAcive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public boolean getIsXingying() {
        return this.isXingying;
    }

    public Position setIsXingying(boolean xingying) {
        this.isXingying = xingying;
        return this;
    }

    public boolean getIsOnTheRoad() {
        return this.isOnTheRoad;
    }

    public Position setIsOnTheRoad(boolean isOnTheRoad) {
        this.isOnTheRoad = isOnTheRoad;
        return this;
    }

    public int getPos_X() {
        return Pos_X;
    }

    public int getPos_Y() {
        return Pos_Y;
    }
}
