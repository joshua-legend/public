package data;

public enum Party {
    더불어민주당("#1976d2"), 국민의힘("#ef9a9a"), 국민의당("#f47e17"),정의당("#fff176"), 국가혁명당("#7f0000"), 무소속("#afc2cb");
    final private String color;
    Party(String color) {
        this.color = color;
    }
    public String getColor() { // 문자를 받아오는 함수
        return color;
    }
}
