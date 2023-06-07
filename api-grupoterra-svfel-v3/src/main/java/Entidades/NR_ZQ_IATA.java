package Entidades;

import java.io.Serializable;

public class NR_ZQ_IATA implements Serializable {

    private static final long serialVersionUID = 1L;

    private Number idinventorycontrol;
    private String ordernumber;

    public NR_ZQ_IATA(Number idinventorycontrol, String ordernumber) {
        this.idinventorycontrol = idinventorycontrol;
        this.ordernumber = ordernumber;
    }

    public NR_ZQ_IATA() {
    }

    public Number getIdinventorycontrol() {
        return idinventorycontrol;
    }

    public void setIdinventorycontrol(Number idinventorycontrol) {
        this.idinventorycontrol = idinventorycontrol;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    @Override
    public String toString() {
        return "NR_ZQ_IATA{" + "idinventorycontrol=" + idinventorycontrol + ", ordernumber=" + ordernumber + '}';
    }
    
}
