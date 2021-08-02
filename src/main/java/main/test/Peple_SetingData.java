package main.test;

import javax.swing.ImageIcon;

public class Peple_SetingData {
    String candidateName;
    String candidateParty;
    String symbolNumber;
    double candidatePercentage;
    ImageIcon icon;
    ImageIcon backgroundImage;

    //후보 인물 이미지 연결 해주시면 됩니다.
    //후보 인물 이미지 연결 해주시면 됩니다.
    //후보 인물 이미지 연결 해주시면 됩니다.
    //후보 인물 이미지 연결 해주시면 됩니다.
    //후보 인물 이미지 연결 해주시면 됩니다.
    //후보 인물 이미지 연결 해주시면 됩니다.
    //후보 인물 이미지 연결 해주시면 됩니다.

    public Peple_SetingData() {

    }
    public void peple(String name,double num) {
        if(name.equals("이재명")){
            icon = new ImageIcon("party_name_color/blue_white.png");
            backgroundImage = new ImageIcon("party_name_color/blue_white.png");
            candidateName=name;
            candidateParty="더불어민주당";
            candidatePercentage=num;
            symbolNumber="1";
        }
        else if(name.equals("이낙연")) {
            icon = new ImageIcon("party_name_color/blue_white.png");
            backgroundImage = new ImageIcon("party_name_color/blue_white.png");
            candidateName=name;
            candidateParty="더불어민주당";
            candidatePercentage=num;
            symbolNumber="1";
        }
        else if(name.equals("정세균")) {
            icon = new ImageIcon("party_name_color/blue_white.png");
            backgroundImage = new ImageIcon("party_name_color/blue_white.png");
            candidateName=name;
            candidateParty="더불어민주당";
            candidatePercentage=num;
            symbolNumber="1";
        }
        else if(name.equals("추미애")) {
            icon = new ImageIcon("party_name_color/blue_white.png");
            backgroundImage = new ImageIcon("party_name_color/blue_white.png");
            candidateName=name;
            candidateParty="더불어민주당";
            candidatePercentage=num;
            symbolNumber="1";
        }
        else if(name.equals("김두관")) {
            icon = new ImageIcon("party_name_color/blue_white.png");
            backgroundImage = new ImageIcon("party_name_color/blue_white.png");
            candidateName=name;
            candidateParty="더불어민주당";
            candidatePercentage=num;
            symbolNumber="1";
        }
        else if(name.equals("박용진")) {
            icon = new ImageIcon("party_name_color/blue_white.png");
            backgroundImage = new ImageIcon("party_name_color/blue_white.png");
            candidateName=name;
            candidateParty="더불어민주당";
            candidatePercentage=num;
            symbolNumber="1";
        }
        else if(name.equals("이준석")) {
            icon = new ImageIcon("party_name_color/blue_white.png");
            backgroundImage = new ImageIcon("party_name_color/red_white.png");
            candidateName=name;
            candidateParty="국민의힘";
            candidatePercentage=num;
            symbolNumber="2";
        }
        else if(name.equals("홍준표")) {
            icon = new ImageIcon("party_name_color/puple_white.png");
            backgroundImage = new ImageIcon("party_name_color/red_white.png");
            candidateName=name;
            candidateParty="국민의힘";
            candidatePercentage=num;
            symbolNumber="2";
        }
        else if(name.equals("최재형")) {
            icon = new ImageIcon("party_name_color/blue_white.png");
            backgroundImage = new ImageIcon("party_name_color/red_white.png");
            candidateName=name;
            candidateParty="국민의힘";
            candidatePercentage=num;
            symbolNumber="2";
        }
        else if(name.equals("윤석열")) {
            icon = new ImageIcon("party_name_color/blue_white.png");
            backgroundImage = new ImageIcon("party_name_color/red_white.png");
            candidateName=name;
            candidateParty="국민의힘";
            candidatePercentage=num;
            symbolNumber="2";
        }

        else if(name.equals("심상정")) {
            icon = new ImageIcon("party_name_color/blue_white.png");
            backgroundImage = new ImageIcon("party_name_color/yellow_black.png");
            candidateName=name;
            candidateParty="정의당";
            candidatePercentage=num;
            symbolNumber="3";
        }
        else if(name.equals("안철수")) {
            icon = new ImageIcon("party_name_color/blue_white.png");
            backgroundImage = new ImageIcon("party_name_color/orange_white.png");
            candidateName=name;
            candidateParty="국민의당";
            candidatePercentage=num;
            symbolNumber="4";
        }
    }
}
