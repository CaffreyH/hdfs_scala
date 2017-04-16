import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;
import java.util.HashMap;


/**
 * Created by Caffrey on 2017/1/18.
 */
public class CityPartitiontor extends Partitioner<City, NullWritable> {


    static HashMap<String, Integer> map = null;

    static {

        map = new HashMap<String, Integer>();

        map.put("sichuan", 1);
        map.put("guangdong", 2);
        map.put("guizhou", 3);
        map.put("henan", 5);
        map.put("zhixiashi", 6);
    }

    public int getPartition(City city, NullWritable o2, int i) {

        int partitionID = map.get(city.getProvince()).intValue();

        return partitionID;
    }
}

