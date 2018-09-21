package alex.ru.rate;

public class Usd implements Rate {

    private String url;

    private String data;

    private String name = "usd";

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(final String url) {
        this.url = url;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public void setData(final String data) {
        this.data = data;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Usd usd = (Usd) o;
        return name != null ? name.equals(usd.name) : usd.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Usd{" +
                "url='" + url + '\'' +
                ", data='" + data + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
