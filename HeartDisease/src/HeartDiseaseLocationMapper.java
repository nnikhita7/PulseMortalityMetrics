import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class HeartDiseaseLocationMapper extends MapReduceBase implements
        Mapper<LongWritable, Text, Text, DoubleWritable> {
    @Override
    public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output,
                    Reporter reporter) throws IOException {
        String line = value.toString();
        String[] fields = line.split(",");

        String locationAbbr = fields[0];
        double dataValue = Double.parseDouble(fields[1]);

        output.collect(new Text(locationAbbr), new DoubleWritable(dataValue));
    }
}

