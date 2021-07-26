package data;

import javax.swing.*;
import java.util.HashMap;

public class PoliticianData {

    //    안철수,유승민,윤석열,이낙연,이재명,이준석,정세균,추미애,홍준표

    public static HashMap<String,PoliticianVO> map = new HashMap<>();

    public PoliticianData() {
        map.put("김두관",new PoliticianVO("김두관",new ImageIcon("img/people/김두관.png"), Party.더불어민주당.getColor(), Party.더불어민주당));
        map.put("윤석열",new PoliticianVO("윤석열",new ImageIcon("img/people/윤석열.png"), Party.무소속.getColor(), Party.무소속));
        map.put("심상정",new PoliticianVO("심상정",new ImageIcon("img/people/심상정.png"), Party.정의당.getColor(), Party.정의당));
        map.put("안철수",new PoliticianVO("안철수",new ImageIcon("img/people/안철수.png"), Party.국민의당.getColor(), Party.국민의당));
        map.put("오세훈",new PoliticianVO("오세훈",new ImageIcon("img/people/오세훈.png"), Party.국민의힘.getColor(), Party.국민의힘));
        map.put("이낙연",new PoliticianVO("이낙연",new ImageIcon("img/people/이낙연.png"), Party.더불어민주당.getColor(), Party.더불어민주당));
        map.put("이재명",new PoliticianVO("이재명",new ImageIcon("img/people/이재명.png"), Party.더불어민주당.getColor(), Party.더불어민주당));
        map.put("정세균",new PoliticianVO("정세균",new ImageIcon("img/people/정세균.png"), Party.더불어민주당.getColor(), Party.더불어민주당));
        map.put("홍준표",new PoliticianVO("홍준표",new ImageIcon("img/people/홍준표.png"), Party.국민의힘.getColor(), Party.국민의힘));
        map.put("유승민",new PoliticianVO("유승민",new ImageIcon("img/people/유승민.png"), Party.국민의힘.getColor(), Party.국민의힘));
        map.put("허경영",new PoliticianVO("허경영",new ImageIcon("img/people/허경영.png"), Party.국가혁명당.getColor(), Party.국가혁명당));
        map.put("원희룡",new PoliticianVO("원희룡",new ImageIcon("img/people/원희룡.png"), Party.국민의힘.getColor(), Party.국민의힘));
    }

}
