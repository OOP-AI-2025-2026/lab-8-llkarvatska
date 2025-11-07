package ua.opnu;

public class BookData implements Comparable<BookData> {

    private String title;
    private String author;
    private int reviews;
    private double total;

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    // Метод для обчислення рейтингу
    public double getRating() {
        if (reviews == 0) return 0; // щоб не ділити на 0
        return total / reviews;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int compareTo(BookData other) {
        double thisRating = this.getRating();
        double otherRating = other.getRating();

        // Чим ВИЩИЙ рейтинг, тим "менше" книжка (тобто має бути попереду при сортуванні)
        if (thisRating > otherRating) {
            return -1;
        } else if (thisRating < otherRating) {
            return 1;
        } else {
            // Якщо рейтинги рівні, порівнюємо за назвою
            return this.title.compareTo(other.title);
        }
    }

    @Override
    public String toString() {
        return "BookData{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", rating=" + String.format("%.2f", getRating()) +
                '}';
    }
}
