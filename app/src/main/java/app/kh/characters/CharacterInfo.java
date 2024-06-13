package app.kh.characters; 
public final class CharacterInfo{
    private int count;
    private int totalPages;

    private Object previousPage;
    private Object nextPage;

    public int getCount() {
        return count;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public Object getPreviousPage() {
        return previousPage;
    }

    public Object getNextPage() {
        return nextPage;
    }
}
