package someTest.polymorphismIfLess;

/**
 * Created by shuailu on 4/19/16.
 */
public class ImageLoader {

    protected String image;
    protected AbstractLoader loader;

    public ImageLoader() {
        loader = new NullImageLoader();
    }

    private class NotNullImageLoader extends AbstractLoader {
        public String getImage(String url) {
            return image;
        }
    }

    private class NullImageLoader extends AbstractLoader {
        public String getImage(String url) {
            image = url;
            loader = new NotNullImageLoader();
            return image;
        }
    }

    private abstract class AbstractLoader {
        public abstract String getImage(String url);
    }


    public String getImage(String url) {
        return loader.getImage(url);
    }

    public static void main(String[] args) {
        ImageLoader loader = new ImageLoader();
        System.out.println(loader.getImage("url"));
        System.out.println(loader.getImage("url"));
    }
}
