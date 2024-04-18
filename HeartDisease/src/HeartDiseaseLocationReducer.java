import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class HeartDiseaseLocationReducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable> {
    @Override
    public void reduce(Text key, Iterator<DoubleWritable> values, OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {
        HashSet<Double> uniqueValues = new HashSet<>();

        while (values.hasNext()) {

            uniqueValues.add(values.next().get());
        }


        int count = uniqueValues.size();


        output.collect(key, new DoubleWritable(count));
    }
}
