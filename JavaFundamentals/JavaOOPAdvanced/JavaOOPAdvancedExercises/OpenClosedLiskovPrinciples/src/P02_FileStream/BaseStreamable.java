package P02_FileStream;

public abstract class BaseStreamable implements Streamable {

    private int length;
    private int bytesSent;

    public BaseStreamable(int length, int bytesSent) {
        this.setLength(length);
        this.setBytesSent(bytesSent);
    }

    @Override
    public int getLength() {
        return this.length;
    }

    private void setLength(int length) {
        this.length = length;
    }

    @Override
    public int getBytesSent() {
        return this.bytesSent;
    }

    private void setBytesSent(int bytesSent) {
        this.bytesSent = bytesSent;
    }
}