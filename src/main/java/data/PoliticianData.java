package data;

import javax.swing.*;
import java.util.HashMap;

public class PoliticianData {

    //    안철수,유승민,윤석열,이낙연,이재명,이준석,정세균,추미애,홍준표

    public static HashMap<String,PoliticianVO> map = new HashMap<>();

    public PoliticianData() {
        map.put("김두관",new PoliticianVO("김두관","KIMDOOKWAN",new ImageIcon("img/people/김두관.png"), Party.더불어민주당.getColor(), Party.더불어민주당,"제21대 국회의원"));
        map.put("윤석열",new PoliticianVO("윤석열","YUNSUKYEOL",new ImageIcon("img/people/윤석열.png"), Party.무소속.getColor(), Party.무소속,"제43대 검찰총장"));
        map.put("심상정",new PoliticianVO("심상정","SIMSANGJUNG",new ImageIcon("img/people/심상정.png"), Party.정의당.getColor(), Party.정의당,"제21대 국회의원"));
        map.put("안철수",new PoliticianVO("안철수","AHNCHEOLSOO",new ImageIcon("img/people/안철수.png"), Party.국민의당.getColor(), Party.국민의당, "국민의당 대표"));
        map.put("최재형",new PoliticianVO("최재형","CHOIJAEHYOUNG",new ImageIcon("img/people/최재형.png"), Party.국민의힘.getColor(), Party.국민의힘, "서울특별시장"));
        map.put("이낙연",new PoliticianVO("이낙연","LEENAKYEON",new ImageIcon("img/people/이낙연.png"), Party.더불어민주당.getColor(), Party.더불어민주당,"제21대 국회의원"));
        map.put("이재명",new PoliticianVO("이재명","LEEJAEMYOUNG",new ImageIcon("img/people/이재명.png"), Party.더불어민주당.getColor(), Party.더불어민주당, "경기도지사"));
        map.put("정세균",new PoliticianVO("정세균","JUNGSYEKYUN",new ImageIcon("img/people/정세균.png"), Party.더불어민주당.getColor(), Party.더불어민주당, "더불어민주당 상임고문"));
        map.put("홍준표",new PoliticianVO("홍준표","HONGJOONPYO",new ImageIcon("img/people/홍준표.png"), Party.국민의힘.getColor(), Party.국민의힘, "제21대 국회의원"));
        map.put("유승민",new PoliticianVO("유승민","YOOSEUNGMIN",new ImageIcon("img/people/유승민.png"), Party.국민의힘.getColor(), Party.국민의힘, "공동선대위원장"));
        map.put("허경영",new PoliticianVO("허경영","HUHKYUNGYOUNG",new ImageIcon("img/people/허경영.png"), Party.국가혁명당.getColor(), Party.국가혁명당, "국가혁명당 명예대표"));
        map.put("원희룡",new PoliticianVO("원희룡","WONHEEYOUNG",new ImageIcon("img/people/원희룡.png"), Party.국민의힘.getColor(), Party.국민의힘, "제주도지사"));
    }

}
/*
*
* CREATE TABLE KIMDOOKWAN
(
    time        DATE    NOT NULL,
    interest    INT     NOT NULL,
     PRIMARY KEY (time)
)
*
* */