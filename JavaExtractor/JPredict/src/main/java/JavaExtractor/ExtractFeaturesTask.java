package JavaExtractor;

import JavaExtractor.Common.CommandLineValues;
import JavaExtractor.Common.Common;
import JavaExtractor.FeaturesEntities.ProgramFeatures;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

class ExtractFeaturesTask implements Callable<Void> {
    private final CommandLineValues m_CommandLineValues;
    private final Path filePath;

    public ExtractFeaturesTask(CommandLineValues commandLineValues, Path path) {
        m_CommandLineValues = commandLineValues;
        this.filePath = path;
    }

    @Override
    public Void call() {
        processFile();
        return null;
    }

    public void processFile() {
        ArrayList<ProgramFeatures> features;
        try {
            features = extractSingleFile();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        if (features == null) {
            return;
        }

        String toPrint = featuresToString(features);
        if (toPrint.length() > 0) {
            System.out.println(toPrint);
        }
    }

    private ArrayList<ProgramFeatures> extractSingleFile() throws IOException {
        String code;
        String comment;

        if (m_CommandLineValues.MaxFileLength > 0 &&
                Files.lines(filePath, Charset.defaultCharset()).count() > m_CommandLineValues.MaxFileLength) {
            return new ArrayList<>();
        }
        try {
            code = new String(Files.readAllBytes(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            code = Common.EmptyString;
        }

        if (code == Common.EmptyString){
            comment = Common.EmptyString;
        }
        else {
            String commentPath = filePath.toString();
            commentPath = commentPath.replace('\\', '/');
            int lst = commentPath.lastIndexOf("/");
            commentPath = commentPath.replace(commentPath.substring(lst + 1), "comment.txt");
            Path pathToComment = Paths.get(commentPath);
            comment = new String(Files.readAllBytes(pathToComment));
        }
        FeatureExtractor featureExtractor = new FeatureExtractor(m_CommandLineValues);

        return featureExtractor.extractFeatures(code, comment);
    }

    public String featuresToString(ArrayList<ProgramFeatures> features) {
        if (features == null || features.isEmpty()) {
            return Common.EmptyString;
        }

        List<String> methodsOutputs = new ArrayList<>();

        for (ProgramFeatures singleMethodFeatures : features) {
            StringBuilder builder = new StringBuilder();

            String toPrint = singleMethodFeatures.toString();
            if (m_CommandLineValues.PrettyPrint) {
                toPrint = toPrint.replace(" ", "\n\t");
            }
            builder.append(toPrint);


            methodsOutputs.add(builder.toString());

        }
        return StringUtils.join(methodsOutputs, "\n");
    }
}
