package wordcloud;


import wordcloud.image.CloudImageGenerator;
import wordcloud.words.StringProcessor;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Scanner;

public class WordCloud {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    public static final int PADDING = 30;
    public static final String TEXT = "korean_test.txt";
    public static final String FILTER = "korean_filtering.txt";

    public static CloudViewerPanel cloud() throws IOException {
        StringProcessor strProcessor = new StringProcessor(readFile(TEXT), filteringList(FILTER));
        CloudImageGenerator generator = new CloudImageGenerator(WIDTH, HEIGHT, PADDING);
        return new CloudViewerPanel(generator.generateImage(strProcessor, System.currentTimeMillis()));
    }

    private static String readFile(String path) throws IOException {
        FileInputStream stream = new FileInputStream(new File(path));
        try {
            FileChannel fc = stream.getChannel();
            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            return Charset.defaultCharset().decode(bb).toString();
        } finally {
            stream.close();
        }
    }
    /**
     * This function generates a list of words to be filtered when a cloud is generated
     */
    private static HashSet<String> filteringList(String path) throws IOException {
        HashSet<String> filter = new HashSet<String>();
        Scanner scan = new Scanner(new File(path));
        while (scan.hasNext()) {
            filter.add(scan.next());
        }
        return filter;
    }
}
