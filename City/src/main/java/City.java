import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by Caffrey on 2017/1/18.
 */
public class City implements WritableComparable<City> {

    private String city;

    private String province;

    private long gdp;

    private long population;

    public String getCity() {
        return city;
    }

    public void setCity(String cty) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public long getGdp() {
        return gdp;
    }

    public void setGdp(long gdp) {
        this.gdp = gdp;
    }

    public long getPopulation() {
        return getPopulation();
    }

    public void setPopulation(long popular) {
        this.population = population;
    }

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.getCity());
        dataOutput.writeUTF(this.getProvince());
        dataOutput.writeLong(this.getGdp());
        dataOutput.writeLong(this.getPopulation());
    }

    public void readFields(DataInput dataInput) throws IOException {
        this.city = dataInput.readUTF();
        this.province = dataInput.readUTF();
        this.gdp = dataInput.readLong();
        this.population = dataInput.readLong();
    }

    @Override
    public String toString() {
        return this.getCity() + "\t" + this.getGdp() + "\t" + this.getPopulation() + "\t" + this.getProvince();
    }


    public int compareTo(City d) {

        if(this.getCity().equals(this.getProvince())) {
            if(this.getPopulation() != d.getPopulation()) {
                return this.getPopulation() - d.getPopulation() > 0 ? -1 : 1;
            }
            else if (this.getGdp() != d.getGdp()){
                return this.getGdp() - d.getGdp() > 0 ? -1 : 1;
            }
            else {
                return this.getCity().charAt(0) - d.getCity().charAt(0) > 0 ? -1 : 1;
            }
        }
        //闈炵洿杈栧競鐨勬帓搴?
        else {

            if (this.getGdp() != d.getGdp()){
                return this.getGdp() - d.getGdp() > 0 ? -1 : 1;
            }
            else if(this.getPopulation() != d.getPopulation()) {
                return this.getPopulation() - d.getPopulation() > 0 ? -1 : 1;
            }
            else {
                return this.getCity().charAt(0) - d.getCity().charAt(0) > 0 ? -1 : 1;
            }
        }

    }

}
