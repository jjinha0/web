package webclient;

/**
 * Created by danawacomputer on 2017-04-14.
 */
public class URLNaver {
    private String words;

    @Override
    public String toString() {
        return "URLNaver{" +
                "words='" + words + '\'' +
                '}';
    }

    public URLNaver(String words) {
        this.words = words;
    }

    public URLNaver() {

    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
