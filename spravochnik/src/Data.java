import javax.xml.bind.annotation.*;
public class Data {
    @XmlAttribute(name = "city")
    private String city;
    @XmlAttribute(name = "street")
    private String street;
    @XmlAttribute(name = "house")
    private int house;
    @XmlAttribute(name = "floor")
    private int floor;

    public String getCity(){ return city;}
    public String getStreet(){
        return street;
    }
    public int getHouse(){
        return house;
    }
    public int getFloor(){
        return floor;
    }

    public String toString(){
        final StringBuilder sb = new StringBuilder();
        sb.append(city).append(" ");
        sb.append(street).append(" ");
        sb.append(house).append(" ");
        sb.append(floor).append(" ");
        return sb.toString();
    }

}
