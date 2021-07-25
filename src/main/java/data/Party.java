package data;

public enum Party {
    더불어민주당("#1976d2"), 국민의힘("#c62828"), 국민의당("#f47e17"),정의당("#fff176"), 무소속("#afc2cb");
    final private String color;
    Party(String color) {
        this.color = color;
    }
    public String getColor() { // 문자를 받아오는 함수
        return color;
    }
}
