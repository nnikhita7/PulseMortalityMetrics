import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class HeartDiseaseDriver {
    public static void main(String[] args) throws Exception {
        JobClient myClient = new JobClient();
        // Create a configuration object for the job
        JobConf jobConf = new JobConf(HeartDiseaseDriver.class);

        // Set a name for the job
        jobConf.setJobName("HeartDisease");

        // Specify data types of output key and value
        jobConf.setOutputKeyClass(Text.class);
        jobConf.setOutputValueClass(DoubleWritable.class);

        // Specify names of Mapper and Reducer class
        jobConf.setMapperClass(HeartDiseaseMapper.class);
        jobConf.setReducerClass(HeartDiseaseReducer.class);

        // Specify formats of the data type of Input and output
        jobConf.setInputFormat(TextInputFormat.class);
        jobConf.setOutputFormat(TextOutputFormat.class);

        // Set input and output directories using command-line arguments
        // args[0] = name of input directory on HDFS and args[1] = name of output directory to be created
        FileInputFormat.setInputPaths(jobConf, new Path(args[0]));
        FileOutputFormat.setOutputPath(jobConf, new Path(args[1]));

        myClient.setConf(jobConf);
        try {
            // Run the job
            JobClient.runJob(jobConf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
