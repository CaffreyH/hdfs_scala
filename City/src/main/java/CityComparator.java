import org.apache.hadoop.io.WritableComparator;
/**
 * Created by Caffrey on 2017/1/18.
 */
public class CityComparator extends WritableComparator {

    public CityComparator()
    {
        super(City.class,true);
    }
    @Override
    public int compare(Object a, Object b) {
        int result;
        City c1 = (City) a;
        City c2 = (City) b;
        String province = c1.getProvince();
        if (province.equals("shanghai") || province.equals("biejing") || province.equals("tianjin") || province.equals("chongqin")) {
            long value = c1.getGdp() - c2.getGdp();
            if (value == 0) {
                long pv = c1.getPopulation() - c2.getPopulation();

                result = pv != 0 ? (int) pv : c1.getCity().compareTo(c2.getCity());
            } else {
                result = (int) value;
            }
        } else {
            long value = c1.getPopulation() - c2.getPopulation();

            if (value == 0) {

                long gv = c1.getGdp() - c2.getGdp();

                result = gv != 0 ? (int) gv : c1.getCity().compareTo(c2.getCity());


            } else {

                result = (int) value;

            }
        }
        return result;
    }
}
