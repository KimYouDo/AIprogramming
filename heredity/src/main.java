import java.util.*;

public class main {
    static List<String[]> Teacher = new ArrayList<String[]>();
    static List<String[]> Teacher2 = new ArrayList<String[]>();
    static String[][][] School_Time = new String[6][20][5];
    static String[][] Teacher_Time = new String[20][5];
    static String[][][] School_Time_save= new String[6][20][5];
    static String[][] Teacher_Time_save = new String[20][5];
    static List<String> text_list = new ArrayList<String>();
    static List<String> num_list = new ArrayList<String>();
    static Random random = new Random();
    static int [] Normal_Room = {411, 511, 605, 606, 609, 610, 418, 517};
    static int [] Compurt_Room = {418, 517, 608};
    static int Level_Input_Count=0;
    public static void main(String[] args) {
        String[] KHY = {"KHY","이산수학-(3/0)", "디지털시스템 설계-(2/2)", "디지털시스템 설계-(2/2)", "고급 소프트웨어 테스팅-(3/0)"};//권호열 교수님
        String[] KMB = {"KMB","이산수학-(3/0)", "영상통신-(3/0)", "컴퓨터그래픽스 및 응용-(3/0)"}; //김만배 교수님
        String[] KYS = {"KYS","리눅스시스템 및 실습-(2/2)", "마이크로프로세서-(3/0)", "마이크로프로세서-(3/0)", "알고리즘-(3/0)"};
        String[] KHS = {"KHS","자연어처리-(2/2)", "자연어처리와지식마이닝-(2/2)", "자연어처리프로젝트-(3/0)"}; //김학수 교수임
        String[] KHJ = {"KHJ","분산데이터처리 및 실습-(2/2)", "IT융합프로젝트-(3/0)"};  //김화종 교수님
        String[] SHS = {"SHS","자료구조-(2/2)", "자료구조-(2/2)", "인공지능-(3/0)", "고급기계학습론-(3/0)"}; //석호식 교수임
        String[] LGY = {"LGY","컴퓨터네트워크-(3/0)", "네트워크보안-(3/0)"};
        String[] LHG = {"LHG","자바프로그래밍-(2/2)", "리눅스시스템 및 실습-(2/2)", "컴퓨터시스템 보안-(3/0)"}; //이헌길 교수님
        String[] JIB = {"JIB","리눅스시스템 및 실습-(2/2)", "임베디드시스템-(2/2)", "임베디드시스템-(2/2)", "컴퓨터시스템 설계-(3/0)"};//정인범 교수님
        String[] JCK = {"JCK","자바프로그래밍-(2/2)", "자바프로그래밍-(2/2)", "통계학-(3/0)"};//정충교 교수님
        String[] CCY = {"CCY","논리회로-(3/0)", "논리회로-(3/0)", "소프트웨어융합프로젝트-(3/0)"}; //최창열 교수님
        String[] CHK = {"CHK","자료구조-(2/2)"}; //최황규 교수님
        String[] HJY = {"HJY","문제해결프로그래밍-(2/2)", "문제해결프로그래밍-(2/2)", "HCI-(3/0)"}; //하진영 교수님
        String[] HHK = {"HHK","자료구조-(2/2)"}; //황환규 교수님

        Teacher2.add(CCY);      Teacher2.add(KMB);      Teacher2.add(KYS);         Teacher2.add(KHJ);     Teacher2.add(CHK);
        Teacher2.add(SHS);      Teacher2.add(LGY);      Teacher2.add(LHG);         Teacher2.add(JIB);     Teacher2.add(HHK);
        Teacher2.add(KHS);      Teacher2.add(HJY);      Teacher2.add(JCK);         Teacher2.add(KHY);

        String[] Level2 = {"자료구조-(2/2)", "마이크로프로세서-(3/0)", "문제해결프로그래밍-(2/2)", "디지털시스템 설계-(2/2)"};
        String[] Level3 = {"임베디드시스템-(2/2)", "컴퓨터네트워크-(3/0)", "HCI-(3/0)", "인공지능-(3/0)", "영상처리-(3/0)"};
        String[] Level4 = {"컴퓨터시스템 보안-(3/0)", "영상통신-(3/0)", "자연어처리-(2/2)", "네트워크보안-(3/0)"};

        int min=100;
        for(int i=0; i<Teacher2.size(); i++)
            Teacher.add(Teacher2.get(i));

for(int check=0; check<10; check+=0) {
    for(int i=0; i<Teacher2.size(); i++)
        Teacher.set(i,Teacher2.get(i));

    School_Time = new String[6][20][5];
    Teacher_Time = new String[20][5];

    for (int ReCheck = 0; ReCheck < 4; ReCheck++) {
        TimeLevel_Input(Level4, 2);
        TimeLevel_Input(Level3, 1);
        TimeLevel_Input(Level2, 0);
    }

    TimeSubject_Input(3);
    int count1= TimeSubject_Input(4);
    int count2 = TimeSubject_Input(5);

    if (Level_Input_Count >= 19 && min > count1) {
        min = count1;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 5; j++) {
                Teacher_Time_save[i][j] = Teacher_Time[i][j];
            }
        }

        for (int n = 0; n < 6; n++)
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 5; j++) {
                    School_Time_save[n][i][j] = School_Time[n][i][j];
                }
            }
    }

    if(count2==0)
        check++;
}
        Teacher_Time=Teacher_Time_save;
        School_Time=School_Time_save;

        System.out.println("\n------------2-----------\n");
