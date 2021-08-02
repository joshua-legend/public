package simulation;

import javax.swing.ImageIcon;

public class Peple_SetingData {
    String candidateName;
    String candidateParty;
    String symbolNumber;
    double candidatePercentage;
    ImageIcon icon;
    ImageIcon backgroundImage;
    public Peple_SetingData() {

    }
    public void peple(String name,double num) {
        if(name.equals("이재명")){
            icon = new ImageIcon("img/people/"+name+".png");
            backgroundImage = new ImageIcon("party_name_color/blue_white.png");
            candidateName=name;
            candidateParty="더불어민주당";
            candidatePercentage=num;
            symbolNumber="1";
        }
        else if(name.equals("이낙연")) {
            icon = new ImageIcon("img/people/"+name+".png");
            backgroundImage = new ImageIcon("party_name_color/blue_white.png");
            candidateName=name;
            candidateParty="더불어민주당";
            candidatePercentage=num;
            symbolNumber="1";
        }
        else if(name.equals("정세균")) {
            icon = new ImageIcon("img/people/"+name+".png");
            backgroundImage = new ImageIcon("party_name_color/blue_white.png");
            candidateName=name;
            candidateParty="더불어민주당";
            candidatePercentage=num;
            symbolNumber="1";
        }
        else if(name.equals("허경영")) {
            icon = new ImageIcon("img/people/"+name+".png");
            backgroundImage = new ImageIcon("party_name_color/darkRed_white.png");
            candidateName=name;
            candidateParty="국가혁명당";
            candidatePercentage=num;
            symbolNumber="8";
        }
        else if(name.equals("김두관")) {
            icon = new ImageIcon("img/people/"+name+".png");
            backgroundImage = new ImageIcon("party_name_color/blue_white.png");
            candidateName=name;
            candidateParty="더불어민주당";
            candidatePercentage=num;
            symbolNumber="1";
        }
        else if(name.equals("원희룡")) {
            icon = new ImageIcon("img/people/"+name+".png");
            backgroundImage = new ImageIcon("party_name_color/blue_white.png");
            candidateName=name;
            candidateParty="국민의힘";
            candidatePercentage=num;
            symbolNumber="2";
        }
        else if(name.equals("유승민")) {
            icon = new ImageIcon("img/people/"+name+".png");
            backgroundImage = new ImageIcon("party_name_color/red_white.png");
            candidateName=name;
            candidateParty="국민의힘";
            candidatePercentage=num;
            symbolNumber="2";
        }
        else if(name.equals("홍준표")) {
            icon = new ImageIcon("img/people/"+name+".png");
            backgroundImage = new ImageIcon("party_name_color/red_white.png");
            candidateName=name;
            candidateParty="국민의힘";
            candidatePercentage=num;
            symbolNumber="2";
        }
        else if(name.equals("최재형")) {
            icon = new ImageIcon("img/people/"+name+".png");
            backgroundImage = new ImageIcon("party_name_color/red_white.png");
            candidateName=name;
            candidateParty="국민의힘";
            candidatePercentage=num;
            symbolNumber="2";
        }
        else if(name.equals("윤석열")) {
            icon = new ImageIcon("img/people/"+name+".png");
            backgroundImage = new ImageIcon("party_name_color/red_white.png");
            candidateName=name;
            candidateParty="국민의힘";
            candidatePercentage=num;
            symbolNumber="2";
        }

        else if(name.equals("심상정")) {
            icon = new ImageIcon("img/people/"+name+".png");
            backgroundImage = new ImageIcon("party_name_color/yellow_black.png");
            candidateName=name;
            candidateParty="정의당";
            candidatePercentage=num;
            symbolNumber="3";
        }
        else if(name.equals("안철수")) {
            icon = new ImageIcon("img/people/"+name+".png");
            backgroundImage = new ImageIcon("party_name_color/orange_white.png");
            candidateName=name;
            candidateParty="국민의당";
            candidatePercentage=num;
            symbolNumber="4";
        }
    }
}
