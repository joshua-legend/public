package wordcloud.image;

import wordcloud.color.ColorCombinations;
import wordcloud.words.WordCount;

import java.awt.*;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * @author epicdevs
 */
public class CloudImageGenerator {
    private static final int REJECT_COUNT = 100;
    private static final int LARGEST_FONT_SIZE = 40;
    private static final int FONT_STEP_SIZE = 2;
    private static final int MINIMUM_FONT_SIZE = 10;
    private static final int MINIMUM_WORD_COUNT = 3;
//    public static final String FONT_FAMILY = "๋๋๋ช์กฐ";
    public static final String FONT_FAMILY = "Helvetica";
    public static final String[] THEME = ColorCombinations.THEME3;
    
    private String fontFamily;
    private final int width;
    private final int height;
    private final int padding;
    private BufferedImage bi;
    private ColorCombinations colorTheme;
    private ArrayList<Shape> occupied = new ArrayList<Shape>();
    
    public CloudImageGenerator(int width, int height, int padding) {
        this.width = width;
        this.height = height;
        this.fontFamily = FONT_FAMILY;
        this.padding = padding;
    }

    /**
     * This algorithm can be fancier than this sloppy random generation algorithm
     * For more information: http://static.mrfeinberg.com/bv_ch03.pdf
     */
    public BufferedImage generateImage(Iterable<WordCount> words, long seed) {
        Random rand = new Random(seed);
        bi = new BufferedImage(width+100 + 2 * padding, height + 2 * padding+200, BufferedImage.TYPE_INT_ARGB);
        colorTheme = new ColorCombinations(THEME);
        Graphics2D g = bi.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(colorTheme.background());
        g.fillRect(0, 0, bi.getWidth(), bi.getHeight());
        g.translate(padding, padding);
        
        Iterator<WordCount> iter = words.iterator();
        int k = LARGEST_FONT_SIZE;
        while (iter.hasNext()) {
            WordCount wc = iter.next();
            if (wc.n < MINIMUM_WORD_COUNT) break;
            int prevK = k;
            if (k > MINIMUM_FONT_SIZE) k = k - FONT_STEP_SIZE;
            Font font = new Font(fontFamily, Font.BOLD, k);
            g.setFont(font);
            FontMetrics fm = g.getFontMetrics();
            Shape s = stringShape(font, fm, wc.word, rand);
            boolean fitted = false;
            for (int i = 0; i < REJECT_COUNT * wc.n; i++) {
                s = stringShape(font, fm, wc.word, rand);
                if (!collision(s.getBounds())) {
                    fitted = true;
                    break;
                }
            }
            if (!fitted) {
                k = prevK;
                continue;
            }
            g.setColor(colorTheme.next());
            g.fill(s);
            occupied.add(s);
        }
        return bi;
    }
    
    private boolean collision(Rectangle area) {
        for (Shape shape : occupied) {
            if (shape.intersects(area)) return true;
        }
        return false;
    }
    
    private Shape stringShape(Font font, FontMetrics fm, String word, Random rand) {
        int x = rand.nextInt(325)+25;
        int y = rand.nextInt(350)+15;
        GlyphVector v = font.createGlyphVector(fm.getFontRenderContext(), word);
        AffineTransform at = new AffineTransform();
        at.translate(x, y);
        v.setGlyphTransform(0, at);
        return v.getOutline();
    }
    
    public void setColorTheme(String[] colorCodes, Color background) {
        colorTheme = new ColorCombinations(colorCodes, background);
    }
    
    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }
}
