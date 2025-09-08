public class Context {
    private Sorter sorter;

    public Context() {
    }

    public void sort(int[] arr) {
        if (sorter == null) {
            throw new IllegalStateException("Sorter has not been set");
        } else {
            sorter.returnSorted(arr);
        }
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

}