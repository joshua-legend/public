package activityPanel;

public enum Color {
    더불어민주당("#1976d2"), 국민의힘("#c62828");
    final private String color;
    Color(String color) {
        this.color = color;
    }
    public String getColor() { // 문자를 받아오는 함수
        return color;
    }
}
