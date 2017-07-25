/**
 * Created by narahara on 7/25/2017.
 */
public class Vehicle {
    private int vid;
    private String vregno;
    private String vmodel;
    private Insurance insurance;
    public Vehicle(){}
    public Vehicle(String vregno,String vmodel,Insurance insurance){
        this.vmodel=vmodel;
        this.vregno=vregno;
        this.insurance=insurance;
    }
    public int getVid() {
        return vid;
    }
    public void setVid( int vid ) {
        this.vid = vid;
    }
    public String getVregno() {
        return vregno;
    }
    public void setVregno( String vregno) {
        this.vregno = vregno;
    }
    public String getVmodel() {
        return vmodel;
    }
    public void setVmodel( String vmodel ) {
        this.vmodel = vmodel;
    }
    public Insurance getInsurance() {
        return insurance;
    }
    public void setInsurance(Insurance insurance){
        this.insurance=insurance;
    }
}
