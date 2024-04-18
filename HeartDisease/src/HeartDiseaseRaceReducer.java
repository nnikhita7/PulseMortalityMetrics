import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class HeartDiseaseRaceReducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable> {
    @Override
    public void reduce(Text key, Iterator<DoubleWritable> values, OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {
        // Create a HashSet to store unique Data_Values
        HashSet<Double> uniqueValues = new HashSet<>();

        // Iterate through the values for the same key
        while (values.hasNext()) {
            // Add each Data_Value to the HashSet
            uniqueValues.add(values.next().get());
        }

        // Calculate the number of unique Data_Values
        int count = uniqueValues.size();

        // Emit the key (Stratification2) and the count of unique Data_Values
        output.collect(key, new DoubleWritable(count));
    }
}
