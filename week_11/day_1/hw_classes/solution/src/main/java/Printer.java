public class Printer {

    private int paperCount;
    private int tonerVolume;

    public Printer(int paperCount, int tonerVolume) {
        this.paperCount = paperCount;
        this.tonerVolume = tonerVolume;
    }

    public int getPaperCount() {
        return paperCount;
    }

    public int getTonerVolume() {
        return tonerVolume;
    }

    public void print(int copies, int pages){
        int totalPages = copies * pages;
        if (totalPages < paperCount){
            this.paperCount -= totalPages;
            this.tonerVolume -= totalPages;
        }
    }
}
