import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.ObjectWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


/**
 * Created by Caffrey on 2017/1/18.
 */
public class SecondSortMapper extends Mapper<LongWritable , Text, City, NullWritable> {
    protected int gdp_index;

    protected int city_index;

    protected int population_index;

    protected int province_index;

    protected String delimiter;

    @Override
    public void setup(Context context) throws IOException, InterruptedException{

        Configuration configuration = context.getConfiguration();

        gdp_index = configuration.getInt("gdp_index", -1);

        city_index = configuration.getInt("city_index", -1);

        population_index = configuration.getInt("population_index", -1);

        province_index = configuration.getInt("province_index", -1);

       // delimiter = configuration.get("delimiter");
    }


    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] values = value.toString().split("\t");

/*        String cityname = values[city_index];

        long gdp = Long.parseLong(values[gdp_index]);

        long population = Long.parseLong(values[population_index]);

        String province = values[province_index];*/

        String cityname = values[0];

        long gdp = Long.parseLong(values[1]);

        long population = Long.parseLong(values[2]);

        String province = values[3];

        City city = new City();

        city.setCity(cityname);

        city.setGdp(gdp);

        city.setPopulation(population);

        city.setProvince(province);

        context.write(city, NullWritable.get());
    }

}
