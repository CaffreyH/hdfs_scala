import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.net.NetUtils;

import java.io.IOException;


/**
 * Created by Caffrey on 2017/1/18.
 */
public class SecondSortReducer extends Reducer<City, NullWritable, City, NullWritable> {

    @Override
    protected void reduce(City key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {

        context.write(key, NullWritable.get());
    }
}
