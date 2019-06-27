import java.util.Objects;

public class HashStrucrure {
    private String key;
    private int prob;

    @Override
    public String toString() {
        return "{" +
                key +
                ":" + prob +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getProb() {
        return prob;
    }

    public void setProb(int prob) {
        this.prob = prob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashStrucrure that = (HashStrucrure) o;
        return prob == that.prob &&
                Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {

        return Objects.hash(key, prob);
    }
}
