package alex.ru.rate;

public class Cny implements Rate {

    private String url;

    private String data;

    private String name = "cny";

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
        final Cny cny = (Cny) o;
        return name.equals(cny.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Cny{" +
                "url='" + url + '\'' +
                ", data='" + data + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}