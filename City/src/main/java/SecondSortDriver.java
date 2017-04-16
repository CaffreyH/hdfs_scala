import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;
import java.io.IOException;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.NullWritable;
/**
 * Created by Caffrey on 2017/1/18.
 */
public class SecondSortDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();

        conf.setInt("city_index",0);
        conf.setInt("gdp_index",1);
        conf.setInt("population_index",2);
        conf.setInt("province_index",3);



        Job job = Job.getInstance(conf);
        job.setNumReduceTasks(34);
        job.setJarByClass(SecondSortDriver.class);
        job.setPartitionerClass(CityPartitiontor.class);
        job.setSortComparatorClass(CityComparator.class);
        job.setMapperClass(SecondSortMapper.class);
        job.setReducerClass(SecondSortReducer.class);
        job.setMapOutputKeyClass(City.class);

        job.setMapOutputValueClass(NullWritable.class);
        job.setOutputKeyClass(City.class);
        job.setOutputValueClass(NullWritable.class);

/*        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        //璁剧疆鎴戜滑鐨勪笟鍔￠€昏緫Reducer绫荤殑杈撳嚭key鍜寁alue鐨勬暟鎹被鍨?
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);*/

        //指定要处理的数据所在的位置
        FileInputFormat.setInputPaths(job, "hdfs://192.168.214.101:9000/city/input/shuju.txt");
        //指定处理完成之后的结果所保存的位置
        FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.214.101:9000/output/"));

        boolean res = job.waitForCompletion(true);
        System.exit(res?0:1);

    }
}