for(int i=0; i<20; i++) {
    for(int j=0; j<5;j++) {
      //  System.out.printf("%-20s",School_Time[1][i][j]);
        if(School_Time[0][i][j]!=null) {
            System.out.print(School_Time[0][i][j]);
            for (int c = 0; c < 30 - School_Time[0][i][j].length()-4; c++)
                System.out.print(" ");
        }
        else {
            for (int c = 0; c < 30; c++)
                System.out.print(" ");
        }
        System.out.print("|   ");
    }
    if(i%2==1)
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------"+(int)i/2);
    else
        System.out.println("\n");
}

        System.out.println("\n------------3-----------\n");
        for(int i=0; i<20; i++) {
            for(int j=0; j<5;j++) {
                //  System.out.printf("%-20s",School_Time[1][i][j]);
                if(School_Time[1][i][j]!=null) {
                    System.out.print(School_Time[1][i][j]);
                    for (int c = 0; c < 30 - School_Time[1][i][j].length()-4; c++)
                        System.out.print(" ");
                }
                else {
                    for (int c = 0; c < 30; c++)
                        System.out.print(" ");
                }
                System.out.print("|   ");
            }
            if(i%2==1)
                System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------"+(int)i/2);
            else
                System.out.println("\n");
        }


        System.out.println("\n------------4-----------\n");

        for(int i=0; i<20; i++) {
            for(int j=0; j<5;j++) {
                //  System.out.printf("%-20s",School_Time[1][i][j]);
                if(School_Time[2][i][j]!=null) {
                    System.out.print(School_Time[2][i][j]);
                    for (int c = 0; c < 30 - School_Time[2][i][j].length()-4; c++)
                        System.out.print(" ");
                }
                else {
                    for (int c = 0; c < 30; c++)
                        System.out.print(" ");
                }
                System.out.print("|   ");
            }
            if(i%2==1)
                System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------"+(int)i/2);
            else
                System.out.println("\n");
        }


        System.out.println("\n------------01-----------\n");

        for(int i=0; i<20; i++) {
            for(int j=0; j<5;j++) {
                //  System.out.printf("%-20s",School_Time[1][i][j]);
                if(School_Time[3][i][j]!=null) {
                    System.out.print(School_Time[3][i][j]);
                    for (int c = 0; c < 30 - School_Time[3][i][j].length()-4; c++)
                        System.out.print(" ");
                }
                else {
                    for (int c = 0; c < 30; c++)
                        System.out.print(" ");
                }
                System.out.print("|   ");
            }
            if(i%2==1)
                System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------"+(int)i/2);
            else
                System.out.println("\n");
        }


        System.out.println("\n------------02-----------\n");

        for(int i=0; i<20; i++) {
            for(int j=0; j<5;j++) {
                //  System.out.printf("%-20s",School_Time[1][i][j]);
                if(School_Time[4][i][j]!=null) {
                    System.out.print(School_Time[4][i][j]);
                    for (int c = 0; c < 30 - School_Time[4][i][j].length()-4; c++)
                        System.out.print(" ");
                }
                else {
                    for (int c = 0; c < 30; c++)
                        System.out.print(" ");
                }
                System.out.print("|   ");
            }
            if(i%2==1)
                System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------"+(int)i/2);
            else
                System.out.println("\n");
        }

        System.out.println("\n------------03-----------\n");

        for(int i=0; i<20; i++) {
            for(int j=0; j<5;j++) {
                //  System.out.printf("%-20s",School_Time[1][i][j]);
                if(School_Time[5][i][j]!=null) {
                    System.out.print(School_Time[5][i][j]);
                    for (int c = 0; c < 30 - School_Time[5][i][j].length()-4; c++)
                        System.out.print(" ");
                }
                else {
                    for (int c = 0; c < 30; c++)
                        System.out.print(" ");
                }
                System.out.print("|   ");
            }
            if(i%2==1)
                System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------"+(int)i/2);
            else
                System.out.println("\n");
        }

        System.out.println("\n------------T-----------\n");

        for(int i=0; i<20; i++) {
            for(int j=0; j<5;j++) {

                if(Teacher_Time[i][j]!=null)
                    System.out.printf("%45s",Teacher_Time[i][j]);
                else
                    System.out.printf("%45s"," ");

                System.out.print("|   ");
            }
            if(i%2==1)
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------"+(int)i/2);
            else
                System.out.println("\n");
        }


        for(int i=0; i<Teacher.size(); i++){
            for(int j=0; j<Teacher.get(i).length; j++){
                System.out.print(Teacher.get(i)[j]+" ");
            }
            System.out.println();
        }

    }

   static public int arraySerch( String[] inArray, String name){
        int break_pont;
        for(break_pont=0; break_pont<inArray.length; break_pont++){
            if(inArray[break_pont].equals(name)) {
               return break_pont;
            }
        }
        return 100;
    }


   static public String[] Re_array( String[] inArray, int break_pont) {
        String[] ReArray = new String[inArray.length-1];
        for(int a=0; a<break_pont; a++)
            ReArray[a]=inArray[a];
        for(int a=break_pont; a<inArray.length-1; a++)
            ReArray[a]=inArray[a+1];

        return ReArray;
    }

    static  public void TimeLevel_Input(String[] Level,int School_Lenel) {
        int ok_pont;
            for (int i = 0; i < Level.length; i++) {
                for (int j = 0; j < Teacher.size(); j++) {
                    ok_pont = arraySerch(Teacher.get(j), Level[i]);
                    int Day = random.nextInt(5);
                    if (ok_pont != 100) {
                        String[] Disparity = Level[i].split("-");
                        System.out.println(Disparity[0] + "\n" + Disparity[1]);
                        if (Disparity[1].charAt(1) == '2')
                            Level_Input_Count+= Input2_Subject(School_Lenel, Day, Disparity, Teacher.get(j)[0], ok_pont, j);
                        else
                            Level_Input_Count+= Input3_Subject(School_Lenel, Day, Disparity, Teacher.get(j)[0], ok_pont, j);
                        text_list.add(Level[i]+"-"+Teacher.get(j)[0]);
                    }
                }
            }
        }

    static  public int TimeSubject_Input(int num){
       int end=0;
       int j=1;
       int Input_count=0;
        for(int i=0; i<Teacher.size(); i++){
            j=Teacher.get(i).length-1;
            while (true){
                if(j<1)
                    break;

                    String[] Disparity =Teacher.get(i)[j].split("-");
                int Day = random.nextInt(5);
                    System.out.println(Disparity[0] + "\n" + Disparity[1]);
                    if(Disparity[1].charAt(1)=='2')
                        end=Input2_Subject(num, Day, Disparity, Teacher.get(i)[0], j, i);
                    else
                        end=Input3_Subject(num, Day, Disparity, Teacher.get(i)[0], j, i);
                Input_count+=end;
                        j--;
            }
        }
        return  Input_count;
    }


    public static int Input2_Subject(int num, int Day, String[]Disparity, String TeacherName, int ok_pont, int TeacherNum) {
        int input1=0;
        int Time1=0, Day1=0;
        String message1="";
        String Room_number1="";
        String Room_number2="";
        int input2=0;
        int Time2=0, Day2=0;
        String message2="";

            for(int z=0; z<=5; z++){
                if((!TeacherName.equals("JCK")&&!TeacherName.equals("SHS")&&!TeacherName.equals("KHY")
                        &&!TeacherName.equals("KHJ")&&!TeacherName.equals("KHS")&&!TeacherName.equals("CHK"))&&Day==4){

                }
                else
                for (int Time = 2; Time < 17; Time+=2) {

                    if(!TeacherName.equals("KMB")&&(Time==6||Time==8)){

                    }
                    else if((TeacherName.equals("LHG")||TeacherName.equals("KHS"))&&Time==2){

                    }
                    else if((!(Teacher_Time[Time][Day]==null)&&Teacher_Time[Time][Day].contains(TeacherName))
                            ||(!(Teacher_Time[Time + 1][Day]==null)&&Teacher_Time[Time + 1][Day].contains(TeacherName))
                            ||(!(Teacher_Time[Time + 2][Day]==null)&&Teacher_Time[Time + 2][Day].contains(TeacherName))
                            ||(!(Teacher_Time[Time + 3][Day]==null)&&Teacher_Time[Time + 3][Day].contains(TeacherName))){

                    }

                    else if (School_Time[num][Time][Day] == null && School_Time[num][Time + 1][Day] == null
                            &&School_Time[num][Time+2][Day] == null && School_Time[num][Time + 3][Day] == null) {
                       while (true) {
                            Room_number1 =Normal_Room[random.nextInt(6)]+"";
                           if((Teacher_Time[Time][Day]==null)||!(Teacher_Time[Time][Day].contains(Room_number1)))
                                break;
                        }

                        Time1=Time;
                        Day1=Day;

                        message1="2 "+Disparity[0] + " " + TeacherName +" "+  Room_number1;

                        input1 = 1;
                        break;
                    }
                }
                if(input1==1)
                    break;
                Day=z;
            }


            int onDay=Day;
            while (true) {
                int n = random.nextInt(5);
                if (Day != n) {
                    Day = n;
                    break;
                }
            }

            for(int z=0; z<=5; z++) {
                if((!TeacherName.equals("JCK")&&!TeacherName.equals("SHS")&&!TeacherName.equals("KHY")
                        &&!TeacherName.equals("KHJ")&&!TeacherName.equals("KHS")&&!TeacherName.equals("CHK"))&&Day==4){

                }
                else
                for (int Time = 2; Time < 17; Time+=2) {

                    if((!(Teacher_Time[Time][Day]==null)&&Teacher_Time[Time][Day].contains(TeacherName))
                            ||(!(Teacher_Time[Time + 1][Day]==null)&&Teacher_Time[Time + 1][Day].contains(TeacherName))
                            ||(!(Teacher_Time[Time + 2][Day]==null)&&Teacher_Time[Time + 2][Day].contains(TeacherName))
                            ||(!(Teacher_Time[Time + 3][Day]==null)&&Teacher_Time[Time + 3][Day].contains(TeacherName))){

                    }
                    else if((TeacherName.equals("LHG")||TeacherName.equals("KHS"))&&Time==2){

                    }
                    else if (School_Time[num][Time][Day] == null && School_Time[num][Time + 1][Day] == null
                            &&School_Time[num][Time+2][Day] == null && School_Time[num][Time + 3][Day] == null) {
                        int count=0;
                        while (true) {
                            Room_number2 = Compurt_Room[random.nextInt(3)]+"";
                            if((Teacher_Time[Time][Day]==null)||!(Teacher_Time[Time][Day].contains(Room_number2)))
                                break;
                            count++;
                            if(count==20)
                                break;
                        }

                        Time2=Time;
                        Day2=Day;
                        message2="2 "+Disparity[0] + " " + TeacherName +" "+Room_number2;

                        input2=1;
                        break;
                    }
                }
                if(z==onDay)
                    z++;
                if(input2==1)
                    break;
                Day=z;
            }


        if(input1==1&&input2==1){

            School_Time[num][Time1][Day1] = message1;
            School_Time[num][Time1+1][Day1] = message1;
            School_Time[num][Time1+2][Day1] = message1;
            School_Time[num][Time1+3][Day1] = message1;

            Teacher_Time[Time1][Day1] += TeacherName + " "+Room_number1+" ";
            Teacher_Time[Time1 + 1][Day1] +=TeacherName + " "+Room_number1+" ";
            Teacher_Time[Time1 + 2][Day1] += TeacherName + " "+Room_number1+" ";
            Teacher_Time[Time1 + 3][Day1] +=TeacherName + " "+Room_number1+" ";


            School_Time[num][Time2][Day2] = message2;
            School_Time[num][Time2+1][Day2] = message2;
            School_Time[num][Time2+2][Day2] = message2;
            School_Time[num][Time2+3][Day2] = message2;

            Teacher_Time[Time2][Day2] += TeacherName + " "+Room_number2+" ";
            Teacher_Time[Time2 + 1][Day2] += TeacherName + " "+Room_number2+" ";
            Teacher_Time[Time2 + 2][Day2] += TeacherName + " "+Room_number2+" ";
            Teacher_Time[Time2 + 3][Day2] += TeacherName + " "+Room_number2+" ";

            Teacher.set(TeacherNum,Re_array(Teacher.get(TeacherNum), ok_pont));

          // num_list.add();
            return 1;
        }
        return 0;
    }

    public static int Input3_Subject(int num, int Day, String[]Disparity, String TeacherName, int ok_pont, int TeacherNum) {
        int input1=0;
        int input2=0;
        int output=0;
        int re=0;
        String Room_number="";
        int Time1=0, Day1=0;
        int Time2=0, Day2=0;
        String message1="";
        String message2="";

                for(int D=0; D<5; D++) {
                    for (int T = 2; T < 17; T+=3) {
                        if(School_Time[num][T][D]==null){

                        }
                        else if(School_Time[num][T][D].charAt(0)=='3'){
                            School_Time[num][T][D]='0'+School_Time[num][T][D];
                            School_Time[num][T+1][D]='0'+School_Time[num][T+1][D];
                            School_Time[num][T+2][D]='0'+School_Time[num][T+2][D];
                            output=1;
                            Day=D;
                            break;
                        }
                    }
                    if(output==1) {
                        output=0;
                        break;
                    }
                }


            for(int z=0; z<=5; z++){
                if((!TeacherName.equals("JCK")&&!TeacherName.equals("SHS")&&!TeacherName.equals("KHY")
                        &&!TeacherName.equals("KHJ")&&!TeacherName.equals("KHS")&&!TeacherName.equals("CHK"))&&Day==4){

                }
                else
                for (int Time = 2; Time < 17; Time+=3) {

                    if(!TeacherName.equals("KMB")&&(Time==8)){

                    }
                    else if((TeacherName.equals("LHG")||TeacherName.equals("KHS"))&&Time==2){

                    }
                    else if((!(Teacher_Time[Time][Day]==null)&&Teacher_Time[Time][Day].contains(TeacherName))
                            ||(!(Teacher_Time[Time + 1][Day]==null)&&Teacher_Time[Time + 1][Day].contains(TeacherName))
                            ||(!(Teacher_Time[Time + 2][Day]==null)&&Teacher_Time[Time + 2][Day].contains(TeacherName))) {

                    }

                    else if (School_Time[num][Time][Day] == null && School_Time[num][Time + 1][Day] == null&&School_Time[num][Time+2][Day] == null ) {
                        while (true) {
                            Room_number =Normal_Room[random.nextInt(6)]+"";
                            if((Teacher_Time[Time][Day]==null)||!(Teacher_Time[Time][Day].contains(Room_number)))
                                break;
                        }
                        Time1=Time;
                        Day1=Day;

                            message1="3 "+Disparity[0] + " " + TeacherName +" "+  Room_number;

                        input1 = 1;
                        break;
                    }

                }
                if(input1==1)
                    break;
                Day=z;
            }


            int onDay=Day;
            while (true) {
                int n = random.nextInt(5);
                if (onDay != n) {
                    Day = n;
                    break;
                }
            }

            for(int D=0; D<5; D++) {
                for (int T = 2; T < 17; T+=3) {
                    if (onDay == D&&re==0) {
                        D = (D + 1) % 5;
                        re=1;
                    }
                    if(School_Time[num][T][D]==null){

                    }
                    else if(School_Time[num][T][D].charAt(0)=='3'){
                        School_Time[num][T][D]='0'+School_Time[num][T][D];
                        School_Time[num][T+1][D]='0'+School_Time[num][T+1][D];
                        School_Time[num][T+2][D]='0'+School_Time[num][T+2][D];
                        output=1;
                        Day=D;
                        break;
                    }
                }
                if(output==1) {
                    output=0;
                    break;
                }
            }


            for(int z=0; z<=5; z++) {
                if((!TeacherName.equals("JCK")&&!TeacherName.equals("SHS")&&!TeacherName.equals("KHY")
                        &&!TeacherName.equals("KHJ")&&!TeacherName.equals("KHS")&&!TeacherName.equals("CHK"))&&Day==4){

                }
                else
                for (int Time = 2; Time < 17; Time+=3) {
                    if(!TeacherName.equals("KMB")&&(Time==8)){

                    }
                    else if((TeacherName.equals("LHG")||TeacherName.equals("KHS"))&&Time==2){

                    }
                    else if((!(Teacher_Time[Time][Day]==null)&&Teacher_Time[Time][Day].contains(TeacherName)&&Teacher_Time[Time][Day].contains(Room_number+""))
                            ||(!(Teacher_Time[Time + 1][Day]==null)&&Teacher_Time[Time + 1][Day].contains(TeacherName)&&Teacher_Time[Time+1][Day].contains(Room_number+""))
                            ||(!(Teacher_Time[Time + 2][Day]==null)&&Teacher_Time[Time + 2][Day].contains(TeacherName)&&Teacher_Time[Time+2][Day].contains(Room_number+""))){

                    }

                    else if (School_Time[num][Time][Day] == null && School_Time[num][Time + 1][Day] == null &&School_Time[num][Time+2][Day] == null) {
                        Time2=Time;
                        Day2=Day;
                        message2="3 "+Disparity[0] + " " + TeacherName +" "+ Room_number;

                        input2=1;
                        break;
                    }
                }
                if(z==onDay)
                    z++;
                if(input2==1)
                    break;
                Day=z;
            }


        if(input1==1&&input2==1){

            School_Time[num][Time1][Day1] = message1;
            School_Time[num][Time1+1][Day1] = message1;
            School_Time[num][Time1+2][Day1] = message1;

            Teacher_Time[Time1][Day1] += TeacherName + " "+Room_number+" ";
            Teacher_Time[Time1 + 1][Day1] +=TeacherName + " "+Room_number+" ";
            Teacher_Time[Time1 + 2][Day1] += TeacherName + " "+Room_number+" ";


            School_Time[num][Time2][Day2] = message2;
            School_Time[num][Time2+1][Day2] = message2;
            School_Time[num][Time2+2][Day2] = message2;

            Teacher_Time[Time2][Day2] += TeacherName + " "+Room_number+" ";
            Teacher_Time[Time2 + 1][Day2] += TeacherName + " "+Room_number+" ";
            Teacher_Time[Time2 + 2][Day2] += TeacherName + " "+Room_number+" ";


            Teacher.set(TeacherNum,Re_array(Teacher.get(TeacherNum), ok_pont));
            return 1;
        }
        return 0;
    }


}
